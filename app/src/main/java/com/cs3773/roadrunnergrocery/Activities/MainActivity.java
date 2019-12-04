package com.cs3773.roadrunnergrocery.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.cs3773.roadrunnergrocery.R;

public class MainActivity extends AppCompatActivity {

    // Class variables here
    private ImageView mAccountIcon;

    // Lifecycle methods here
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupAccountIcon();
    }

    // Other methods here
    private void setupAccountIcon() {
        mAccountIcon = findViewById(R.id.account_icon);

        mAccountIcon.setOnClickListener(v -> {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        });
    }
}
