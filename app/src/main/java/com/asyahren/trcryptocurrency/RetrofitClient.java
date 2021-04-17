package com.asyahren.trcryptocurrency;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static String apiKey = "71299716-a8b4-4290-88fc-51a83a95f857";
    private static final String baseURL = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest/";
    private static Retrofit retrofit;

    public static Retrofit getRetrofitClient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }


}
