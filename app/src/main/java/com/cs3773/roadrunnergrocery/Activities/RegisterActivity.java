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

    private EditText usernameT, passwordT;
    private String username, password;
    public static final String PREFERENCE = "preference";
    public static final String PREF_NAME = "name";
    public static final String PREF_PASS = "password";


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        usernameT = findViewById(R.id.usernameRText);
        passwordT = findViewById(R.id.passwordRText);
        Button registerB = findViewById(R.id.registerRButton);
        TextView loginT = findViewById(R.id.loginRText);
        TextView asGuestT = findViewById(R.id.asGuestText);

        registerB.setOnClickListener(view -> {
            if(validUserData()){
                SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCE,
                        Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(PREF_NAME,username);
                editor.putString(PREF_PASS,password);
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
        return !(username.isEmpty() || password.isEmpty());
    }
}
