package com.example.appfilm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.appfilm.R;
import com.example.appfilm.presenter.Time;

import java.util.List;

public class TimeAdapter extends BaseAdapter {
    int layout;
    Context context;
    List<Time> times;
    int idFilm,idCinema;
    public TimeAdapter(int layout, Context context, List<Time> times,int idFilm,int idCinema) {
        this.layout = layout;
        this.context = context;
        this.times = times;
        this.idFilm = idFilm;
        this.idCinema = idCinema;
    }

    @Override
    public int getCount() {
        return times.size();
    }

    @Override
    public Object getItem(int i) {
        return times.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view =inflater.inflate(layout,null);

        Time time = times.get(i);
        TextView textView = view.findViewById(R.id.itemM);
        textView.setText(time.getTime());
        return view;
    }
}
