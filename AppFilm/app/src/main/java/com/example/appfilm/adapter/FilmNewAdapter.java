package com.example.appfilm.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appfilm.R;
import com.example.appfilm.model.Film;
import com.example.appfilm.model.FilmNew;
import com.example.appfilm.view.InforFilmActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FilmNewAdapter extends RecyclerView.Adapter<FilmNewAdapter.HomeViewHolder> {
    List<FilmNew> films;
    Context context;

    public FilmNewAdapter(List<FilmNew> films, Context context) {
        this.films = films;
        this.context = context;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.line_data_film,parent,false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        FilmNew film = films.get(position);
        if (film == null){
            return;
        }
        Picasso.get().load(film.getHinhAnh()).into(holder.imgFilm);
        holder.txtTenphim.setText(film.getTenPhim());
        holder.txtThoiluongphim.setText(film.getThoiLuong()+ " phút");
        Picasso.get().load(film.getIconMac()).into(holder.imgMac);

        holder.line_NewFilm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, InforFilmActivity.class);
                intent.putExtra("idFilm",film.getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return films.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder {
        ImageView imgFilm,imgMac;
        TextView txtTenphim,txtThoiluongphim;
        Button btnDatve;

        LinearLayout line_NewFilm;
        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFilm = itemView.findViewById(R.id.imgFilm);
            txtTenphim = itemView.findViewById(R.id.txtTenphim);
            txtThoiluongphim = itemView.findViewById(R.id.txtThoiluongphim);
            imgMac = itemView.findViewById(R.id.iconMac);
            line_NewFilm = itemView.findViewById(R.id.line_NewFilm);
        }
    }
}
