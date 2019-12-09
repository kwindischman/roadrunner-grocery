package com.cs3773.roadrunnergrocery.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.cs3773.roadrunnergrocery.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AccountActivity extends AppCompatActivity {

    // Variables here
    private EditText usernameT, passwordT, emailT, cardNumT, streetT;
    private EditText stateT, cityT, zipCodeT, aptNumT;
    private String username, password, emailAdd, cardNum, streetAdd;
    private String state, zipCode, aptNum, cityStr;

    private SharedPreferences sharedPreferences;

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

    // Lifecycle methods here
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        usernameT = findViewById(R.id.usernameRText);
        passwordT = findViewById(R.id.passwordRText);
        emailT = findViewById(R.id.emailText);
        cardNumT = findViewById(R.id.cardNumber);
        streetT = findViewById(R.id.streetAddress);
        aptNumT = findViewById(R.id.aptNum);
        stateT = findViewById(R.id.state);
        zipCodeT = findViewById(R.id.zipCode);
        cityT = findViewById(R.id.cityName);

        //display data
        sharedPreferences = getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE);

        if(sharedPreferences.contains(PREF_USER)){
            usernameT.setText(sharedPreferences.getString(PREF_USER, ""));
        }
        if(sharedPreferences.contains(PREF_PASS)){
            passwordT.setText(sharedPreferences.getString(PREF_PASS, ""));
        }
        if(sharedPreferences.contains(PREF_EMAIL)){
            emailT.setText(sharedPreferences.getString(PREF_EMAIL, ""));
        }
        if(sharedPreferences.contains(PREF_CARD)){
            cardNumT.setText(sharedPreferences.getString(PREF_CARD, ""));
        }
        if(sharedPreferences.contains(PREF_STREET)){
            streetT.setText(sharedPreferences.getString(PREF_STREET, ""));
        }
        if(sharedPreferences.contains(PREF_APT)){
            aptNumT.setText(sharedPreferences.getString(PREF_APT, ""));
        }
        if(sharedPreferences.contains(PREF_STATE)){
            stateT.setText(sharedPreferences.getString(PREF_STATE, ""));
        }
        if(sharedPreferences.contains(PREF_ZIP)){
            zipCodeT.setText(sharedPreferences.getString(PREF_ZIP, ""));
        }
        if(sharedPreferences.contains(PREF_CITY)){
            cityT.setText(sharedPreferences.getString(PREF_CITY, ""));
        }

        //update data
        Button updateB = findViewById(R.id.updateButton);
        updateB.setOnClickListener(view -> {
            if(validUserData()){
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


    //Other methods here


}
