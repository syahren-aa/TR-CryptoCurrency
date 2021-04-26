package com.asyahren.trcryptocurrency.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.asyahren.trcryptocurrency.DetailCrypto;
import com.asyahren.trcryptocurrency.R;
import com.asyahren.trcryptocurrency.model.DataItem;

import java.io.Serializable;
import java.util.ArrayList;

public class ListCryptoAdapter extends RecyclerView.Adapter<ListCryptoAdapter.ListViewHolder> {

    private ArrayList<DataItem> listCrypto;
    private OnItemClickCallback onItemClickCallback;
    public ListCryptoAdapter(ArrayList<DataItem> list) {
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
        DataItem cryptocurrency = listCrypto.get(position);
        holder.nameTextView.setText(cryptocurrency.getName());
        holder.symbolTextView.setText(cryptocurrency.getSymbol());
        holder.priceTextView.setText(String.valueOf(cryptocurrency.getQuote().getUSD().getPrice()));


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                onItemClickCallback.onItemClicked(listCrypto.get(holder.getAdapterPosition()));
                Intent intent = new Intent(v.getContext(), DetailCrypto.class);
                intent.putExtra("coin", listCrypto.get(position));
                intent.putExtra("usd", listCrypto.get(position).getQuote().getUSD());
                v.getContext().startActivities(new Intent[]{intent});
            }
        });

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
    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public interface OnItemClickCallback {
        void onItemClicked(DataItem dataItem);
    }
}
