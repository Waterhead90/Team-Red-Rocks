package com.redteam.ndsunutrition;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gage.askegard on 11/12/2016.
 */
public class MealsAdapter extends ArrayAdapter
{
    private List list = new ArrayList();

    public MealsAdapter(Context context, int resource)
    {
        super(context,resource);
    }

    public void add(Object obj)
    {
        list.add(obj);
    }

    public int getCount()
    {
        return this.list.size();
    }

    public Object getItem(int position)
    {
        return this.list.get(position);
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        View row = convertView;

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            row = inflater.inflate(R.layout.fragment_meal_item, parent, false);

            row.setTag(row.findViewById(R.id.meal_list_item));
        }

        return row;
    }
}
