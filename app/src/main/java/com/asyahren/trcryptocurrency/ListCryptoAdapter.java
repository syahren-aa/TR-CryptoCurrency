package com.asyahren.trcryptocurrency;

import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class ListCryptoAdapter extends RecyclerView.Adapter<ListCryptoAdapter.ListViewHolder> {

    private ArrayList<Cryptocurrency> listCrypto;

    public ListCryptoAdapter(ArrayList<Cryptocurrency> list) {
        this.listCrypto = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_crypto, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Cryptocurrency cryptocurrency = listCrypto.get(position);
        holder.nameTextView.setText(cryptocurrency.getName());
        holder.symbolTextView.setText(cryptocurrency.getSymbol());
        holder.priceTextView.setText((int) cryptocurrency.getPrice());

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
