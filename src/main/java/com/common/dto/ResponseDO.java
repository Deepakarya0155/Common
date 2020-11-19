package com.common.dto;

public class ResponseDO {
	
	Object data;
	Integer ErrorCode;
	String ErrorMessage;
	
	
	
	public ResponseDO(Object data, Integer errorCode, String errorMessage) {
		super();
		this.data = data;
		ErrorCode = errorCode;
		ErrorMessage = errorMessage;
	}


	public Object getData() {
		return data;
	}


	public void setData(Object data) {
		this.data = data;
	}


	public Integer getErrorCode() {
		return ErrorCode;
	}


	public void setErrorCode(Integer errorCode) {
		ErrorCode = errorCode;
	}


	public String getErrorMessage() {
		return ErrorMessage;
	}


	public void setErrorMessage(String errorMessage) {
		ErrorMessage = errorMessage;
	}


	@Override
	public String toString() {
		return "ResponseDO [data=" + data + ", ErrorCode=" + ErrorCode + ", ErrorMessage=" + ErrorMessage + "]";
	}
	
	

}
