package com.asyahren.trcryptocurrency.ConsumeRes;

import com.asyahren.trcryptocurrency.model.CryptoData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface APIList {
    @Headers("X-CMC_PRO_API_KEY: 71299716-a8b4-4290-88fc-51a83a95f857")
    @GET("/v1/cryptocurrency/listings/latest?")
    Call<CryptoData> getAllCryptocurrency();
}
