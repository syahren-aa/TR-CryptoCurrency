package com.asyahren.trcryptocurrency.ConsumeRes;

import com.asyahren.trcryptocurrency.model.Cryptocurrency;
import com.asyahren.trcryptocurrency.model.Datum;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface APIList {

    @Headers("X-CMC_PRO_API_KEY: f0fc2dfb-1d6d-4493-883a-643f7f332161")
    @GET("/v1/cryptocurrency/listings/latest?")
    Call<Cryptocurrency> getAllCryptocurrency(@Query("limit") String page);
}
