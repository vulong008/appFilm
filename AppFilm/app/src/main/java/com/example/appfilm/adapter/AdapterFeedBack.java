package com.example.appfilm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.appfilm.R;
import com.example.appfilm.model.feedBackFilm;

import java.util.List;

public class AdapterFeedBack extends BaseAdapter {

    private Context context;
    private int layout;
    private List<feedBackFilm> feedBackFilmList1;

    public AdapterFeedBack(Context context, int layout, List<feedBackFilm> feedBackFilmList) {
        this.context = context;
        this.layout = layout;
        this.feedBackFilmList1 = feedBackFilmList;
    }

    @Override
    public int getCount() {
        return feedBackFilmList1.size();

    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder holder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.dong_layout_feedback, viewGroup, false);
            holder = new ViewHolder();
           holder.tenDN = view.findViewById(R.id.tenDN1);
            holder.ratingFeedBack = view.findViewById(R.id.ratingBarLV);
            holder.commentFeedBack = view.findViewById(R.id.editTexCVLV);
            view.setTag(holder);
        }
        else {
           holder= (ViewHolder) view.getTag();
        }

        holder.tenDN.setText(feedBackFilmList1.get(i).getTenDN());
        holder.ratingFeedBack.setRating(feedBackFilmList1.get(i).getRatingFeedBack());
        holder.commentFeedBack.setText(feedBackFilmList1.get(i).getCommentFeedBack());
        return view;
    }

    public class ViewHolder {
        TextView tenDN;
        RatingBar ratingFeedBack;
        TextView commentFeedBack;
    }
}
