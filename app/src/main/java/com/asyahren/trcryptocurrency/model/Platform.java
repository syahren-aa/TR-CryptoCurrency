package com.asyahren.trcryptocurrency.model;

import com.google.gson.annotations.SerializedName;

public class Platform{

	@SerializedName("symbol")
	private String symbol;

	@SerializedName("name")
	private String name;

	@SerializedName("token_address")
	private String tokenAddress;

	@SerializedName("id")
	private int id;

	@SerializedName("slug")
	private String slug;

	public String getSymbol(){
		return symbol;
	}

	public String getName(){
		return name;
	}

	public String getTokenAddress(){
		return tokenAddress;
	}

	public int getId(){
		return id;
	}

	public String getSlug(){
		return slug;
	}
}