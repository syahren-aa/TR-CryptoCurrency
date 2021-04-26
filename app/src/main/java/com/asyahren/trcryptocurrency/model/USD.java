package com.asyahren.trcryptocurrency.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class USD implements Parcelable {

	@SerializedName("percent_change_30d")
	private double percentChange30d;

	@SerializedName("percent_change_1h")
	private double percentChange1h;

	@SerializedName("last_updated")
	private String lastUpdated;

	@SerializedName("percent_change_24h")
	private double percentChange24h;

	@SerializedName("market_cap")
	private double marketCap;

	@SerializedName("price")
	private double price;

	@SerializedName("percent_change_60d")
	private double percentChange60d;

	@SerializedName("volume_24h")
	private double volume24h;

	@SerializedName("percent_change_90d")
	private double percentChange90d;

	@SerializedName("percent_change_7d")
	private double percentChange7d;

	protected USD(Parcel in) {
		percentChange30d = in.readDouble();
		percentChange1h = in.readDouble();
		lastUpdated = in.readString();
		percentChange24h = in.readDouble();
		marketCap = in.readDouble();
		price = in.readDouble();
		percentChange60d = in.readDouble();
		volume24h = in.readDouble();
		percentChange90d = in.readDouble();
		percentChange7d = in.readDouble();
	}

	public static final Creator<USD> CREATOR = new Creator<USD>() {
		@Override
		public USD createFromParcel(Parcel in) {
			return new USD(in);
		}

		@Override
		public USD[] newArray(int size) {
			return new USD[size];
		}
	};

	public double getPercentChange30d(){
		return percentChange30d;
	}

	public double getPercentChange1h(){
		return percentChange1h;
	}

	public String getLastUpdated(){
		return lastUpdated;
	}

	public double getPercentChange24h(){
		return percentChange24h;
	}

	public double getMarketCap(){
		return marketCap;
	}

	public double getPrice(){
		return price;
	}

	public double getPercentChange60d(){
		return percentChange60d;
	}

	public double getVolume24h(){
		return volume24h;
	}

	public double getPercentChange90d(){
		return percentChange90d;
	}

	public double getPercentChange7d(){
		return percentChange7d;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeDouble(percentChange30d);
		dest.writeDouble(percentChange1h);
		dest.writeString(lastUpdated);
		dest.writeDouble(percentChange24h);
		dest.writeDouble(marketCap);
		dest.writeDouble(price);
		dest.writeDouble(percentChange60d);
		dest.writeDouble(volume24h);
		dest.writeDouble(percentChange90d);
		dest.writeDouble(percentChange7d);
	}
}