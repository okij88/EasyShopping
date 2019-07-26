package com.es.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.apache.bcel.generic.ReturnaddressType;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.es.bean.Msg;
import com.es.untils.FtpUtil;
import com.es.untils.IDUtils;
@Service
public class PictureServiceImpl implements PictureService {
	@Value("${FTP_ADDRESS}")
	private String FTP_ADDRESS;
	@Value("${FTP_PORT}")
	private Integer FTP_PORT;
	@Value("${FTP_USERNAME}")
	private String FTP_USERNAME;
	@Value("${FTP_PASSWORD}")
	private String FTP_PASSWORD;
	@Value("${FTP_BASE_PATH}")
	private String FTP_BASE_PATH;
	@Value("${IMAGE_BASE_URL}")
	private String IMAGE_BASE_URL;
	
	
	@SuppressWarnings("unchecked")
	public Map uploadPicture(MultipartFile uploadFile) {
		Map node = new HashMap<Object, Object>();
		try {
			String oldName = uploadFile.getOriginalFilename();
			String newName = IDUtils.genImageName();
			newName = newName + oldName.substring(oldName.lastIndexOf("."));
			
			String imgPath = new DateTime().toString("/yyyy/MM/dd");
			boolean result = FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USERNAME, FTP_PASSWORD, 
					FTP_BASE_PATH, imgPath, newName, uploadFile.getInputStream());
			if(!result) {
				node.put("message", "文件上传失败");
				return node;
			}
			node.put("url", IMAGE_BASE_URL + imgPath + "/" + newName);
			node.put("message", "文件上传成功");
			return node;
		} catch (Exception e) {
			// TODO: handle exception
			node.put("message", "文件上传失败");
			return node;
		}
		
	}

}
