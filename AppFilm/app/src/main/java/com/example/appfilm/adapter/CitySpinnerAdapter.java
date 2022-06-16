package com.example.appfilm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.appfilm.R;
import com.example.appfilm.model.City;

import java.util.List;

public class CitySpinnerAdapter extends ArrayAdapter<City> {


    public CitySpinnerAdapter(@NonNull Context context, int resource, @NonNull List<City> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_selected,parent,false);
        TextView txtSelected = convertView.findViewById(R.id.txtSelected);

        City city = (City) this.getItem(position);
        if (city != null){
            txtSelected.setText(city.getCity());
        }

        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category,parent,false);
        TextView txtCity = convertView.findViewById(R.id.txtCity);

        City city = (City) this.getItem(position);
        if (city != null){
            txtCity.setText(city.getCity());
        }

        return convertView;
    }
}
