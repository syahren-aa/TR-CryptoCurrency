package com.asyahren.trcryptocurrency.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.asyahren.trcryptocurrency.R;
import com.asyahren.trcryptocurrency.model.Cryptocurrency;
import com.asyahren.trcryptocurrency.model.Datum;
import com.asyahren.trcryptocurrency.model.USD;

import java.util.List;

public class ListCryptoAdapter extends RecyclerView.Adapter<ListCryptoAdapter.ListViewHolder> {

    private List<Datum> listCrypto;

    public ListCryptoAdapter(List<Datum> data) {
        this.listCrypto = data;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_crypto, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Datum datum = listCrypto.get(position);
//        USD usd = listCrypto.get(position);
        holder.nameTextView.setText(datum.getName());
        holder.symbolTextView.setText(datum.getSymbol());
//        holder.priceTextView.setText(String.valueOf(usd.getPrice()));

    }

    @Override
    public int getItemCount() {
        return listCrypto.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {

        TextView noTextView, nameTextView, symbolTextView, priceTextView;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameList);
            symbolTextView = itemView.findViewById(R.id.symbolList);
            priceTextView = itemView.findViewById(R.id.priceList);

        }
    }
}
