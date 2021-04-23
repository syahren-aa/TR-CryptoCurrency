package com.asyahren.trcryptocurrency.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Cryptocurrency {

    @SerializedName("name")
    private String name;

    @SerializedName("symbol")
    private String symbol;

    @SerializedName("price")
    private double price;

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
//    @SerializedName("data")
//    private ArrayList<Data> data;
//
//    public Cryptocurrency(ArrayList<Data> data) {
//        this.data = data;
//    }
//
//    public Cryptocurrency() {
//
//    }
//    public ArrayList<Data> getData() {
//        return data;
//    }
//
//    public void setData(ArrayList<Data> data) {
//        this.data = data;
//    }
//
//    public class Data {
//
//        @SerializedName("name")
//        private String name;
//
//        @SerializedName("symbol")
//        private String symbol;
//
//        @SerializedName("quote")
//        private Quote quote;
//
//        public Quote getQuote() {
//            return quote;
//        }
//
//        public void setQuote(Quote quote) {
//            this.quote = quote;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public String getSymbol() {
//            return symbol;
//        }
//
//        public void setSymbol(String symbol) {
//            this.symbol = symbol;
//        }
//
//        public class Quote{
//            @SerializedName("USD")
//            private USD usd;
//
//            public USD getUsd() {
//                return usd;
//            }
//
//            public void setUsd(USD usd) {
//                this.usd = usd;
//            }
//
//            public class USD{
//                @SerializedName("price")
//                private double price;
//
//                public double getPrice() {
//                    return price;
//                }
//
//                public void setPrice(double price) {
//                    this.price = price;
//                }
//            }
//        }
//
//    }
}
