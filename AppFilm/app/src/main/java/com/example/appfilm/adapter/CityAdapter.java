package com.example.appfilm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.appfilm.R;
import com.example.appfilm.model.City;

import java.util.ArrayList;
import java.util.List;

public class CityAdapter extends BaseAdapter {

    Context context;
    int layout;
    List<City> list =new ArrayList<>();

    public CityAdapter(Context context, int layout, List<City> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view =inflater.inflate(layout,null);

        City city = list.get(i);
        TextView edtCity = view.findViewById(R.id.itemM);
        edtCity.setText(city.getCity());
        return view;
    }
}
