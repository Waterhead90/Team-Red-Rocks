package com.redteam.ndsunutrition;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by gage.askegard on 10/22/2016.
 */
public class PickRestaurantActivity extends AppCompatActivity
{
    private TextView restaurantTextView;
    private TextView invalidTextView;
    private Spinner restaurantSpinner;
    private Button selectRestaurantButton;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> restaurants;

    public final static String EXTRA_MESSAGE = "com.redteam.ndsunutrition.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_restaurant);

        Intent intent = getIntent();

        restaurantTextView = (TextView) findViewById(R.id.textViewPickRestaurant);
        invalidTextView = (TextView) findViewById(R.id.textViewInvalidRestaurant);
        invalidTextView.setVisibility(View.INVISIBLE);
        restaurantSpinner = (Spinner) findViewById(R.id.spinnerRestaurants);
        selectRestaurantButton = (Button) findViewById(R.id.buttonSelectRestaurant);
        getRestaurants();

        addItemSelectedListenerToSpinner();
    }

    private void addItemSelectedListenerToSpinner()
    {
        restaurantSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            // Hide the invalid selection text when the user selects an item
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                if(!restaurantSpinner.getSelectedItem().toString().equals("Select One"))
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

    // Populates restaurantSpinner with a list of restaurants
    private void getRestaurants()
    {
        // Will need to get the list of available restaurants
        // Potentially in the form of a string array

        restaurants = new ArrayList<>();

        // Dummy data, we will use the API to populate the list beforehand
        restaurants.add("Select One");
        restaurants.add("Panda Express");
        restaurants.add("Some Other Restaurant");

        // Adapt the string array to be used by the spinner
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, restaurants);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Link restaurantSpinner to our adapter
        restaurantSpinner.setAdapter(adapter);
    }

    // Send an intent to MenuItemActivity to select a menu item
    // might be able to do this in the same activity but this is simpler for now
    public void viewMenu(View view)
    {
        // Show the invalid TextView if the user tries to submit the default value
        if(restaurantSpinner.getSelectedItem().toString().equals("Select One"))
        {
            invalidTextView.setVisibility(View.VISIBLE);
        }
        else // Send an intent to the next activity containing the user's selection
        {
            Intent intent = new Intent(this, MenuItemActivity.class);

            String selection = restaurantSpinner.getSelectedItem().toString();
            intent.putExtra(EXTRA_MESSAGE, selection);
            startActivity(intent);
        }
    }
}
