package com.asyahren.trcryptocurrency;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.asyahren.trcryptocurrency.model.DataItem;
import com.asyahren.trcryptocurrency.model.USD;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DetailCrypto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_crypto);

        Intent intent = getIntent();
        DataItem datum = intent.getParcelableExtra("coin");
        USD usd = intent.getParcelableExtra("usd");

        TextView name = findViewById(R.id.name);
        TextView price = findViewById(R.id.price);
        TextView date = findViewById(R.id.date);

        TextView symbol = findViewById(R.id.symbol);
        TextView slug = findViewById(R.id.slug);
        TextView volume24h = findViewById(R.id.volume24h);
        TextView circulating_supply = findViewById(R.id.circulating_supply);
        TextView max_supply = findViewById(R.id.max_supply);
        TextView market_cap = findViewById(R.id.market_cap);

        TextView change1h = findViewById(R.id.change1h);
        TextView change24h = findViewById(R.id.change24h);
        TextView change7d = findViewById(R.id.change7d);

        name.setText(datum.getName() + " (" + datum.getSymbol() + ")");
        price.setText(getResources().getString(R.string.price) + " : $" + String.format("%,f", usd.getPrice()));
        date.setText(getResources().getString(R.string.lastUpdate) + " : " + parseDateToddMMyyyy(datum.getLastUpdated()));

        symbol.setText(" : " + datum.getSymbol());
        slug.setText(" : " + datum.getSlug());
        volume24h.setText(" : $" + String.format("%,d", Math.round(usd.getVolume24h())));

        circulating_supply.setText(" : " + String.format("%.0f", datum.getCirculatingSupply()) + " " + datum.getSymbol());
        max_supply.setText(" : " + String.format("%.0f", datum.getMaxSupply()) + " " + datum.getSymbol());

        market_cap.setText(" : $" + String.format("%,d", Math.round(usd.getMarketCap())));

        change1h.setText(String.format(" : %.2f", usd.getPercentChange1h()) + "%");
        change24h.setText(String.format(" : %.2f", usd.getPercentChange24h()) + "%");
        change7d.setText(String.format(" : %.2f", usd.getPercentChange7d()) + "%");
    }


    private String parseDateToddMMyyyy(String time) {
        //parse the server timestamp. Make sure it is in UTC timezone as per API specifications.
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault());
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));

        //format the utc server timestamp to local timezone.
        SimpleDateFormat output = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault());
        output.setTimeZone(TimeZone.getDefault());

        Date date = null;
        try {
            date = sdf.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return output.format(date);
    }

    public void buyCrypto(View view) {
        
    }
}