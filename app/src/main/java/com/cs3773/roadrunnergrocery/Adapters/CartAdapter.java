package com.cs3773.roadrunnergrocery.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.cs3773.roadrunnergrocery.Models.ProductPair;
import com.cs3773.roadrunnergrocery.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    private List<ProductPair> mProductPairList;
    private Context mContext;

    public CartAdapter(List<ProductPair> productList, Context context) {
        mProductPairList = productList;
        mContext = context;
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
        ProductPair productPair = mProductPairList.get(position);

        ImageView image = holder.image;
        int imageResource = mContext.getResources().getIdentifier(productPair.getProduct().getImageURL()
                , null, mContext.getPackageName());
        Glide.with(mContext).load(mContext.getResources().getDrawable(imageResource))
                .apply(RequestOptions.circleCropTransform()).into(image);

        TextView name = holder.name;
        name.setText(productPair.getProduct().getName());

        TextView price = holder.price;
        price.setText(String.format("Total: $%.2f", getTotalPrice(productPair)));

        TextView quantity = holder.quantity;
        quantity.setText(String.format("Quantity: %d", productPair.getQuantity()));

        holder.removeIcon.setOnClickListener(v -> {
            mProductPairList.remove(productPair);
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return mProductPairList.size();
    }

    private double getTotalPrice(ProductPair productPair) {
        return productPair.getProduct().getPrice() * productPair.getQuantity();
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
            quantity = itemView.findViewById(R.id.cart_quantity_text);
            price = itemView.findViewById(R.id.cart_total_price);
        }
    }
}
