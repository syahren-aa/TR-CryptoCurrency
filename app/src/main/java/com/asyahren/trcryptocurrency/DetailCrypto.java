package com.asyahren.trcryptocurrency;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.asyahren.trcryptocurrency.model.DataItem;
import com.asyahren.trcryptocurrency.model.USD;
import com.asyahren.trcryptocurrency.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DetailCrypto extends AppCompatActivity {

    private TextView name;
    private FirebaseUser user;
    private DatabaseReference dbRef;
    EditText valueCrypto, priceResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_crypto);

        Intent intent = getIntent();
        DataItem datum = intent.getParcelableExtra("coin");
        USD usd = intent.getParcelableExtra("usd");

        name = findViewById(R.id.name);
        TextView price = findViewById(R.id.price);
        TextView date = findViewById(R.id.date);

        valueCrypto = findViewById(R.id.valueCrypto);
        priceResult =findViewById(R.id.priceResult);

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

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault());
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));


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
        Double priceBuy = Double.parseDouble(priceResult.getText().toString());
        user = FirebaseAuth.getInstance().getCurrentUser();
        dbRef = FirebaseDatabase.getInstance().getReference("Users");
        try {
            String userId = user.getUid();
            dbRef.child(userId).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    User currUser = snapshot.getValue(User.class);
                    Double biaya1 = currUser.getBalance();

                    if(biaya1-priceBuy>=0){
                        dbRef.child(userId).child("crypton").child("name").setValue(name.getText().toString());
                        dbRef.child(userId).child("crypton").child("value").setValue(priceBuy);
                        valueCrypto.setText("");
                        priceResult.setText("");
                        dbRef.child(user.getUid()).child("balance").setValue(biaya1-priceBuy);
                    }else{
                        valueCrypto.setText("");
                        priceResult.setText("");
                        Toast.makeText(DetailCrypto.this, getResources().getString(R.string.notEnough), Toast.LENGTH_SHORT).show();
                    }


                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

        }catch (Exception e){

        }
    }

    public void Convert(View view) {
        Double priceCryp = Double.parseDouble(valueCrypto.getText().toString());
        Double priceRp = priceCryp * 14490.70;

        priceResult.setText(priceRp.toString());
    }
}