package com.asyahren.trcryptocurrency;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface APIList {

    static String apiKey = "71299716-a8b4-4290-88fc-51a83a95f857";

    @Headers({"X-CMC_PRO_API_KEY: 71299716-a8b4-4290-88fc-51a83a95f857"})
    @GET(".")
    Call<ArrayList<Cryptocurrency>> getAllCryptocurrency();
}
