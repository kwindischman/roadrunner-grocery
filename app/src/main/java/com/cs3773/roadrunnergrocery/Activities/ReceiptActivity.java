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

    private TextView fullNameTextView, phoneNumberTextView, homeAddressTextView
                    , cityNameTextView, zipCodeTextView, stateTextView
                    , cardName, cardNumber, expDate
                    , cvv
                    , billingFullNameTextView, billingPhoneNumberTextView, billingHomeAddressTextView
                    , billingCityNameTextView, billingZipCodeTextView, billingStateTextView;

    private Button confirmFinalOrderButton;

    // sharedPref objects references
    public static final String PREFS_SHIPPING_INFO = "userShippingInfo";
    public static final String PREFS_CHECKBOX_BOOL = "checkBoxBool";
    public static final String PREFS_BILLING_INFO = "userBillingInfo";

    //TODO: Do we need to show card info.?
    public static final String PREFS_CREDIT_CARD_INFO = "userCCInfo";


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
        // shipping info
        fullNameTextView = (TextView) findViewById(R.id.receiptFullName);
        phoneNumberTextView = (TextView) findViewById(R.id.receiptPhoneNumberText);
        homeAddressTextView = (TextView) findViewById(R.id.receiptAddressText);
        cityNameTextView = (TextView) findViewById(R.id.receiptCityAddressText);
        zipCodeTextView = (TextView) findViewById(R.id.receiptZipCodeText);
        stateTextView = (TextView) findViewById(R.id.receiptStateText);

        // billing info
        billingFullNameTextView = (TextView) findViewById(R.id.billingReceiptFullName);
        billingPhoneNumberTextView = (TextView) findViewById(R.id.billingReceiptPhoneNumberText);
        billingHomeAddressTextView = (TextView) findViewById(R.id.billingReceiptAddressText);
        billingCityNameTextView = (TextView) findViewById(R.id.billingReceiptCityAddressText);
        billingZipCodeTextView = (TextView) findViewById(R.id.billingReceiptZipCodeText);
        billingStateTextView = (TextView) findViewById(R.id.billingReceiptStateText);

        // get checkbox checkbox bool value
        SharedPreferences checkBoxBool = getSharedPreferences(PREFS_CHECKBOX_BOOL, MODE_PRIVATE);
        boolean checkBoxFlag = checkBoxBool.getBoolean("checkBoxBool",false);

        if (checkBoxFlag){
            // put shipping info from shipping info activity in receipt
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

            // billing sae as shipping details
            billingFullNameTextView.setText(userFullName);
            billingPhoneNumberTextView.setText(userPhoneNumber);
            billingHomeAddressTextView.setText(userHomeAddress);
            billingCityNameTextView.setText(userCityAddress);
            billingZipCodeTextView.setText(userZipCode);
            billingStateTextView.setText(userState);
        }

        else {
            // put shipping info from shipping info activity in receipt
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

            // put billing info from billing info activity in receipt
            SharedPreferences userBillingInfo = getSharedPreferences(PREFS_BILLING_INFO, MODE_PRIVATE);
            String userBillingFullName = userBillingInfo.getString("billingUserFullName","");
            String userBillingPhoneNumber = userBillingInfo.getString("billingPhoneNumber","");
            String userBillingHomeAddress = userBillingInfo.getString("billingAddress","");
            String userBillingCityAddress = userBillingInfo.getString("billingCity","");
            String userBillingState = userBillingInfo.getString("billingState","");
            String userBillingZipCode = userBillingInfo.getString("billingZipCode","");

            billingFullNameTextView.setText(userBillingFullName);
            billingPhoneNumberTextView.setText(userBillingPhoneNumber);
            billingHomeAddressTextView.setText(userBillingHomeAddress);
            billingCityNameTextView.setText(userBillingCityAddress);
            billingZipCodeTextView.setText(userBillingZipCode);
            billingStateTextView.setText(userBillingState);
        }


    }
}
