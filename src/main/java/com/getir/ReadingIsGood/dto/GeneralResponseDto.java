package com.getir.ReadingIsGood.dto;

public class GeneralResponseDto {
	
	private String responseMessage;
	private String responseStatus;
	
	public GeneralResponseDto() {
		super();
	}
	public GeneralResponseDto(String responseMessage, String responseStatus) {
		super();
		this.responseMessage = responseMessage;
		this.responseStatus = responseStatus;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	public String getResponseStatus() {
		return responseStatus;
	}
	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}
	@Override
	public String toString() {
		return "GeneralResponseDto [responseMessage=" + responseMessage + ", responseStatus=" + responseStatus + "]";
	}
	
	

}
