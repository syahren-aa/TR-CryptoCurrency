package com.asyahren.trcryptocurrency.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Status implements Parcelable {

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

	protected Status(Parcel in) {
		elapsed = in.readInt();
		totalCount = in.readInt();
		creditCount = in.readInt();
		errorCode = in.readInt();
		timestamp = in.readString();
	}

	public static final Creator<Status> CREATOR = new Creator<Status>() {
		@Override
		public Status createFromParcel(Parcel in) {
			return new Status(in);
		}

		@Override
		public Status[] newArray(int size) {
			return new Status[size];
		}
	};

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

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(elapsed);
		dest.writeInt(totalCount);
		dest.writeInt(creditCount);
		dest.writeInt(errorCode);
		dest.writeString(timestamp);
	}
}