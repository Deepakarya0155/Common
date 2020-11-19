package com.common.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class RequestDO {
	String strData;
	Date dateData;
	MultipartFile fileData;
	public String getStrData() {
		return strData;
	}
	public void setStrData(String strData) {
		this.strData = strData;
	}
	public Date getDateData() {
		return dateData;
	}
	public void setDateData(Date dateData) {
		this.dateData = dateData;
	}
	public MultipartFile getFileData() {
		return fileData;
	}
	public void setFileData(MultipartFile fileData) {
		this.fileData = fileData;
	}
	
	

}
