package com.asyahren.trcryptocurrency;

import android.util.Log;
import android.widget.Toast;

import com.asyahren.trcryptocurrency.ConsumeRes.APIList;
import com.asyahren.trcryptocurrency.ConsumeRes.RetrofitClient;
import com.asyahren.trcryptocurrency.model.CryptoData;
import com.asyahren.trcryptocurrency.model.Cryptocurrency;
import com.asyahren.trcryptocurrency.model.DataItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequestData {

    private static List<DataItem> data = null;

    static ArrayList<Cryptocurrency> getListData() {
        ArrayList<Cryptocurrency> list = new ArrayList<>();
        APIList apiList = RetrofitClient.getRetrofitClient().create(APIList.class);
        Call<CryptoData> call = apiList.getAllCryptocurrency();
        call.enqueue(new Callback<CryptoData>() {
            @Override
            public void onResponse(Call<CryptoData> call, Response<CryptoData> response) {
                if(response.isSuccessful()){
                    Log.w("berhasil", "horee");
//                    CryptoData crypto = response.body();
//                    data.clear();
//                    data.addAll(crypto.getData());
//                    for (int position = 0; position < data.size() ; position++) {
//                        Cryptocurrency cryptocurrency = new Cryptocurrency();
//                        cryptocurrency.setName(data.get(position).getName());
//                        cryptocurrency.setSymbol(data.get(position).getSymbol());
//                        cryptocurrency.setPrice((data.get(position).getQuote().getUSD().getPrice()));
//                        list.add(cryptocurrency);
//                    }
                }else {
                    Log.e("ini", ""+response);
                    Log.e("Responya", "Response from Server is Failed" + response);
                }
            }
            @Override
            public void onFailure(Call<CryptoData> call, Throwable t) {
                Log.e("Responya", "Response from Server is Failed");
            }
        });

        Cryptocurrency cryptocurrency = new Cryptocurrency();
        cryptocurrency.setName("aaaaaaaaaa");
        cryptocurrency.setSymbol("aaaaaaaaa");
        cryptocurrency.setPrice((double) 0000);
        list.add(cryptocurrency);
        return list;
    }
}
