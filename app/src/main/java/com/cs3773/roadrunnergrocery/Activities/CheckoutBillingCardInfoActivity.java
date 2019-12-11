package com.cs3773.roadrunnergrocery.Activities;

import androidx.appcompat.app.AppCompatActivity;
import com.cs3773.roadrunnergrocery.R;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class CheckoutBillingCardInfoActivity extends AppCompatActivity {

    private EditText cardName, cardNumber, expDate, cvv;
    private Button confirmBillingOrderButton;
    private CheckBox checkBox;

    // persist data with shared preferences
    public static final String PREFS_CREDIT_CARD_INFO = "userCCInfo";
    public static final String PREFS_CHECKBOX_BOOL = "checkBoxBool";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_billing);
        setupOnClickButton();
    }

    private void setupOnClickButton()
    {
        confirmBillingOrderButton = (Button) findViewById(R.id.finalConfirm_order_button);
        cardName = (EditText) findViewById(R.id.cardNameText);
        cardNumber = (EditText) findViewById(R.id.cardNumberText);
        expDate = (EditText) findViewById(R.id.expDateText);
        cvv = (EditText) findViewById(R.id.cvvText);
        checkBox = (CheckBox) findViewById(R.id.shippingAsBillingCheckbox);

        // set up shared pref object
        SharedPreferences userCreditCardInfo = getSharedPreferences(PREFS_CREDIT_CARD_INFO, MODE_PRIVATE);
        SharedPreferences.Editor editor = userCreditCardInfo.edit();

        SharedPreferences checkBoxBool = getSharedPreferences(PREFS_CHECKBOX_BOOL, MODE_PRIVATE);
        SharedPreferences.Editor checkBoxEditor = checkBoxBool.edit();

        confirmBillingOrderButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                CheckBilling();
            }

            private void prompt(String message)
            {
                Context context = getApplicationContext();
                CharSequence text = message;
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }

            private void CheckBilling()
            {
                if(TextUtils.isEmpty(cardName.getText().toString()))
                {
                    prompt("Please enter name on card.");

                }

                else if(TextUtils.isEmpty(cardNumber.getText().toString()))
                {
                    prompt("Please enter card number.");

                }

                else if(TextUtils.isEmpty(expDate.getText().toString()))
                {
                    prompt("Please enter card expiration date.");

                }

                else if(TextUtils.isEmpty(cvv.getText().toString()))
                {
                    prompt("Please enter card CVV number.");

                }

                else
                {
                    //check if to reuse shipping address as billing address
                    if(checkBox.isChecked())
                    {
                        confirmFinalOrder();
                    }
                    else
                    {
                        billingAddress();
                    }

                }
            }

            private void billingAddress()
            {
                // set SharedPref checkbox bool false
                saveCardData();
                checkBoxEditor.putBoolean("checkBoxBool", false);
                checkBoxEditor.commit();
                Intent intent = new Intent(CheckoutBillingCardInfoActivity.this, BillingAddressActivity.class);
                startActivity(intent);
            }

            private void confirmFinalOrder()
            {
                // set SharedPref checkbox bool true
                saveCardData();
                checkBoxEditor.putBoolean("checkBoxBool", true);
                checkBoxEditor.commit();
                // return user to home menu
                Intent intent = new Intent(CheckoutBillingCardInfoActivity.this, ReceiptActivity.class);
                startActivity(intent);
            }


            private void saveCardData()
            {
                editor.putString("cardName", cardName.getText().toString());
                editor.commit();

                editor.putString("cardNumber", cardNumber.getText().toString());
                editor.commit();

                editor.putString("expDate", expDate.getText().toString());
                editor.commit();

                editor.putString("cvv", cvv.getText().toString());
                editor.commit();
            }
        });
    }
}
