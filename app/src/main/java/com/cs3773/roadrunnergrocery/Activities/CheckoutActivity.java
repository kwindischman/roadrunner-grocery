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
        double intermediateTotal = 0.00F; //debug value: -9999
        discountMonetary = PromotionActivity.couponMonetary();
        discountPercent = PromotionActivity.couponPercent();

        if((discountMonetary > 0) || (discountPercent > 0))
        {

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
        } else
        {
            intermediateTotal = cartTotal;
        }

        String taxes = AccountActivity.PREF_STATE;
        //Delivery & Tax Calculations
        //Get cart information
        //Get & parse user address
        //Lookup tax rate according to location
        try{
            switch(taxes.toLowerCase())
            {
                case "alabama" :
                case "al" : taxRate = .04f;
                    break;
                case "alaska" :
                case "ak" : taxRate = .00f;
                    break;
                case "arizona" :
                case "az" : taxRate = .056f;
                    break;
                case "arkansas" :
                case "ar" : taxRate = .065f;
                    break;
                case "california" :
                case "ca" : taxRate = .0725f;
                    break;
                case "colorado" :
                case "co" : taxRate = .029f;
                    break;
                case "connecticut" :
                case "ct" : taxRate = .0635f;
                    break;
                case "delaware" :
                case "de" : taxRate = .00f;
                    break;
                case "florida" :
                case "fl" : taxRate = .06f;
                    break;
                case "georgia" :
                case "ga" : taxRate = .04f;
                    break;
                case "hawaii" :
                case "hi" : taxRate = .04f;
                    break;
                case "idaho" :
                case "id" : taxRate = .06f;
                    break;
                case "illinois" :
                case "il" : taxRate =.0625f;
                    break;
                case "indiana" :
                case "in" : taxRate = .07f;
                    break;
                case "iowa" :
                case "ia" : taxRate =  .06f;
                    break;
                case "kansas" :
                case "ks" : taxRate = .065f;
                    break;
                case "kentucky" :
                case "ky" : taxRate =.06f;
                    break;
                case "louisiana" :
                case "la" : taxRate = .0445f;
                    break;
                case "maine" :
                case "me" : taxRate = .055f;
                    break;
                case "maryland" :
                case "md" : taxRate = .06f;
                    break;
                case "massachusetts" :
                case "ma" : taxRate = .0625f;
                    break;
                case "michigan" :
                case "mi" : taxRate = .06f;
                    break;
                case "minnesota" :
                case "mn" : taxRate = .06875f;
                    break;
                case "mississippi" :
                case "ms" : taxRate = .07f;
                    break;
                case "missouri" :
                case "mo" : taxRate = .04225f;
                    break;
                case "montana" :
                case "mt" : taxRate = 0.0f;
                    break;
                case "nebraska" :
                case "ne" : taxRate = .055f;
                    break;
                case "nevada" :
                case "nv" : taxRate = .0685f;
                    break;
                case "new hampshire" :
                case "nh" : taxRate = 0.0f;
                    break;
                case "new jersey" :
                case "nj" : taxRate = .0625f;
                    break;
                case "new mexico" :
                case "nm" : taxRate = .05125f;
                    break;
                case "new york" :
                case "ny" : taxRate = .04f;
                    break;
                case "north carolina" :
                case "nc" : taxRate = .0475f;
                    break;
                case "north dakota" :
                case "nd" : taxRate = .05f;
                    break;
                case "ohio" :
                case "oh" : taxRate = .0575f;
                    break;
                case "oklahoma" :
                case "ok" : taxRate = .045f;
                    break;
                case "oregon" :
                case "or" : taxRate = .00f;
                    break;
                case "pennsylvania" :
                case "pa" : taxRate = .06f;
                    break;
                case "rhode island" :
                case "ri" : taxRate = .07f;
                    break;
                case "south carolina" :
                case "sc" : taxRate = .06f;
                    break;
                case "south dakota" :
                case "sd" : taxRate = .045f;
                    break;
                case "tennessee" :
                case "tn" : taxRate = .07f;
                    break;
                case "texas" :
                case "tx" : taxRate = .0625f;
                    break;
                case "utah" :
                case "ut" : taxRate = .0485f;
                    break;
                case "vermont" :
                case "vt" : taxRate = .06f;
                    break;
                case "virginia" :
                case "va" : taxRate = .043f;
                    break;
                case "washington" :
                case "wa" : taxRate = .065f;
                    break;
                case "west virginia" :
                case "wv" : taxRate = .06f;
                    break;
                case "wisconsin" :
                case "wi" : taxRate = .05f;
                    break;
                case "wyoming" :
                case "wy" : taxRate = .04f;
                    break;
            }
        }catch(NullPointerException e)
        {
            taxRate = .09F;
        }

        //Final Cost
        double finalTotal = intermediateTotal + (cartTotal * taxRate);

        return finalTotal;
    }

}
