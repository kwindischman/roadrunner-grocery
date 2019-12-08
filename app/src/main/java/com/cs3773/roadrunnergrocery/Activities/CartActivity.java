package com.cs3773.roadrunnergrocery.Activities;

import android.os.Bundle;

import com.cs3773.roadrunnergrocery.Adapters.CartAdapter;
import com.cs3773.roadrunnergrocery.Models.ProductPair;
import com.cs3773.roadrunnergrocery.R;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CartActivity extends AppCompatActivity {

    // Variables here
    List<ProductPair> mProducts;

    // Lifecycle methods here
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        RecyclerView recyclerView = findViewById(R.id.cart_recycler);

        // TODO: Get list of customers ProductPairs in their cart
        // Just a reminder that a ProductPair is simply a product with a count of how many the
        //     customer wants
        // mProducts = get the list here

        CartAdapter cartAdapter = new CartAdapter(mProducts);
        recyclerView.setAdapter(cartAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    //Other methods here

}
