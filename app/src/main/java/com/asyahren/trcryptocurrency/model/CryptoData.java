package com.asyahren.trcryptocurrency.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CryptoData implements Parcelable {

	@SerializedName("data")
	@Expose
	private List<DataItem> data;

	@SerializedName("status")
	@Expose
	private Status status;

	protected CryptoData(Parcel in) {
		data = in.createTypedArrayList(DataItem.CREATOR);
		status = in.readParcelable(Status.class.getClassLoader());
	}

	public static final Creator<CryptoData> CREATOR = new Creator<CryptoData>() {
		@Override
		public CryptoData createFromParcel(Parcel in) {
			return new CryptoData(in);
		}

		@Override
		public CryptoData[] newArray(int size) {
			return new CryptoData[size];
		}
	};

	public List<DataItem> getData(){
		return data;
	}

	public Status getStatus(){
		return status;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeTypedList(data);
		dest.writeParcelable(status, flags);
	}
}