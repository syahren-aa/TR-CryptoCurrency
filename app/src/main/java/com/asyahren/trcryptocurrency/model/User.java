package com.asyahren.trcryptocurrency.model;

import java.util.ArrayList;
import java.util.HashMap;

public class User {

    private String email;
    private String password;
    private String name;
    private String phone;
    private Double balance;
    private ArrayList<HasCrypto> hasCrypto;

    public User(String email, String password, String name,
                String phone, Double balance, ArrayList<HasCrypto> hasCrypto){
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.balance = balance;
        this.hasCrypto = hasCrypto;

    }

    public User(){

    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public ArrayList<HasCrypto> getHasCrypto() {
        return hasCrypto;
    }

    public void setHasCrypto(ArrayList<HasCrypto> hasCrypto) {
        this.hasCrypto = hasCrypto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public class HasCrypto{

        String currencyName;
        Double fund;

        public String getCurrencyName() {
            return currencyName;
        }

        public void setCurrencyName(String currencyName) {
            this.currencyName = currencyName;
        }

        public Double getFund() {
            return fund;
        }

        public void setFund(Double fund) {
            this.fund = fund;
        }

    }
}
