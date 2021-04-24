package com.asyahren.trcryptocurrency.model;

import com.google.gson.annotations.SerializedName;

public class Quote{

	@SerializedName("USD")
	private USD uSD;

	public USD getUSD(){
		return uSD;
	}
}