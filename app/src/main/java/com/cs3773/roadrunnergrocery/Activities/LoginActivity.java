package com.cs3773.roadrunnergrocery.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.cs3773.roadrunnergrocery.R;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameT, passwordT;
    private SharedPreferences sharedPreferences;
    public static final String PREFERENCE = "preference";
    public static final String PREF_USER = "username";
    public static final String PREF_PASS = "password";
    public static final String PREF_SKIP_LOGIN = "skip_login";


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPreferences = getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE);

        if(sharedPreferences.contains(PREF_SKIP_LOGIN)){
            Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(mainIntent);
            finish();
        }else{

            usernameT = findViewById(R.id.usernameText);
            passwordT = findViewById(R.id.passwordText);
            Button loginB = findViewById(R.id.loginButton);
            TextView registerT = findViewById(R.id.regText);
            TextView asGuestT = findViewById(R.id.asGuestText);

            loginB.setOnClickListener(view -> {



                if(validUserData()){
                    if(sharedPreferences.contains(PREF_USER)&&
                            sharedPreferences.contains(PREF_PASS)){

                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString(PREF_SKIP_LOGIN,"skip");
                        editor.apply();
                        Intent mainIntent = new Intent(LoginActivity.this,
                                MainActivity.class);
                        startActivity(mainIntent);
                        finish();
                    }else{
                        Toast.makeText(getApplicationContext(), "Unable to Login, Register",
                                Toast.LENGTH_LONG).show();
                    }
                }
            });
            asGuestT.setOnClickListener(view -> {
                Intent guestIntent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(guestIntent);
            });

            registerT.setOnClickListener(view -> {
                Intent registerIntent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(registerIntent);

            });
        }
    }
    private boolean validUserData() {
        String username = usernameT.getText().toString().trim();
        String password = passwordT.getText().toString().trim();
        return !(username.isEmpty() || password.isEmpty());
    }
}
