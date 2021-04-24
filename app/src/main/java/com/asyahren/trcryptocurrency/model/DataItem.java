package com.asyahren.trcryptocurrency.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("symbol")
	private String symbol;

	@SerializedName("circulating_supply")
	private int circulatingSupply;

	@SerializedName("last_updated")
	private String lastUpdated;

	@SerializedName("total_supply")
	private int totalSupply;

	@SerializedName("cmc_rank")
	private int cmcRank;

	@SerializedName("platform")
	private Object platform;

	@SerializedName("tags")
	private List<String> tags;

	@SerializedName("date_added")
	private String dateAdded;

	@SerializedName("quote")
	private Quote quote;

	@SerializedName("num_market_pairs")
	private int numMarketPairs;

	@SerializedName("name")
	private String name;

	@SerializedName("max_supply")
	private int maxSupply;

	@SerializedName("id")
	private int id;

	@SerializedName("slug")
	private String slug;

	public String getSymbol(){
		return symbol;
	}

	public int getCirculatingSupply(){
		return circulatingSupply;
	}

	public String getLastUpdated(){
		return lastUpdated;
	}

	public int getTotalSupply(){
		return totalSupply;
	}

	public int getCmcRank(){
		return cmcRank;
	}

	public Object getPlatform(){
		return platform;
	}

	public List<String> getTags(){
		return tags;
	}

	public String getDateAdded(){
		return dateAdded;
	}

	public Quote getQuote(){
		return quote;
	}

	public int getNumMarketPairs(){
		return numMarketPairs;
	}

	public String getName(){
		return name;
	}

	public int getMaxSupply(){
		return maxSupply;
	}

	public int getId(){
		return id;
	}

	public String getSlug(){
		return slug;
	}
}