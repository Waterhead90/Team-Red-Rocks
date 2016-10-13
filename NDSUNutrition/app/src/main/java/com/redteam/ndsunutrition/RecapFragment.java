package com.redteam.ndsunutrition;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class RecapFragment extends Fragment
{
    private static final String ARG_SECTION_NUMBER = "section_number";

    public RecapFragment()
    {
    }

    public static Fragment newInstance(int sectionNumber)
    {
        RecapFragment recapFragment = new RecapFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        recapFragment.setArguments(args);
        return recapFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_recap, container, false);
        return rootView;
    }
}
