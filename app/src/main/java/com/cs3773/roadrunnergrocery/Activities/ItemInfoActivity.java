package com.cs3773.roadrunnergrocery.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.cs3773.roadrunnergrocery.Models.Product;
import com.cs3773.roadrunnergrocery.Models.ProductBase;
import com.cs3773.roadrunnergrocery.R;

import androidx.appcompat.app.AppCompatActivity;

public class ItemInfoActivity extends AppCompatActivity {

    // Class variables here
    Product mProduct;
    ImageView prodImage;
    TextView prodName;
    TextView prodDesc;
    TextView prodPrice;

    // Lifecycle methods here
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_info);

        setupInstanceOfProduct();

        prodImage = findViewById(R.id.prodImage);
        prodName = findViewById(R.id.prodName);
        prodDesc = findViewById(R.id.prodDesc);
        prodPrice = findViewById(R.id.priceView);


        prodName.setText(mProduct.getName());
        prodDesc.setText(mProduct.getDescription());
        prodPrice.setText(" Price: " + mProduct.getPrice());
    }

    // Other methods here
    private void setupInstanceOfProduct() {
        ProductBase productBase = new ProductBase();
        Intent intent = getIntent();
        int pid = intent.getIntExtra("PRODUCT_PID", -1);
        mProduct = productBase.getProduct(pid);
    }

}
