package com.example.appfilm.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.appfilm.R;
import com.example.appfilm.model.Cinema;
import com.example.appfilm.model.City;
import com.example.appfilm.view.TimeActivity;

import java.util.ArrayList;
import java.util.List;

public class CinemaAdapter extends BaseAdapter {

    Context context;
    int layout;
    List<Cinema> list =new ArrayList<>();
    int idFilm;
    public CinemaAdapter(Context context, int layout, List<Cinema> list,int idFilm) {
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

        Cinema cinema = list.get(i);
        TextView edtCinema = view.findViewById(R.id.itemM);
        edtCinema.setText(cinema.getTenRap());

        LinearLayout layout = view.findViewById(R.id.line_item);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, TimeActivity.class);
                intent.putExtra("idFilm",idFilm);
                intent.putExtra("idCinema",cinema.getIdRap());
                context.startActivity(intent);
            }
        });
        return view;
    }
}
