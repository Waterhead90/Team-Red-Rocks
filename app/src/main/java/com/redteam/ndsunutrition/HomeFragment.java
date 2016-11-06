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
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;


public class HomeFragment extends Fragment
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
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        ListView list = (ListView) rootView.findViewById(R.id.recommendationList);
        RecommendationAdapter listAdapter = new RecommendationAdapter(getContext(),R.layout.fragment_recommendation_item);
        list.setAdapter(listAdapter);

        for(int i = 0; i != 5; i++)
        {
            listAdapter.add("Generic Placeholder");
        }


        Resources res = getResources();
        Drawable drawable = res.getDrawable(R.drawable.circular);
        final ProgressBar mProgress = (ProgressBar) rootView.findViewById(R.id.circularProgressbar);
        int progress = 4000;


        mProgress.setMax(4000); // Maximum Progress
        mProgress.setSecondaryProgress(4000); // Secondary Progress
        mProgress.setProgressDrawable(drawable);

        tv = (TextView) rootView.findViewById(R.id.tv);

        mProgress.setProgress(progress);

        tv.setText("" + progress);
        return rootView;
    }
}
