package com.redteam.ndsunutrition;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Gmoe on 11/2/2016.
 */

public class SettingsFragment extends Fragment
{
    private static final String ARG_SECTION_NUMBER = "section_number";

    public SettingsFragment()
    {

    }

    public static Fragment newInstance(int sectionNumber)
    {
        SettingsFragment settingsFragment = new SettingsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        settingsFragment.setArguments(args);
        return settingsFragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_settings, container, false);
        return rootView;
    }
}
