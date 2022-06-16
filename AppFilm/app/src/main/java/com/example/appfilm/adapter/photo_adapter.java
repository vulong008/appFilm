package com.example.appfilm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.appfilm.R;
import com.example.appfilm.model.photo;
import com.squareup.picasso.Picasso;

import java.util.List;

public class photo_adapter extends PagerAdapter {

    Context mContext;
    List<photo> photoList;

    public photo_adapter(Context mContext, List<photo> photoList) {
        this.mContext = mContext;
        this.photoList = photoList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.item_photo, container, false);

        ImageView imageView = view.findViewById(R.id.ima_1);
        photo photo1 = photoList.get(position);
        if (photo1 != null) {
            Picasso.get().load(photo1.getResoureID()).into(imageView);
        }

        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        if (photoList != null) {
            return photoList.size();
        }
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
      container.removeView((View) object);
    }
}

