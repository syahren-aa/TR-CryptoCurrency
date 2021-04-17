package com.asyahren.trcryptocurrency;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Cryptocurrency {

    @SerializedName("data.name")
    private String name;

    @SerializedName("data.symbol")
    private String symbol;

    @SerializedName("data.USD.price")
    private float price;

    public Cryptocurrency(String name, String symbol, float price){
        this.name = name;
        this.symbol = symbol;
        this.price = price;
    }

    public Cryptocurrency() {

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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
