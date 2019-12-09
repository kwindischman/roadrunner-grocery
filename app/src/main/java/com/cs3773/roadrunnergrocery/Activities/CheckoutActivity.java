package com.cs3773.roadrunnergrocery.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.cs3773.roadrunnergrocery.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CheckoutActivity extends AppCompatActivity {

    // Variables here
    private EditText nameEditText, phoneEditText, addressEditText, cityEditText;
    private Button confirmOrderButton;

    // Lifecycle methods here
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        // TODO: show total if necessary

        confirmOrderButton = (Button) findViewById(R.id.confirm_order_button);
        //nameEditText = (EditText) findViewById(R.id.);

        //Other methods here
        confirmOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

            }
        });



    }



}
