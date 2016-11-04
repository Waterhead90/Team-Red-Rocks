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
    private TextView timeTextView;
    private Spinner restaurantSpinner;
    private Spinner spinnerDate;
    private Button selectRestaurantButton;
    private Button changeTimeButton;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> restaurants;
    private CalendarSpinnerAdapter mSpinnerDateAdapter;
    private CustomTimePickerDialog mTimePickerDioalg;

    private int hour;
    private int minute;
    private String ampm;

    static final int TIME_DIALOG_ID = 999;
    public final static String EXTRA_MESSAGE = "com.redteam.ndsunutrition.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_restaurant);

        Intent intent = getIntent();

        invalidTextView = (TextView) findViewById(R.id.textViewInvalidRestaurant);
        timeTextView = (TextView) findViewById(R.id.textViewTime);
        invalidTextView.setVisibility(View.INVISIBLE);
        restaurantSpinner = (Spinner) findViewById(R.id.spinnerRestaurants);
        selectRestaurantButton = (Button) findViewById(R.id.buttonSelectRestaurant);
        changeTimeButton = (Button) findViewById(R.id.buttonChangeTime);
        spinnerDate = (Spinner) findViewById(R.id.spinnerDate);

        setCurrentTime();
        getRestaurants();
        addItemSelectedListenerToSpinner();
        setUpDateSpinner();
    }

    private void setCurrentTime()
    {
        final Calendar c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR_OF_DAY );
        minute = c.get(Calendar.MINUTE);

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

        // Make hours display in a 12-hour format
        if(hour > 12)
        {
            hour = hour % 12;
            ampm = " PM";
        }
        else if(hour == 12)
        {
            ampm = " PM";
        }
        else if(hour == 0)
        {
            hour = 12;
            ampm = " AM";
        }
        else
        {
            ampm = " AM";
        }
        // set current time into textview
        timeTextView.setText(new StringBuilder().append(pad(hour)).append(":").append(pad(minute)).append(ampm));

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
            intent.putExtra(EXTRA_MESSAGE, selection);
            startActivity(intent);
        }
    }

    public void changeTime(View view)
    {
        showDialog(TIME_DIALOG_ID);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case TIME_DIALOG_ID:
                // set time picker as current time
                return new CustomTimePickerDialog(this, timePickerListener, hour, minute, false);

        }
        return null;
    }

    private TimePickerDialog.OnTimeSetListener timePickerListener =
            new CustomTimePickerDialog.OnTimeSetListener()
            {
                public void onTimeSet(TimePicker view, int selectedHour, int selectedMinute) {
                    hour = selectedHour;
                    minute = selectedMinute;
                    if(hour > 12)
                    {
                        hour = hour % 12;
                        ampm = " PM";
                    }
                    else if(hour == 12)
                    {
                        ampm = " PM";
                    }
                    else if(hour == 0)
                    {
                        hour = 12;
                        ampm = " AM";
                    }
                    else
                    {
                        ampm = " AM";
                    }
                    // set current time into textview
                    timeTextView.setText(new StringBuilder().append(pad(hour)).append(":").append(pad(minute)).append(ampm));
                }
            };

    private static String pad(int c)
    {
        if (c >= 10)
            return String.valueOf(c);
        else
            return "0" + String.valueOf(c);
    }
}
