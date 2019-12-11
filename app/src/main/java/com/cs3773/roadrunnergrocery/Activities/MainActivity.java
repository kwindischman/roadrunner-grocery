package com.cs3773.roadrunnergrocery.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SearchView;

import com.cs3773.roadrunnergrocery.R;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Class variables here
    private ImageView mAccountIcon;


    // Lifecycle methods here
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupAccountIcon();
        setupCartIcon();
        setupProducts();
        setupPromotions();
        setupSearch();

        // TODO: Set up the two Promotion views with random items
    }

    // Other methods here
    private void setupAccountIcon() {
        mAccountIcon = findViewById(R.id.account_icon);

        mAccountIcon.setOnClickListener(v -> {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        });
    }

    private void setupCartIcon() {
        mAccountIcon = findViewById(R.id.cart_icon);

        mAccountIcon.setOnClickListener(v -> {
            Intent intent = new Intent(this, CartActivity.class);
            startActivity(intent);
        });
    }

    private void setupProducts() {
        findViewById(R.id.product_image_1).setOnClickListener(v -> {
            // Open Search activity and show produce
        });
        findViewById(R.id.product_image_2).setOnClickListener(v -> {
            // Open Search activity and show meats
        });
        findViewById(R.id.product_image_3).setOnClickListener(v -> {
            // Open Search activity and show snacks
        });
        findViewById(R.id.product_image_4).setOnClickListener(v -> {
            // Open Search activity and show frozen foods
        });
    }

    private void setupPromotions() {
        // TODO: Grab two random promotions and use their info to make the views

        findViewById(R.id.see_more).setOnClickListener(v -> {
            Intent intent = new Intent(this, PromotionActivity.class);
            startActivity(intent);
        });
    }

    private void setupSearch() {
        SearchView searchView = findViewById(R.id.search);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
                intent.putExtra("SEARCH_EXTRA", s);
                startActivity(intent);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
    }
}
