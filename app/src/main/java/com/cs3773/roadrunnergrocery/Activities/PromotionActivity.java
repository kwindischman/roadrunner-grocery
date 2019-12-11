package com.cs3773.roadrunnergrocery.Activities;

import android.os.Bundle;

import com.cs3773.roadrunnergrocery.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
public class PromotionActivity extends AppCompatActivity {

    public static final float NEW_YEAR_SALE = .10F;
    public static final float MOTHERS_DAY_SALE = .10F;
    public static final float FATHERS_DAY_SALE = .10F;
    public static final float VALENTINES_SALE = .14F;
    public static final float INDPENDENCE_DAY_SALE = .17F;
    public static final float HALLOWEEN_SALE = .13F;
    public static final float BLACK_FRIDAY_SALE = .4F;
    public static final float CHRISTMAS_SALE = .25F;


    // Lifecycle methods here
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotion);
    }

    public static float couponPercent()
    {
        float fDiscount = 0.0f;
        Calendar today;
        today = Calendar.getInstance();
        int tDay, tMonth;
        tDay = today.get(Calendar.DAY_OF_MONTH);
        tMonth = today.get(Calendar.MONTH);


        switch(tMonth) //Holiday Discounts
        {
            case 1:
                if(tDay == 1)
                    return NEW_YEAR_SALE;
                break;
            case 2:
                if(tDay == 14)
                    return VALENTINES_SALE;
                break;
            case 5:
                if(tDay == 12)
                    return MOTHERS_DAY_SALE;
                break;
            case 6:
                if(tDay == 16)
                    return FATHERS_DAY_SALE;
                break;
            case 7:
                if(tDay == 4)
                    return INDPENDENCE_DAY_SALE;
                break;
            case 10:
                if(tDay == 31)
                    return HALLOWEEN_SALE;
               break;
            case 11:
                if((today.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) &&
                        (tDay > 22) && (tDay < 30))
                    return BLACK_FRIDAY_SALE;
                break;
            case 12:
                if((tDay > 18) && (tDay < 24))
                    return CHRISTMAS_SALE;
                break;
            default: break;
        }

        if((tDay == 13) && (today.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY))
            fDiscount = HALLOWEEN_SALE;

        return fDiscount;
    }


    public static float couponMonetary()
    {
        float fDiscount = 0.0f;


        return fDiscount;
    }
}
