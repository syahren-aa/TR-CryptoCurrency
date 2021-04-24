package com.asyahren.trcryptocurrency.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CryptoData{

	@SerializedName("data")
	@Expose
	private List<DataItem> data;

	@SerializedName("status")
	@Expose
	private Status status;

	public List<DataItem> getData(){
		return data;
	}

	public Status getStatus(){
		return status;
	}
}