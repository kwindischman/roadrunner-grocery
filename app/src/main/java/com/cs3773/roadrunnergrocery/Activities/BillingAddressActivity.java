package com.cs3773.roadrunnergrocery.Activities;

import androidx.appcompat.app.AppCompatActivity;
import com.cs3773.roadrunnergrocery.R;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BillingAddressActivity extends AppCompatActivity {

    private EditText billingName, billingPhoneNumber, billingAddress, billingCity, billingZipCode, billingState;
    private Button confirmCheckoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billing_address);
        setUpButtonClick();
    }

    private void setUpButtonClick()
    {
        confirmCheckoutButton = (Button) findViewById(R.id.confirm_order_button_billingAddressPage);
        billingName = (EditText) findViewById(R.id.billingNameText);
        billingPhoneNumber = (EditText) findViewById(R.id.billingPhoneNumberText);
        billingAddress = (EditText) findViewById(R.id.billingAddressText);
        billingCity = (EditText) findViewById(R.id.billingCityAddressText);
        billingState = (EditText) findViewById(R.id.billingStateText);
        billingZipCode = (EditText) findViewById(R.id.billingZipCodeText);

        confirmCheckoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBillingInfo();
            }

            private void CheckBillingInfo()
            {
                if(TextUtils.isEmpty(billingName.getText().toString()))
                {
                    Context context = getApplicationContext();
                    CharSequence text = "Please enter full name.";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                }

                else if(TextUtils.isEmpty(billingPhoneNumber.getText().toString()))
                {
                    Context context = getApplicationContext();
                    CharSequence text = "Please enter phone number.";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }

                else if(TextUtils.isEmpty(billingAddress.getText().toString()))
                {
                    Context context = getApplicationContext();
                    CharSequence text = "Please enter home address.";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }

                else if(TextUtils.isEmpty(billingCity.getText().toString()))
                {
                    Context context = getApplicationContext();
                    CharSequence text = "Please enter city.";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }

                else if(TextUtils.isEmpty(billingZipCode.getText().toString()))
                {
                    Context context = getApplicationContext();
                    CharSequence text = "Please enter zip code.";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }

                else if (TextUtils.isEmpty(billingState.getText().toString()))
                {
                    Context context = getApplicationContext();
                    CharSequence text = "Please enter state.";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }

                else
                {
                    confirmOrderWithBillingAdderess();
                }
            }

            private void confirmOrderWithBillingAdderess()
            {
                // Give user confirmation on order
                Context context = getApplicationContext();
                CharSequence text = "Order Confirmed";
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                // return user to home menu
                Intent intent = new Intent(BillingAddressActivity.this, ReceiptActivity.class);
                startActivity(intent);
            }

        });
    }
}
