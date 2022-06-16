package com.example.appfilm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appfilm.R;
import com.example.appfilm.model.Film2;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterPhimTheLoai extends RecyclerView.Adapter<AdapterPhimTheLoai.ViewHolder> {
    Context context;
    List<Film2.phimTheLoai> listDienVien;

    public AdapterPhimTheLoai(Context context, List<Film2.phimTheLoai> listDienVien) {
        this.context = context;
        this.listDienVien = listDienVien;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dong_layout_filmcungtheloai, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Picasso.get().load(listDienVien.get(position).getHinhAnh()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        if (listDienVien != null) {
            return listDienVien.size();
        }
        return 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ima_demo_TL);
        }
    }
}

