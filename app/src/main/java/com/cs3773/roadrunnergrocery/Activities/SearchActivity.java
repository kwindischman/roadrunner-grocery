package com.cs3773.roadrunnergrocery.Activities;

import android.os.Bundle;

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

        RecyclerView recyclerView = findViewById(R.id.search_recycler);

        // TODO: Get list of Products related to the search term (name, tags, desc, etc)
        mProducts = new ArrayList<>();

        SearchAdapter searchAdapter = new SearchAdapter(mProducts);
        recyclerView.setAdapter(searchAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    //Other methods here

}
