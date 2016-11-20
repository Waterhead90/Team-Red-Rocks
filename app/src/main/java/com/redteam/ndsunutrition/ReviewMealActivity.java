package com.redteam.ndsunutrition;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.Engine.Date;
import com.Engine.Meal;
import com.Engine.MealDate;
import com.Engine.Venue;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ReviewMealActivity extends AppCompatActivity
{
    private String[] mealItems;
    private LinearLayout reviewLinearLayout;
    private Meal meal;
    private MealDate mealDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_meal);

        Intent intent = getIntent();

        meal = (Meal) intent.getSerializableExtra("Meal items");
        reviewLinearLayout = (LinearLayout) findViewById(R.id.linearLayoutReview);
        this.showMealInfo();
    }

    private void showMealInfo() {
        String ampm;
        String minute;
        mealDate = (MealDate) meal.getDate();
        String date = (mealDate.getMonth() + 1) + "/" + mealDate.getDay() + "/" + mealDate.getDay();
        int hour = mealDate.getHour();
        if (hour > 12)
        {
            hour = hour % 12;
            ampm = "PM";
        }
        else if(hour == 12)
        {
            ampm = "PM";
        }
        else if(hour == 0)
        {
            hour = 12;
            ampm = "AM";
        }
        else
        {
           ampm = "AM";
        }

        // If minute is 0, pad it with an extra 0, otherwise minute is 30
        if(mealDate.getMinute() == 0 )
        {
            minute = "00";
        }
        else
        {
            minute = "30";
        }

        String time = hour + ":" + minute + " " + ampm;

        /*
        Add text views for the other meal attributes to the LinearLayout
         */
        TextView locationTextView = new TextView(this);
        locationTextView.setText("Location: " + meal.getLocation().getName());
        locationTextView.setTextColor(Color.BLACK);
        locationTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        reviewLinearLayout.addView(locationTextView);

        TextView dateTextView = new TextView(this);
        dateTextView.setText("Date: " + date);
        dateTextView.setTextColor(Color.BLACK);
        dateTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        reviewLinearLayout.addView(dateTextView);

        TextView timeTextView = new TextView(this);
        timeTextView.setText("Time: " + time);
        timeTextView.setTextColor(Color.BLACK);
        timeTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        reviewLinearLayout.addView(timeTextView);

        // Uncomment when we get support for meal entries
        /*for (int i = 0; i < mealItems.length; i++)
        {
            TextView textView = new TextView(this);
            textView.setText(mealItems[i]);
            textView.setTextColor(Color.BLACK);
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
            reviewLinearLayout.addView(textView);
        }*/

    }

    public void submitMeal(View view)
    {
        //Send meal info to phone database here

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
