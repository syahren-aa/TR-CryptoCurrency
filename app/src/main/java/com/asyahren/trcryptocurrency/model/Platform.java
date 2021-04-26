package com.asyahren.trcryptocurrency.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Platform implements Parcelable {

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

	protected Platform(Parcel in) {
		symbol = in.readString();
		name = in.readString();
		tokenAddress = in.readString();
		id = in.readInt();
		slug = in.readString();
	}

	public static final Creator<Platform> CREATOR = new Creator<Platform>() {
		@Override
		public Platform createFromParcel(Parcel in) {
			return new Platform(in);
		}

		@Override
		public Platform[] newArray(int size) {
			return new Platform[size];
		}
	};

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

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(symbol);
		dest.writeString(name);
		dest.writeString(tokenAddress);
		dest.writeInt(id);
		dest.writeString(slug);
	}
}