package com.redteam.ndsunutrition;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AddItemActivity extends AppCompatActivity
{
    private Button restaurantButton;
    private Button customMealButton;
    private TextView pickMealTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        Intent intent = getIntent();

        restaurantButton = (Button) findViewById(R.id.buttonRestaurant);
        customMealButton = (Button) findViewById(R.id.buttonCustomMeal);
        pickMealTextView = (TextView) findViewById(R.id.textViewPickMeal);
    }

    public void goToRestaurants(View view)
    {
        Intent intent = new Intent(this, PickRestaurantActivity.class);
        startActivity(intent);
    }

    public void createCustomMeal(View view)
    {
        // Send intent to custom meal creation class here
    }
}
