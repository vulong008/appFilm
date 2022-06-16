package com.example.appfilm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appfilm.R;
import com.example.appfilm.model.Film;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.HomeViewHolder>{
    List<Film> films;
    Context context;

    public FilmAdapter(List<Film> films, Context context) {
        this.films = films;
        this.context = context;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.line_all_film,parent,false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        Film film = films.get(position);
        if (film == null){
            return;
        }
        Picasso.get().load(film.getHinhAnh()).into(holder.imgFilm);
        holder.nameFilm.setText(film.getTenPhim());
        Picasso.get().load(film.getHinhAnh()).into(holder.imgFilm);
        holder.txtTheloai.setText(film.getTheloai()+"");
        holder.txtThoiluong.setText(film.getThoiLuong()+" phút");
    }

    @Override
    public int getItemCount() {
        return films.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder {
        ImageView imgFilm,imgMac;
        TextView nameFilm,txtTheloai,txtThoiluong;
        Button btnDatve;
        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFilm = itemView.findViewById(R.id.imgFilm);
            nameFilm = itemView.findViewById(R.id.nameFilm);
            imgMac = itemView.findViewById(R.id.mac);
            txtTheloai = itemView.findViewById(R.id.txtTheloai);
            txtThoiluong = itemView.findViewById(R.id.txtThoiluong);
            btnDatve = itemView.findViewById(R.id.btnDat);
        }
    }
}
