package com.redteam.ndsunutrition;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.Engine.Meal;

import java.util.ArrayList;

public class MenuItemActivity extends AppCompatActivity
{

    private TextView menuTextView;
    private TextView invalidTextView;
    private TextView noItemsTextView;
    private Spinner menuItemSpinner;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> menuItems;
    private ArrayList<String> mealItems;
    private Meal meal;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_item);

        Intent intent = getIntent();
        meal = (Meal) intent.getSerializableExtra(PickRestaurantActivity.EXTRA_MESSAGE);

        menuTextView = (TextView) findViewById(R.id.textViewPickMeal);
        invalidTextView = (TextView) findViewById(R.id.textViewInvalidItem);
        invalidTextView.setVisibility(View.INVISIBLE);
        noItemsTextView = (TextView) findViewById(R.id.textViewNoItems);
        noItemsTextView.setVisibility(View.INVISIBLE);
        menuItemSpinner = (Spinner) findViewById(R.id.spinnerMenuItems);

        mealItems = new ArrayList<>();

        getMenuItems(meal.getLocation().getName());
        addItemSelectedListenerToSpinner();
    }

    private void addItemSelectedListenerToSpinner()
    {
        menuItemSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            // Hide the invalid selection text when the user selects an item
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                if(!menuItemSpinner.getSelectedItem().toString().equals("Select One"))
                {
                    invalidTextView.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // Don't need to do anything here
            }
        });
    }

    private void getMenuItems(String restaurant)
    {
        menuItems = new ArrayList<>();
        menuItems.add("Select One");
        // Will need to get the list of available menu items based on the value of restaurant
        // Potentially in the form of a string array

        //We will do this a different way once we have the API
        if(restaurant.equals("Panda Express"))
        {
            // Add dummy data
            menuItems.add("Fried Rice");
            menuItems.add("Orange Chicken");
            menuItems.add("General Tsao's Chicken");

            // Adapt the string array to be used by the spinner
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, menuItems);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            // Link restaurantSpinner to our adapter
            menuItemSpinner.setAdapter(adapter);
        }
        else
        {
            // Add dummy data
            menuItems.add("Cheese Burger");
            menuItems.add("Cheese Burger Combo");
            menuItems.add("Small French Fries");
            menuItems.add("Medium French Fries");

            // Adapt the string array to be used by the spinner
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, menuItems);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            // Link restaurantSpinner to our adapter
            menuItemSpinner.setAdapter(adapter);
        }
    }

    public void addMealItem(View view)
    {
        Toast toast;
        toast = Toast.makeText(getApplicationContext(), "Item Added!", Toast.LENGTH_SHORT);
        // Show the invalid TextView if the user tries to submit the default value
        if(menuItemSpinner.getSelectedItem().toString().equals("Select One"))
        {
            invalidTextView.setVisibility(View.VISIBLE);
        }
        else
        {
            mealItems.add(menuItemSpinner.getSelectedItem().toString());
            noItemsTextView.setVisibility(View.INVISIBLE);
            toast.show();
        }
    }

    public void reviewMeal(View view)
    {
        // Show the invalid TextView if the user tries to submit the default value
        if(mealItems.isEmpty())
        {
            noItemsTextView.setVisibility(View.VISIBLE);
        }
        else // Send an intent to return to mainActivity
        // We will also need to save the meal data here or call another method to do so
        {
            String[] mealItemsArray = new String[mealItems.size()];
            for(int i = 0; i < mealItems.size(); i++)
            {
                mealItemsArray[i] = mealItems.get(i);
            }
            Intent intent = new Intent(this, ReviewMealActivity.class);
            intent.putExtra("Meal items", meal);
            startActivity(intent);
        }
    }
}
