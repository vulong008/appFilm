package com.example.appfilm.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appfilm.R;
import com.example.appfilm.model.Advertise;
import com.example.appfilm.model.photo;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder> {
    private final List<Advertise> advertises;

    public PhotoAdapter(List<Advertise> advertises) {
        this.advertises = advertises;
    }

    @NonNull
    @Override
    public PhotoAdapter.PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photo,parent,false);
        return new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoAdapter.PhotoViewHolder holder, int position) {
        Advertise advertise = advertises.get(position);
        if (advertise == null){
            return;
        }
        Picasso.get().load(advertise.getImageAds()).into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        if (advertises !=null){
            return advertises.size();
        }
        return 0;
    }

    public static class PhotoViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imgPhoto;
        public PhotoViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.ima_1);
        }
    }
}
