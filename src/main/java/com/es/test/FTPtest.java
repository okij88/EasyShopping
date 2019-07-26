package com.es.test;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

public class FTPtest {
	@Test
	public void testFTP() throws Exception{
		FTPClient ftpClient = new FTPClient();
		ftpClient.connect("192.168.92.132",21);
		ftpClient.login("ftpuser", "wangji123");
		FileInputStream inputStream = new FileInputStream(new File("D:\\image\\test.jpg"));
		ftpClient.changeWorkingDirectory("/home/ftpuser/www/images");
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
		ftpClient.storeFile("test.jpg", inputStream);
		inputStream.close();
		
		ftpClient.logout();

	}
}
