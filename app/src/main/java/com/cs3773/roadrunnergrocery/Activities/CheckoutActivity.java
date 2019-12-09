package com.cs3773.roadrunnergrocery.Activities;

import android.content.Context;
import android.content.Intent;
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
        setUpButtonClick();
    }

    private void setUpButtonClick() {
        // TODO: show total if necessary

        confirmOrderButton = (Button) findViewById(R.id.confirm_order_button);
        nameEditText = (EditText) findViewById(R.id.nameText);
        phoneEditText = (EditText) findViewById(R.id.phoneNumberText);
        addressEditText = (EditText) findViewById(R.id.addressText);
        cityEditText = (EditText) findViewById(R.id.cityAddressText);
        zipcodeEditText = (EditText) findViewById(R.id.zipCodeText);
        stateEditText = (EditText) findViewById(R.id.stateText);

        //Other methods here
        confirmOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Check();
            }

            private void Check()
            {
                if (TextUtils.isEmpty(nameEditText.getText().toString()))
                {
                    Context context = getApplicationContext();
                    CharSequence text = "Please enter full name.";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                }

                else if (TextUtils.isEmpty(phoneEditText.getText().toString()))
                {
                    Context context = getApplicationContext();
                    CharSequence text = "Please enter phone number.";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }

                else if (TextUtils.isEmpty(addressEditText.getText().toString()))
                {
                    Context context = getApplicationContext();
                    CharSequence text = "Please enter home address.";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }

                else if (TextUtils.isEmpty(cityEditText.getText().toString()))
                {
                    Context context = getApplicationContext();
                    CharSequence text = "Please enter city.";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }

                else if (TextUtils.isEmpty(zipcodeEditText.getText().toString()))
                {
                    Context context = getApplicationContext();
                    CharSequence text = "Please enter zip code.";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }

                else if (TextUtils.isEmpty(stateEditText.getText().toString()))
                {
                    Context context = getApplicationContext();
                    CharSequence text = "Please enter state.";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }

                else
                {
                    confirmOrder();
                }


            }

            private void confirmOrder() {
                /*
                final String saveCurrentDate, saveCurrentTime;
                Calendar calForDate = Calendar.getInstance();

                SimpleDateFormat currentDate = new SimpleDateFormat("MMM dd, yyyy");
                saveCurrentDate = currentDate.format(calForDate.getTime());

                SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss a");
                saveCurrentTime = currentDate.format(calForDate.getTime());
                */

                // TODO: save order to database if created and clear cart for next order
                // use nameEditText.getText(), etc to extract input data and store in database file;

                // return user to home menu
                Intent intent = new Intent(CheckoutActivity.this, CheckoutBillingCardInfoActivity.class);
                startActivity(intent);
            }
        });


    }
}
