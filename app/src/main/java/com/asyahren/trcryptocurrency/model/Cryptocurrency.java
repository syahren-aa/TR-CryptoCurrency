package com.asyahren.trcryptocurrency.model;

public class Cryptocurrency {
    private String name;
    private String symbol;
    private Double price;

    public Cryptocurrency(String name, String symbol, Double price){
        this.name = name;
        this.symbol = symbol;
        this.price = price;
    }

    public Cryptocurrency(){

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
