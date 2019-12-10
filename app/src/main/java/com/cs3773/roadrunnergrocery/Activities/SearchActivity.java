package com.cs3773.roadrunnergrocery.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.SearchView;

import com.cs3773.roadrunnergrocery.Adapters.SearchAdapter;
import com.cs3773.roadrunnergrocery.Models.Product;
import com.cs3773.roadrunnergrocery.R;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SearchActivity extends AppCompatActivity {

    List<Product> mProducts;
    SearchAdapter mSearchAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        setupCartIcon();
        setupRecyclerView();
        setupSearch();
        findViewById(R.id.back_arrow).setOnClickListener(v -> onBackPressed());
    }

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
        SearchView searchView = findViewById(R.id.search);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                mSearchAdapter.getFilter().filter(s);
                return false;
            }
        });

        Intent intent = getIntent();
        String extra = intent.getStringExtra("SEARCH_EXTRA");
        if (extra != null && extra.length() != 0) {
            mSearchAdapter.getFilter().filter(extra);
        }
    }
}
