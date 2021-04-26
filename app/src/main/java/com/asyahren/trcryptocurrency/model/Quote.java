package com.asyahren.trcryptocurrency.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Quote implements Parcelable {

	@SerializedName("USD")
	private USD uSD;

	protected Quote(Parcel in) {
		uSD = in.readParcelable(USD.class.getClassLoader());
	}

	public static final Creator<Quote> CREATOR = new Creator<Quote>() {
		@Override
		public Quote createFromParcel(Parcel in) {
			return new Quote(in);
		}

		@Override
		public Quote[] newArray(int size) {
			return new Quote[size];
		}
	};

	public USD getUSD(){
		return uSD;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeParcelable(uSD, flags);
	}
}