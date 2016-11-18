package com.redteam.ndsunutrition;

import android.app.ListFragment;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;


public class HomeFragment extends Fragment implements AdapterView.OnItemSelectedListener
{
    private static final String ARG_SECTION_NUMBER = "section_number";
    TextView tv;

    public HomeFragment()
    {

    }

    public static Fragment newInstance(int sectionNumber)
    {
        HomeFragment homeFragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        homeFragment.setArguments(args);
        return homeFragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        //The current fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        //Create reference to Spinner and setup adapter
        Spinner selectionSpinner = (Spinner) rootView.findViewById(R.id.selectionSpinner);
        ArrayAdapter spinnerAdapter = ArrayAdapter.createFromResource(getContext(),R.array.catagory_selection,android.R.layout.simple_spinner_item); // using time Array as a placeholder
        selectionSpinner.setAdapter(spinnerAdapter);
        selectionSpinner.setOnItemSelectedListener(this);

        //Create list view and adapter
        ListView list = (ListView) rootView.findViewById(R.id.recommendationList);
        RecommendationAdapter listAdapter = new RecommendationAdapter(getContext(),R.layout.fragment_recommendation_item);
        list.setAdapter(listAdapter);

        //Iteration to add elements to the List
        for(int i = 0; i != 5; i++)
        {
            listAdapter.add("");
        }

        //Create middle progress bar
        Resources res = getResources();
        Drawable drawable = res.getDrawable(R.drawable.circular);
        final ProgressBar mProgress = (ProgressBar) rootView.findViewById(R.id.circularProgressbar);
        int progress = 4000;

        //Temp code to show progress bar is working
        mProgress.setMax(4000); // Maximum Progress
        mProgress.setSecondaryProgress(4000); // Secondary Progress
        mProgress.setProgressDrawable(drawable);

        //Text View in center of progress bar
        tv = (TextView) rootView.findViewById(R.id.tv);

        //Temp code to set the current progress
        mProgress.setProgress(progress);
        tv.setText("" + progress);

        return rootView;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
