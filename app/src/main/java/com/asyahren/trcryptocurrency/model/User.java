package com.asyahren.trcryptocurrency.model;

import java.util.ArrayList;
import java.util.HashMap;

public class User {

    private String email;
    private String password;
    private String name;
    private String phone;
    private Double balance;
    private HashMap<String, Double> hasCrypto;

    public User(String email, String password, String name,
                String phone, Double balance, HashMap<String, Double> hasCrypto){
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.balance = balance;
        this.hasCrypto = hasCrypto;

    }

    public User(){

    }

    public HashMap<String, Double> getHasCrypto() {
        return hasCrypto;
    }

    public void setHasCrypto(HashMap<String, Double> hasCrypto) {
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

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
