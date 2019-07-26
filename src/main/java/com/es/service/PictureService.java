package com.es.service;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.es.bean.Msg;

public interface PictureService {
	public Map uploadPicture(MultipartFile uploadFile);
}
