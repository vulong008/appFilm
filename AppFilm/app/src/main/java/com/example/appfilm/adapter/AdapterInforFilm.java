package com.example.appfilm.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appfilm.R;
import com.example.appfilm.model.Film2;
import com.example.appfilm.view.AddFeedbackActivity;
import com.example.appfilm.view.PlayVideoActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterInforFilm extends BaseAdapter {

    public static final String API_KEY = "AIzaSyBKX16-eCrUIxH73RB4tguF3Go20_DQylU";
    private Context context;
    private int layout;
    private ArrayList<Film2> film2List;
    Button btnPhanHoi;

    public AdapterInforFilm(Context context, int layout, ArrayList<Film2> sinhvienList) {
        this.context = context;
        this.layout = layout;
        this.film2List = sinhvienList;
    }

    @Override
    public int getCount() {
        return film2List.size();
    }

    @Override
    public Object getItem(int i) {
        return film2List.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View layoutInflater = LayoutInflater.from(context).inflate(R.layout.dong_layout_demo_project_film, viewGroup, false);
        ImageView video = layoutInflater.findViewById(R.id.imagVideo);
        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PlayVideoActivity.class);
                intent.putExtra("idVideoYT", film2List.get(i).getVideo());
                context.startActivity(intent);
            }
        });
        RatingBar ratingBarStart = layoutInflater.findViewById(R.id.ratingBarStartFB);
        TextView tenPhim = layoutInflater.findViewById(R.id.title);
        TextView thoiLuong = layoutInflater.findViewById(R.id.tLuong);
        TextView daoDien = layoutInflater.findViewById(R.id.daoDien);
        TextView moTa = layoutInflater.findViewById(R.id.descresption);
        ImageView imagVideo = layoutInflater.findViewById(R.id.imagVideo);
        TextView tenTheloai = layoutInflater.findViewById(R.id.theLoai);
        ImageView iconMac = layoutInflater.findViewById(R.id.Mac);
        TextView ngayPhathanh = layoutInflater.findViewById(R.id.NgayPhatHanh);
        RecyclerView recyclerViewActor = layoutInflater.findViewById(R.id.rvActor);
        RecyclerView recyclerViewPhimTL = layoutInflater.findViewById(R.id.rvPhimTL);
        //
        btnPhanHoi = layoutInflater.findViewById(R.id.btnPhanHoi);
        btnPhanHoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, AddFeedbackActivity.class);
//                intent.putExtra("idPhim", i+1);
                context.startActivity(intent);
             //   view.getContext().startActivity(new Intent(view.getContext(), AddFeedbackActivity.class));

            }
        });
        //
        moTa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moTa.setLines(moTa.getLineCount());
            }
        });
        moTa.setMovementMethod(new ScrollingMovementMethod());

        Film2 sinhvien = film2List.get(i);
        tenPhim.setText(sinhvien.getTenPhim());
        thoiLuong.setText(sinhvien.getThoiLuong() + "");
        daoDien.setText(sinhvien.getDaoDien());
        moTa.setText(sinhvien.getMoTa());
        ngayPhathanh.setText(sinhvien.getNgayPhatHanh());
        Picasso.get().load(sinhvien.getHinhAnh()).into(imagVideo);

        ratingBarStart.setRating(sinhvien.getSum());
        tenTheloai.setText(sinhvien.getTheloai());
        Picasso.get().load(sinhvien.getMac()).into(iconMac);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerViewActor.setLayoutManager(linearLayoutManager);
        recyclerViewActor.setAdapter(new AdapterDienVien(context, film2List.get(i).getDienvien()));

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(context);
        linearLayoutManager1.setOrientation(RecyclerView.HORIZONTAL);
        recyclerViewPhimTL.setLayoutManager(linearLayoutManager1);
        recyclerViewPhimTL.setAdapter(new AdapterPhimTheLoai(context, film2List.get(i).getPhimTL()));

        return layoutInflater;
    }

}
