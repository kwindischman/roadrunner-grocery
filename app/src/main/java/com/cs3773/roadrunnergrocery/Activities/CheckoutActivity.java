package com.cs3773.roadrunnergrocery.Activities;

        import android.os.Bundle;

        import com.cs3773.roadrunnergrocery.Adapters.CartAdapter;
        import com.cs3773.roadrunnergrocery.R;

        import androidx.annotation.Nullable;
        import androidx.appcompat.app.AppCompatActivity;

public class CheckoutActivity extends AppCompatActivity {

    // Variables here

    // Lifecycle methods here
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
    }

    //Other methods here
    /*
        TODO:
            : Get cart information
            : ~ Paypal API registration
            :
            : Set error codes for Paypal
            : //Paypal Implementation Follows//
            : String command = " --- plaintext command to Paypal --- ";
            : ProcessBuilder builder = new ProcessBuilder(command.split(" "));
            : //End Paypal Implementation//
            : Configure API / Calls
            :
            : Local Checkout tax rate calculation by location

     */
/* For a future version
    protected int paypalCheckout(CartAdapter customerOrder)
    {
        //Get cart information
        String command = "curl -v -X GET https://api.sandbox.paypal.com/v1/payment-experience/web-profiles/XP-8YTH-NNP3-WSVN-3C76 \\\n" +
                "  -H \"Content-Type: application/json\" \\\n" +
                "  -H \"Authorization: Bearer AXqi6SV39YYkGRelXU2mqFfOFvSsHhWQS1mWxlnG1o2wXM8rbKlsvmuOvI7qozwsW1SjBz0CR0Cs15LX\"";
        ProcessBuilder builder = new ProcessBuilder(command.split(" "));

        return 0;
    }
*/
    protected double localCheckout(CartAdapter customerOrder)
    {
        float cartTotal = 0.00F;
        for (int i = 0; i < customerOrder.getItemCount() ; i++)
        {
            customerOrder.mProductPairList.get(i);
        }
        float taxRate = 1.0F;
        float discountPercent = 0F;
        float discountMonetary = 0.0F;
        float deliveryCost = 0.00F;

        discountMonetary = PromotionActivity.couponMonetary();
        discountPercent = PromotionActivity.couponPercent();

        //Discount Calculations
        //Find available discounts (user data?)

        if((discountMonetary > 0) || (discountPercent > 0))
        {
            double intermediateTotal = -9999; //debug value: -9999
            if(discountMonetary > 0)
            {
                intermediateTotal = cartTotal - discountMonetary;
            }

            if(discountPercent > 0 && intermediateTotal > 0)
            {
                if(intermediateTotal < (cartTotal - (cartTotal * discountPercent)))
                {
                    intermediateTotal = cartTotal - (cartTotal * discountPercent);
                    intermediateTotal = Math.round(intermediateTotal * 100.0) / 100.0; //Cents accuracy
                }
            }else
            {
                intermediateTotal = (cartTotal - (cartTotal * discountPercent));
                intermediateTotal = Math.round(intermediateTotal * 100.0) / 100.0; //Cents accuracy
            }
        }


        //Delivery & Tax Calculations
        //Get cart information
        //Get & parse user address
        //Lookup tax rate according to location

        //Final Cost
        double finalTotal = cartTotal + (cartTotal * taxRate) + deliveryCost;

        return finalTotal;
    }

}
