package com.example.appfilm.adapter;

import android.content.Context;
import android.content.Intent;
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
import com.example.appfilm.model.FilmPlaying;
import com.example.appfilm.view.InforFilmActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FilmPlayingAdapter extends RecyclerView.Adapter<FilmPlayingAdapter.HomeViewHolder>{
    List<FilmPlaying> films;
    Context context;

    public FilmPlayingAdapter(List<FilmPlaying> films, Context context) {
        this.films = films;
        this.context = context;
    }

    @NonNull
    @Override
    public FilmPlayingAdapter.HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.line_all_film,parent,false);
        return new FilmPlayingAdapter.HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmPlayingAdapter.HomeViewHolder holder, int position) {
        FilmPlaying film = films.get(position);
        if (film == null){
            return;
        }
        Picasso.get().load(film.getHinhAnh()).into(holder.imgFilm);
        holder.nameFilm.setText(film.getTenPhim());
        Picasso.get().load(film.getHinhAnh()).into(holder.imgFilm);
        holder.txtTheloai.setText(film.getTheLoai()+"");
        holder.txtThoiluong.setText(film.getThoiLuong()+" phút");

        holder.line_data.setOnClickListener(new View.OnClickListener() {
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
        TextView nameFilm,txtTheloai,txtThoiluong;
        Button btnDatve;
        LinearLayout line_data;
        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFilm = itemView.findViewById(R.id.imgFilm);
            nameFilm = itemView.findViewById(R.id.nameFilm);
            imgMac = itemView.findViewById(R.id.mac);
            txtTheloai = itemView.findViewById(R.id.txtTheloai);
            txtThoiluong = itemView.findViewById(R.id.txtThoiluong);
            btnDatve = itemView.findViewById(R.id.btnDat);
            line_data = itemView.findViewById(R.id.line_data);
        }
    }
}
