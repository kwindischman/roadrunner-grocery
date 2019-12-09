package com.cs3773.roadrunnergrocery.Activities;

import androidx.appcompat.app.AppCompatActivity;
import com.cs3773.roadrunnergrocery.R;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BillingAddressActivity extends AppCompatActivity {

    private EditText billingName, billingPhoneNumber, billingAddress, billingCity, billingZipCode, billingState;
    private Button confirmCheckoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billing_address);

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

            }
        });
    }
}
