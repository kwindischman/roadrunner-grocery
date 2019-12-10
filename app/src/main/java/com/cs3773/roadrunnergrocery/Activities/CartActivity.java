package com.cs3773.roadrunnergrocery.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.cs3773.roadrunnergrocery.Adapters.CartAdapter;
import com.cs3773.roadrunnergrocery.Models.Cart;
import com.cs3773.roadrunnergrocery.Models.ProductBase;
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
    ProductBase mProductBase;

    // Lifecycle methods here
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        mProductBase = new ProductBase();
        setupRecyclerView();
        setupCheckoutButton();

    }

    //Other methods here
    private void setupCheckoutButton() {
        findViewById(R.id.checkout_layout).setOnClickListener(v -> {
            if (mProducts.size() > 0) {
                Intent intent = new Intent(this, CheckoutActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Your cart is empty!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.cart_recycler);

        // TODO: Get list of customers ProductPairs in their cart
        // Just a reminder that a ProductPair is simply a product with a count of how many the
        //     customer wants
        Cart cart = Cart.getInstance();
        mProducts = cart.getItems();

        CartAdapter cartAdapter = new CartAdapter(mProducts, this);
        recyclerView.setAdapter(cartAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setupTotalPrice() {
        //TODO: have this method take the prices from all items and add them up
    }
}
