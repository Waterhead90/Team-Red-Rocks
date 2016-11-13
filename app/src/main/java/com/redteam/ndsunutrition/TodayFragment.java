package com.redteam.ndsunutrition;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;


public class TodayFragment extends Fragment
{
    private TextView mealsTextView;

    // Only going to be used temporarily
    Random rand = new Random();

    private static final String ARG_SECTION_NUMBER = "section_number";
    public TodayFragment()
    {

    }

    public static Fragment newInstance(int sectionNumber)
    {
        TodayFragment todayFragment = new TodayFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        todayFragment.setArguments(args);
        return todayFragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_today, container, false);

        mealsTextView = (TextView) rootView.findViewById(R.id.textViewMeals);
        ListView list = (ListView) rootView.findViewById(R.id.meal_list);
        MealsAdapter listAdapter = new MealsAdapter(getContext(), R.layout.fragment_meal_item);
        list.setAdapter(listAdapter);

        // Randomly "check" for meals
        int meals = rand.nextInt();

        // If there are meals, set the TextView accordingly and display the meals
        // Replace this check with one that actually checks for meals
        if (meals % 2 == 0)
        {
            mealsTextView.setText(R.string.meals_text);
            for(int i = 0; i < 3; i++)
            {
                listAdapter.add("Meal " + (i + 1));
            }
        }
        // Else there are no meals, so set the TextView accordingly
        else
        {
            mealsTextView.setText(R.string.no_meals_text);
        }

        return rootView;
    }
}
