package com.es.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.es.bean.Item;
import com.es.bean.Msg;
import com.es.service.ItemService;
import com.es.service.PictureService;
import com.es.service.PictureServiceImpl;

@Controller
public class PictureController {
	@Autowired
	private PictureService pictureService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/upload")
	@ResponseBody
	public Msg uploadImage(@RequestParam MultipartFile file)throws IOException {
		@SuppressWarnings("rawtypes")
		Map node = pictureService.uploadPicture(file);
		return Msg.success().add("result", node);
	}
}
