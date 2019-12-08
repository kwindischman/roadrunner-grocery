package com.cs3773.roadrunnergrocery.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.SearchView;

import com.cs3773.roadrunnergrocery.Adapters.SearchAdapter;
import com.cs3773.roadrunnergrocery.Models.Product;
import com.cs3773.roadrunnergrocery.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SearchActivity extends AppCompatActivity {

    // Variables here
    List<Product> mProducts;

    // Lifecycle methods here
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        setupCartIcon();
        setupRecyclerView();
        setupSearch();
        findViewById(R.id.back_arrow).setOnClickListener(v -> onBackPressed());
    }

    //Other methods here
    public void setupCartIcon() {
        findViewById(R.id.cart_icon).setOnClickListener(v -> {
            Intent intent = new Intent(this, CartActivity.class);
            startActivity(intent);
        });
    }

    public void setupRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.search_recycler);

        // TODO: Get list of Products related to the search term (name, tags, desc, etc)
        mProducts = new ArrayList<>();

        SearchAdapter searchAdapter = new SearchAdapter(mProducts);
        recyclerView.setAdapter(searchAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setupSearch() {
        // TODO: Implement some sort of search system
        // TODO: Possibly make a class that handles all of the search functionality since it shows
        //  up throughout most of the app
        SearchView searchView = findViewById(R.id.search);

        // TODO: Change this from onClickListener to a listener that activates when user searches
        //  for a term
        searchView.setOnClickListener(v -> {
            Intent intent = new Intent(this, SearchActivity.class);
            startActivity(intent);
        });
    }
}
