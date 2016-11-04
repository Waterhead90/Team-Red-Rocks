package com.redteam.ndsunutrition;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.NumberPicker;
import android.widget.TimePicker;

/**
 * Created by gage.askegard on 11/2/2016.
 */

public class CustomTimePickerDialog extends TimePickerDialog
{

    private final static int TIME_PICKER_INTERVAL = 30;
    private TimePicker mTimePicker;
    private int lastSetHour;
    private int lastSetMinute;
    private final OnTimeSetListener mTimeSetListener;

    public CustomTimePickerDialog(Context context, OnTimeSetListener listener, int hourOfDay, int minute, boolean is24HourView)
    {
        super(context, TimePickerDialog.THEME_HOLO_LIGHT, null, hourOfDay, minute / TIME_PICKER_INTERVAL, is24HourView);
        mTimeSetListener = listener;
        lastSetHour = hourOfDay;
        lastSetMinute = minute;
    }

    @Override
    public void updateTime(int hourOfDay, int minuteOfHour)
    {
        mTimePicker.setCurrentHour(hourOfDay);
        mTimePicker.setCurrentMinute(minuteOfHour / TIME_PICKER_INTERVAL);
    }

    @Override
    public void onClick(DialogInterface dialog, int which)
    {
        switch (which)
        {
            case BUTTON_POSITIVE:
                if (mTimeSetListener != null)
                {
                    mTimeSetListener.onTimeSet(mTimePicker, mTimePicker.getCurrentHour(),
                            mTimePicker.getCurrentMinute() * TIME_PICKER_INTERVAL);
                }
                break;
            case BUTTON_NEGATIVE:
                cancel();
                break;
        }
    }

    @Override
    public void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        try
        {
            Class<?> classForid = Class.forName("com.android.internal.R$id");
            Field timePickerField = classForid.getField("timePicker");
            mTimePicker = (TimePicker) findViewById(timePickerField.getInt(null));
            Field field = classForid.getField("minute");

            NumberPicker minuteSpinner = (NumberPicker) mTimePicker.findViewById(field.getInt(null));
            minuteSpinner.setMinValue(0);
            minuteSpinner.setMaxValue((60 / TIME_PICKER_INTERVAL) - 1);
            List<String> displayedValues = new ArrayList<>();
            for (int i = 0; i < 60; i += TIME_PICKER_INTERVAL)
            {
                displayedValues.add(String.format("%02d", i));
            }
            minuteSpinner.setDisplayedValues(displayedValues.toArray(new String[displayedValues.size()]));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
        super.onTimeChanged(view, hourOfDay, minute);
        if (lastSetHour != hourOfDay && lastSetMinute != minute) {
            view.setCurrentHour(lastSetHour);
            lastSetMinute = minute;
        } else {
            lastSetHour = hourOfDay;
            lastSetMinute = minute;
        }
    }
 }
