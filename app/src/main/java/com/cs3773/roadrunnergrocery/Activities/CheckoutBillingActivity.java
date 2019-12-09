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

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CheckoutBillingActivity extends AppCompatActivity {

    private EditText cardName, cardNumber, expDate, cvv;
    private Button confirmBillingOrderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_billing);

        confirmBillingOrderButton = (Button) findViewById(R.id.finalConfirm_order_button);
        cardName = (EditText) findViewById(R.id.cardNameText);
        cardNumber = (EditText) findViewById(R.id.cardNumberText);
        expDate = (EditText) findViewById(R.id.expDateText);
        cvv = (EditText) findViewById(R.id.cvvText);

        confirmBillingOrderButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                CheckBilling();
            }

            private void CheckBilling()
            {
                if(TextUtils.isEmpty(cardName.getText().toString()))
                {
                    Context context = getApplicationContext();
                    CharSequence text = "Please enter name on shown on credit card.";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                }

                else if(TextUtils.isEmpty(cardNumber.getText().toString()))
                {
                    Context context = getApplicationContext();
                    CharSequence text = "Please enter card number.";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                }

                else if(TextUtils.isEmpty(expDate.getText().toString()))
                {
                    Context context = getApplicationContext();
                    CharSequence text = "Please enter card expiration date.";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                }

                else if(TextUtils.isEmpty(cvv.getText().toString()))
                {
                    Context context = getApplicationContext();
                    CharSequence text = "Please enter card CVV number.";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                }

                else
                {
                    confirmFinalOrder();
                }
            }

            private void confirmFinalOrder()
            {
                /*
                final String saveCurrentDate, saveCurrentTime;
                Calendar calForDate = Calendar.getInstance();

                SimpleDateFormat currentDate = new SimpleDateFormat("MMM dd, yyyy");
                saveCurrentDate = currentDate.format(calForDate.getTime());

                SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss a");
                saveCurrentTime = currentDate.format(calForDate.getTime());
                */

                // TODO: save order to database if created and clear cart for next order

                // Give user confirmation on order
                Context context = getApplicationContext();
                CharSequence text = "Order Confirmed";
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                // return user to home menu
                Intent intent = new Intent(CheckoutBillingActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });




    }
}
