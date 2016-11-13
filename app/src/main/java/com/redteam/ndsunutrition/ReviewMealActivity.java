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

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ReviewMealActivity extends AppCompatActivity
{
    private String[] mealItems;
    private LinearLayout reviewLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_meal);

        Intent intent = getIntent();

        mealItems = intent.getStringArrayExtra("Meal items");
        reviewLinearLayout = (LinearLayout) findViewById(R.id.linearLayoutReview);

        /*
        Add text views for the other meal attributes to the LinearLayout
         */

        for (int i = 0; i < mealItems.length; i++)
        {
            TextView textView = new TextView(this);
            textView.setText(mealItems[i]);
            textView.setTextColor(Color.BLACK);
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
            reviewLinearLayout.addView(textView);
        }
    }

    public void submitMeal(View view)
    {
        //Send meal info to phone database here

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
