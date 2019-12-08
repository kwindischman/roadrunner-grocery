package com.cs3773.roadrunnergrocery.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cs3773.roadrunnergrocery.Models.ProductPair;
import com.cs3773.roadrunnergrocery.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    private List<ProductPair> mProductList;

    public CartAdapter(List<ProductPair> productList) {
        mProductList = productList;
    }

    @NonNull
    @Override
    public CartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View productView = inflater.inflate(R.layout.item_cart, parent, false);
        return new ViewHolder(productView);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.ViewHolder holder, int position) {
        ProductPair product = mProductList.get(position);

        // TODO: Set up the viewHolders with product information once we have products
        ImageView image = holder.image;
        // set image here
        TextView name = holder.name;
        // set name here
        TextView price = holder.price;
        // set price here
        TextView quantity = holder.quantity;
        // set quantity here

        holder.removeIcon.setOnClickListener(v -> {
            mProductList.remove(product);
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return mProductList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        ImageView removeIcon;
        TextView name;
        TextView quantity;
        TextView price;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.cart_product_image);
            removeIcon = itemView.findViewById(R.id.cart_remove_icon);
            name = itemView.findViewById(R.id.cart_product_name);
            quantity = itemView.findViewById(R.id.cart_quantity);
            price = itemView.findViewById(R.id.cart_total_price);
        }
    }
}
