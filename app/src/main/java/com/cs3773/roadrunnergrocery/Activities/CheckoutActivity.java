package com.cs3773.roadrunnergrocery.Activities;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cs3773.roadrunnergrocery.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CheckoutActivity extends AppCompatActivity {

    // Variables here
    private EditText nameEditText, phoneEditText, addressEditText, cityEditText, zipcodeEditText, stateEditText;
    private Button confirmOrderButton;

    // Lifecycle methods here
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        // TODO: show total if necessary

        confirmOrderButton = (Button) findViewById(R.id.confirm_order_button);
        nameEditText = (EditText) findViewById(R.id.nameText);
        phoneEditText = (EditText) findViewById(R.id.phoneNumberText);
        cityEditText = (EditText) findViewById(R.id.nameText);
        zipcodeEditText = (EditText) findViewById(R.id.zipCodeText);
        stateEditText = (EditText) findViewById(R.id.stateText);

        //Other methods here
        confirmOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Check();
            }

            private void Check()
            {

                if(TextUtils.isEmpty(nameEditText.getText().toString()))
                {
                    Toast.makeText(this, "Please enter full name.", Toast.LENGTH_SHORT).show();
                }

                else if(TextUtils.isEmpty(phoneEditText.getText().toString()))
                {
                    Toast.makeText(this, "Please enter a phone number.", Toast.LENGTH_SHORT).show();
                }

                else if(TextUtils.isEmpty(cityEditText.getText().toString()))
                {
                    Toast.makeText(this, "Please enter a city.", Toast.LENGTH_SHORT).show();
                }

                else if(TextUtils.isEmpty(zipcodeEditText.getText().toString()))
                {
                    Toast.makeText(this, "Please enter a zip code.", Toast.LENGTH_SHORT).show();
                }

                else if (TextUtils.isEmpty(stateEditText.getText().toString()))
                {
                    Toast.makeText(this, "Please enter a state.", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    confirmOrderButton();
                }

            }
        });



    }



}
