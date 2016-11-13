package com.redteam.ndsunutrition;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by gage.askegard on 10/22/2016.
 */
public class PickRestaurantActivity extends AppCompatActivity
{
    private TextView invalidTextView;
    private Spinner restaurantSpinner;
    private Spinner spinnerDate;
    private Spinner spinnerTime;
    private RadioButton radioButtonAM;
    private RadioButton radioButtonPM;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> restaurants;
    private CalendarSpinnerAdapter mSpinnerDateAdapter;

    private int hour;
    private int minute;

    public final static String EXTRA_MESSAGE = "com.redteam.ndsunutrition.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_restaurant);

        Intent intent = getIntent();

        invalidTextView = (TextView) findViewById(R.id.textViewInvalidRestaurant);
        invalidTextView.setVisibility(View.INVISIBLE);
        restaurantSpinner = (Spinner) findViewById(R.id.spinnerRestaurants);
        spinnerDate = (Spinner) findViewById(R.id.spinnerDate);
        spinnerTime = (Spinner) findViewById(R.id.spinnerTime);
        radioButtonAM = (RadioButton) findViewById(R.id.radioButtonAM);
        radioButtonPM = (RadioButton) findViewById(R.id.radioButtonPM);

        setCurrentTime();
        getRestaurants();
        addItemSelectedListenerToSpinner();
        setUpDateSpinner();

        /*
        Create empty meal object with default constructor
         */
    }

    // Very long method to set the current time
    private void setCurrentTime()
    {
        final Calendar c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR_OF_DAY );
        minute = c.get(Calendar.MINUTE);

        // Make hour into a 12-hour format
        if(hour > 12)
        {
            hour = hour % 12;
            radioButtonPM.setChecked(true);
        }
        else if(hour == 12)
        {
            radioButtonPM.setChecked(true);
        }
        else if(hour == 0)
        {
            hour = 12;
            radioButtonAM.setChecked(true);
        }
        else
        {
            radioButtonAM.setChecked(true);
        }

        // Round to nearest half-hour increment
        if(minute >= 15 && minute <= 45)
        {
            minute = 30;
        }
        else if(minute > 45)
        {
            minute = 0;
            hour++;
        }
        else
        {
            minute = 0;
        }

        // Use hour and minute to set the selection
        // This is super long and probably not the best
        switch(hour)
        {
            case 1:
            {
                if(minute == 0)
                    spinnerTime.setSelection(0);
                else
                    spinnerTime.setSelection(1);
                break;
            }
            case 2:
            {
                if(minute == 0)
                    spinnerTime.setSelection(2);
                else
                    spinnerTime.setSelection(3);
                break;
            }
            case 3:
            {
                if(minute == 0)
                    spinnerTime.setSelection(4);
                else
                    spinnerTime.setSelection(5);
                break;
            }
            case 4:
            {
                if(minute == 0)
                    spinnerTime.setSelection(6);
                else
                    spinnerTime.setSelection(7);
                break;
            }
            case 5:
            {
                if(minute == 0)
                    spinnerTime.setSelection(8);
                else
                    spinnerTime.setSelection(9);
                break;
            }
            case 6:
            {
                if(minute == 0)
                    spinnerTime.setSelection(10);
                else
                    spinnerTime.setSelection(11);
                break;
            }
            case 7:
            {
                if(minute == 0)
                    spinnerTime.setSelection(12);
                else
                    spinnerTime.setSelection(13);
                break;
            }
            case 8:
            {
                if(minute == 0)
                    spinnerTime.setSelection(14);
                else
                    spinnerTime.setSelection(15);
                break;
            }
            case 9:
            {
                if(minute == 0)
                    spinnerTime.setSelection(16);
                else
                    spinnerTime.setSelection(17);
                break;
            }
            case 10:
            {
                if(minute == 0)
                    spinnerTime.setSelection(18);
                else
                    spinnerTime.setSelection(19);
                break;
            }
            case 11:
            {
                if(minute == 0)
                    spinnerTime.setSelection(20);
                else
                    spinnerTime.setSelection(21);
                break;
            }
            case 12:
            {
                if(minute == 0)
                    spinnerTime.setSelection(22);
                else
                    spinnerTime.setSelection(23);
                break;
            }
        }
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

    private void setUpDateSpinner()
    {
        mSpinnerDateAdapter = new CalendarSpinnerAdapter(PickRestaurantActivity.this, Calendar.getInstance(), 30);
        spinnerDate.setAdapter(mSpinnerDateAdapter);

        spinnerDate.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                Calendar selectedDate = Calendar.getInstance();
                selectedDate.setTimeInMillis(mSpinnerDateAdapter.getItem(position).getTimeInMillis());
                selectedDate.add(Calendar.DAY_OF_YEAR, 1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }

        });

        spinnerDate.setSelection(29);
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
            /*
            set meal location variable as the selection
            set meal date as the selected date and time
            send meal object to next activity
             */
            intent.putExtra(EXTRA_MESSAGE, selection);
            startActivity(intent);
        }
    }
}
