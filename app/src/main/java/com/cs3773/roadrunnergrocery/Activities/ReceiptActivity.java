package com.cs3773.roadrunnergrocery.Activities;

import androidx.appcompat.app.AppCompatActivity;
import com.cs3773.roadrunnergrocery.R;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ReceiptActivity extends AppCompatActivity {

    private TextView fullNameTextView, phoneNumberTextView, homeAddressTextView, cityNameTextView, zipCodeTextView, stateTextView;
    private Button confirmFinalOrderButton;

    // sharedPref objects references
    public static final String PREFS_SHIPPING_INFO = "userShippingInfo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);
        setUserInfoViews();
        setUpOnClickButtonAction();
    }

    private void setUpOnClickButtonAction()
    {
        confirmFinalOrderButton = (Button) findViewById(R.id.receipt_confirm_order_button);

        confirmFinalOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                transitionToMainActivity();
            }

            private void transitionToMainActivity()
            {
                confirmOrder();
                Intent intent = new Intent(ReceiptActivity.this, MainActivity.class);
                startActivity(intent);
            }

            private void confirmOrder()
            {
                // TODO: save order in a sharedPref for orderHistories?
                Context context = getApplicationContext();
                CharSequence text = "Order Submitted.";
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });

    }

    public void setUserInfoViews()
    {
        fullNameTextView = (TextView) findViewById(R.id.receiptFullName);
        phoneNumberTextView = (TextView) findViewById(R.id.receiptPhoneNumberText);
        homeAddressTextView = (TextView) findViewById(R.id.receiptAddressText);
        cityNameTextView = (TextView) findViewById(R.id.receiptCityAddressText);
        zipCodeTextView = (TextView) findViewById(R.id.receiptZipCodeText);
        stateTextView = (TextView) findViewById(R.id.receiptStateText);

        // use this to extract full name from shared prefs
        SharedPreferences userInfo = getSharedPreferences(PREFS_SHIPPING_INFO, MODE_PRIVATE);
        String userFullName = userInfo.getString("userFullName","");
        String userPhoneNumber = userInfo.getString("userPhoneNumber","");
        String userHomeAddress = userInfo.getString("userHomeAddress","");
        String userCityAddress = userInfo.getString("userCityAddress","");
        String userZipCode = userInfo.getString("userZipCode","");
        String userState = userInfo.getString("userState","");

        fullNameTextView.setText(userFullName);
        phoneNumberTextView.setText(userPhoneNumber);
        homeAddressTextView.setText(userHomeAddress);
        cityNameTextView.setText(userCityAddress);
        zipCodeTextView.setText(userZipCode);
        stateTextView.setText(userState);
    }
}
