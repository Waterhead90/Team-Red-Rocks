package com.redteam.ndsunutrition;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class TodayFragment extends Fragment
{
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_today, container, false);
        return rootView;
    }
}
