package com.asyahren.trcryptocurrency.model;

import com.google.gson.annotations.SerializedName;

public class Status{

	@SerializedName("error_message")
	private Object errorMessage;

	@SerializedName("elapsed")
	private int elapsed;

	@SerializedName("total_count")
	private int totalCount;

	@SerializedName("credit_count")
	private int creditCount;

	@SerializedName("error_code")
	private int errorCode;

	@SerializedName("timestamp")
	private String timestamp;

	@SerializedName("notice")
	private Object notice;

	public Object getErrorMessage(){
		return errorMessage;
	}

	public int getElapsed(){
		return elapsed;
	}

	public int getTotalCount(){
		return totalCount;
	}

	public int getCreditCount(){
		return creditCount;
	}

	public int getErrorCode(){
		return errorCode;
	}

	public String getTimestamp(){
		return timestamp;
	}

	public Object getNotice(){
		return notice;
	}
}