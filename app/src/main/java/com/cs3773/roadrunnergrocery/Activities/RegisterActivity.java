package com.cs3773.roadrunnergrocery.Activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import com.cs3773.roadrunnergrocery.R;

public class RegisterActivity extends AppCompatActivity {

    private EditText usernameT, passwordT, emailT, cardNumT, streetT;
    private EditText stateT, cityT, zipCodeT, aptNumT;
    private String username, password, emailAdd, cardNum, streetAdd;
    private String state, zipCode, aptNum, cityStr;
    public static final String PREFERENCE = "preference";
    public static final String PREF_USER = "username";
    public static final String PREF_PASS = "password";
    public static final String PREF_EMAIL = "email";
    public static final String PREF_CARD= "card";
    public static final String PREF_STREET = "street";
    public static final String PREF_APT = "aptNum";
    public static final String PREF_CITY = "city";
    public static final String PREF_STATE = "state";
    public static final String PREF_ZIP = "zipCode";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        usernameT = findViewById(R.id.usernameRText);
        passwordT = findViewById(R.id.passwordRText);
        Button registerB = findViewById(R.id.registerRButton);
        TextView loginT = findViewById(R.id.loginRText);
        TextView asGuestT = findViewById(R.id.asGuestText);
        emailT = findViewById(R.id.emailText);
        cardNumT = findViewById(R.id.cardNumber);
        streetT = findViewById(R.id.streetAddress);
        aptNumT = findViewById(R.id.aptNum);
        stateT = findViewById(R.id.state);
        zipCodeT = findViewById(R.id.zipCode);
        cityT = findViewById(R.id.cityName);

        registerB.setOnClickListener(view -> {
            if(validUserData()){
                SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCE,
                        Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(PREF_USER,username);
                editor.putString(PREF_PASS,password);
                editor.putString(PREF_EMAIL,emailAdd);
                editor.putString(PREF_CARD,cardNum);
                editor.putString(PREF_STREET,streetAdd);
                editor.putString(PREF_STATE,state);
                editor.putString(PREF_APT,aptNum);
                editor.putString(PREF_CITY,cityStr);
                editor.putString(PREF_ZIP,zipCode);
                editor.apply();
                finish();
            }
        });

        asGuestT.setOnClickListener(view -> {
            Intent guestIntent = new Intent(RegisterActivity.this, MainActivity.class);
            startActivity(guestIntent);
        });

        loginT.setOnClickListener(view -> {
            Intent loginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(loginIntent);
        });

    }
    private boolean validUserData() {
        username = usernameT.getText().toString().trim();
        password = passwordT.getText().toString().trim();
        emailAdd = emailT.getText().toString().trim();
        cardNum = cardNumT.getText().toString().trim();
        streetAdd = streetT.getText().toString().trim();
        aptNum = aptNumT.getText().toString().trim();
        state = stateT.getText().toString().trim();
        zipCode = zipCodeT.getText().toString().trim();
        cityStr =cityT.getText().toString().trim();
        return !(username.isEmpty() || password.isEmpty());
    }
}
