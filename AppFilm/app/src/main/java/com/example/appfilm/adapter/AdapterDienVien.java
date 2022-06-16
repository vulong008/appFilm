package com.example.appfilm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appfilm.R;
import com.example.appfilm.model.Film2;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterDienVien extends RecyclerView.Adapter<AdapterDienVien.ViewHolder> {
    Context context;
    List<Film2.dienvien> listDienVien;

    public AdapterDienVien(Context context, List<Film2.dienvien> listDienVien) {
        this.context = context;
        this.listDienVien = listDienVien;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dong_layout_dv, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Picasso.get().load(listDienVien.get(position).getImageDienVien()).into(holder.imageView);

        holder.textView.setText(listDienVien.get(position).getTenDienVien());

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
        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ima_demo);
            textView=itemView.findViewById(R.id.tvActor);
        }
    }
}
