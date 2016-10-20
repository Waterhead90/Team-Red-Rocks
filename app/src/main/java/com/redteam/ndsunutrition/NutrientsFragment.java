package com.redteam.ndsunutrition;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class NutrientsFragment extends Fragment
{
    private static final String ARG_SECTION_NUMBER = "section_number";
    public NutrientsFragment()
    {

    }

    public static Fragment newInstance(int sectionNumber)
    {
        NutrientsFragment nutrientsFragment = new NutrientsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        nutrientsFragment.setArguments(args);
        return nutrientsFragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_nutrients, container, false);
        return rootView;
    }
}
