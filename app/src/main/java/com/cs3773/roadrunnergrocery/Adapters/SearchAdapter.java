package com.cs3773.roadrunnergrocery.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cs3773.roadrunnergrocery.Models.Product;
import com.cs3773.roadrunnergrocery.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    private List<Product> mProductList;
    private Context mContext;

    public SearchAdapter(List<Product> productList, Context context) {
        mProductList = productList;
        mContext = context;
    }

    @NonNull
    @Override
    public SearchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View productView = inflater.inflate(R.layout.item_search, parent, false);
        return new ViewHolder(productView);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.ViewHolder holder, int position) {
        Product product = mProductList.get(position);

        ImageView image = holder.image;
        int imageResource = mContext.getResources().getIdentifier(product.getImageURL(), null, mContext.getPackageName());
        image.setImageDrawable(mContext.getResources().getDrawable(imageResource));

        TextView name = holder.name;
        name.setText(product.getName());

        TextView price = holder.price;
        price.setText(String.format("Price: $%.2f", product.getPrice()));

        TextView quantity = holder.quantity;

        ImageView remove = holder.remove;
        remove.setOnClickListener( v -> {
            Integer newQuantity = Integer.valueOf(quantity.getText().toString());
            if (newQuantity > 0) {
                newQuantity -= 1;
                quantity.setText(String.format("%d", newQuantity));
            }
        });

        ImageView add = holder.add;
        add.setOnClickListener( v -> {
            Integer newQuantity = Integer.valueOf(quantity.getText().toString());
            newQuantity += 1;
            quantity.setText(String.format("%d", newQuantity));
        });
    }

    @Override
    public int getItemCount() {
        return mProductList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        ImageView remove;
        ImageView add;
        TextView quantity;
        TextView name;
        TextView price;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.product_image);
            name = itemView.findViewById(R.id.product_name);
            price = itemView.findViewById(R.id.product_price);
            quantity = itemView.findViewById(R.id.quantity);
            remove = itemView.findViewById(R.id.remove_button);
            add = itemView.findViewById(R.id.add_button);
        }
    }
}
