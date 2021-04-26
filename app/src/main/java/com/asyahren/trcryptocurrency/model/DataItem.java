package com.asyahren.trcryptocurrency.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataItem implements Parcelable {


	@SerializedName("id")
	@Expose
	private Integer id;
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("symbol")
	@Expose
	private String symbol;
	@SerializedName("slug")
	@Expose
	private String slug;
	@SerializedName("circulating_supply")
	@Expose
	private Double circulatingSupply;
	@SerializedName("total_supply")
	@Expose
	private Double totalSupply;
	@SerializedName("max_supply")
	@Expose
	private Double maxSupply;
	@SerializedName("date_added")
	@Expose
	private String dateAdded;
	@SerializedName("num_market_pairs")
	@Expose
	private Integer numMarketPairs;
	@SerializedName("cmc_rank")
	@Expose
	private Integer cmcRank;
	@SerializedName("last_updated")
	@Expose
	private String lastUpdated;
	@SerializedName("quote")
	@Expose
	private com.asyahren.trcryptocurrency.model.Quote quote;
	private final static long serialVersionUID = 991796161238960817L;

	protected DataItem(Parcel in) {
		if (in.readByte() == 0) {
			id = null;
		} else {
			id = in.readInt();
		}
		name = in.readString();
		symbol = in.readString();
		slug = in.readString();
		if (in.readByte() == 0) {
			circulatingSupply = null;
		} else {
			circulatingSupply = in.readDouble();
		}
		if (in.readByte() == 0) {
			totalSupply = null;
		} else {
			totalSupply = in.readDouble();
		}
		if (in.readByte() == 0) {
			maxSupply = null;
		} else {
			maxSupply = in.readDouble();
		}
		dateAdded = in.readString();
		if (in.readByte() == 0) {
			numMarketPairs = null;
		} else {
			numMarketPairs = in.readInt();
		}
		if (in.readByte() == 0) {
			cmcRank = null;
		} else {
			cmcRank = in.readInt();
		}
		lastUpdated = in.readString();
	}

	public static final Creator<DataItem> CREATOR = new Creator<DataItem>() {
		@Override
		public DataItem createFromParcel(Parcel in) {
			return new DataItem(in);
		}

		@Override
		public DataItem[] newArray(int size) {
			return new DataItem[size];
		}
	};

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public Double getCirculatingSupply() {
		return circulatingSupply;
	}

	public void setCirculatingSupply(Double circulatingSupply) {
		this.circulatingSupply = circulatingSupply;
	}

	public Double getTotalSupply() {
		return totalSupply;
	}

	public void setTotalSupply(Double totalSupply) {
		this.totalSupply = totalSupply;
	}

	public Double getMaxSupply() {
		return maxSupply;
	}

	public void setMaxSupply(Double maxSupply) {
		this.maxSupply = maxSupply;
	}

	public String getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}

	public Integer getNumMarketPairs() {
		return numMarketPairs;
	}

	public void setNumMarketPairs(Integer numMarketPairs) {
		this.numMarketPairs = numMarketPairs;
	}

	public Integer getCmcRank() {
		return cmcRank;
	}

	public void setCmcRank(Integer cmcRank) {
		this.cmcRank = cmcRank;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public com.asyahren.trcryptocurrency.model.Quote getQuote() {
		return quote;
	}

	public void setQuote(com.asyahren.trcryptocurrency.model.Quote quote) {
		this.quote = quote;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		if (id == null) {
			dest.writeByte((byte) 0);
		} else {
			dest.writeByte((byte) 1);
			dest.writeInt(id);
		}
		dest.writeString(name);
		dest.writeString(symbol);
		dest.writeString(slug);
		if (circulatingSupply == null) {
			dest.writeByte((byte) 0);
		} else {
			dest.writeByte((byte) 1);
			dest.writeDouble(circulatingSupply);
		}
		if (totalSupply == null) {
			dest.writeByte((byte) 0);
		} else {
			dest.writeByte((byte) 1);
			dest.writeDouble(totalSupply);
		}
		if (maxSupply == null) {
			dest.writeByte((byte) 0);
		} else {
			dest.writeByte((byte) 1);
			dest.writeDouble(maxSupply);
		}
		dest.writeString(dateAdded);
		if (numMarketPairs == null) {
			dest.writeByte((byte) 0);
		} else {
			dest.writeByte((byte) 1);
			dest.writeInt(numMarketPairs);
		}
		if (cmcRank == null) {
			dest.writeByte((byte) 0);
		} else {
			dest.writeByte((byte) 1);
			dest.writeInt(cmcRank);
		}
		dest.writeString(lastUpdated);
	}
}