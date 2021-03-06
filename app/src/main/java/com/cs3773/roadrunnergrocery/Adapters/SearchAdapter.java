package com.cs3773.roadrunnergrocery.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.cs3773.roadrunnergrocery.Activities.ItemInfoActivity;
import com.cs3773.roadrunnergrocery.Models.Cart;
import com.cs3773.roadrunnergrocery.Models.Product;
import com.cs3773.roadrunnergrocery.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> implements Filterable {

    private List<Product> mProductList;
    private List<Product> mProductListFull;
    private Context mContext;

    public SearchAdapter(List<Product> productList, Context context) {
        mProductList = productList;
        mProductListFull = new ArrayList<>(productList);
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
        Glide.with(mContext).load(mContext.getResources().getDrawable(imageResource))
                .apply(RequestOptions.circleCropTransform()).into(image);
        image.setOnClickListener(v -> {
            Intent intent = new Intent( mContext, ItemInfoActivity.class);
            intent.putExtra("PRODUCT_PID", product.getPid());
            mContext.startActivity(intent);
        });

        TextView name = holder.name;
        name.setText(product.getName());

        TextView price = holder.price;
        price.setText(String.format("Price: $%.2f", product.getPrice()));

        TextView quantity = holder.quantity;

        ImageView remove = holder.remove;
        remove.setOnClickListener(v -> {
            Integer newQuantity = Integer.valueOf(quantity.getText().toString());
            if (newQuantity > 0) {
                newQuantity -= 1;
                quantity.setText(String.format("%d", newQuantity));
            }
        });

        ImageView add = holder.add;
        add.setOnClickListener(v -> {
            Integer newQuantity = Integer.valueOf(quantity.getText().toString());
            newQuantity += 1;
            quantity.setText(String.format("%d", newQuantity));
        });

        TextView addToCart = holder.addToCart;
        addToCart.setOnClickListener(v -> {
            Integer newQuantity = Integer.valueOf(quantity.getText().toString());
            if (newQuantity > 0) {
                Cart cart = Cart.getInstance();
                cart.addItem(product.getPid(), newQuantity);
                quantity.setText(String.format("%d", 0));
                Toast.makeText(mContext, "Added to cart", Toast.LENGTH_LONG).show();
            }
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
        TextView addToCart;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.product_image);
            name = itemView.findViewById(R.id.product_name);
            price = itemView.findViewById(R.id.product_price);
            quantity = itemView.findViewById(R.id.quantity);
            remove = itemView.findViewById(R.id.remove_button);
            add = itemView.findViewById(R.id.add_button);
            addToCart = itemView.findViewById(R.id.add_to_cart);
        }
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Product> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(mProductListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Product product : mProductListFull) {
                    if (product.getName().toLowerCase().contains(filterPattern)
                            || product.getTag().toLowerCase().contains(filterPattern)) {
                        filteredList.add(product);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mProductList.clear();
            mProductList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
}
