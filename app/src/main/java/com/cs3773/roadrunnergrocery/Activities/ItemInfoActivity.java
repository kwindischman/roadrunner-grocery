package com.cs3773.roadrunnergrocery.Activities;

import android.content.Intent;
import android.os.Bundle;

import com.cs3773.roadrunnergrocery.Models.Product;
import com.cs3773.roadrunnergrocery.Models.ProductBase;
import com.cs3773.roadrunnergrocery.R;

import androidx.appcompat.app.AppCompatActivity;

public class ItemInfoActivity extends AppCompatActivity {

    // Class variables here
    Product mProduct;

    // Lifecycle methods here
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_info);

        setupInstanceOfProduct();
    }

    // Other methods here
    private void setupInstanceOfProduct() {
        ProductBase productBase = new ProductBase();
        Intent intent = getIntent();
        int pid = intent.getIntExtra("PRODUCT_PID", -1);
        mProduct = productBase.getProduct(pid);
    }

}
