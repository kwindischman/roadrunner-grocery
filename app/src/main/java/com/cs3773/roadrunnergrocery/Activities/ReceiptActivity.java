package com.cs3773.roadrunnergrocery.Activities;

import androidx.appcompat.app.AppCompatActivity;
import com.cs3773.roadrunnergrocery.R;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ReceiptActivity extends AppCompatActivity {

    private TextView fullNameTextView;
    public static final String PREFS="userShippingInfo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);
        setUserInfoViews();
    }

    public void setUserInfoViews()
    {
        fullNameTextView = (TextView) findViewById(R.id.receiptFullName);

        // use this to extract full name from shared prefs
        SharedPreferences userInfo = getSharedPreferences(PREFS, MODE_PRIVATE);
        String userFullName = userInfo.getString("userFullName","");

        fullNameTextView.setText(userFullName);
    }
}
