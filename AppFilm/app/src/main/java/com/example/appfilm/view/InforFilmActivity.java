package com.example.appfilm.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appfilm.R;
import com.example.appfilm.adapter.AdapterInforFilm;
import com.example.appfilm.interfaces.ApiServer;
import com.example.appfilm.model.Film2;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InforFilmActivity extends AppCompatActivity {
    ListView listView;
    List<Film2> sinhvienList;
    int idFilm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_film2);

        Intent intent = getIntent();
        idFilm = intent.getIntExtra("idFilm",-1);
        Log.d("abc",idFilm+"");

        btnDatVe();
        shareButton();
        ImageView iconBack = findViewById(R.id.back);
        iconBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InforFilmActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        listView = findViewById(R.id.list);
        getInforFilm(idFilm);
    }

    private void shareButton() {
        ImageView ShareButton = findViewById(R.id.ShareButton);
        ShareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String body = "Vui lòng share đi!!";
                String shareSub = "Your subject here";
                intent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
                intent.putExtra(Intent.EXTRA_TEXT, body);
                startActivity(Intent.createChooser(intent, "Share"));
            }
        });
    }

    private void btnDatVe()
    {
        TextView textView= findViewById(R.id.tvDatVe);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InforFilmActivity.this,CinemaActivity.class);
                intent.putExtra("idFilm",idFilm);
                startActivity(intent);
            }
        });
    }

    private void getInforFilm(int id) {
        ApiServer.API_SERVER.getDetailForFilm(id).enqueue(new Callback<ArrayList<Film2>>() {
            @Override
            public void onResponse(Call<ArrayList<Film2>> call, Response<ArrayList<Film2>> response) {
                ArrayList<Film2> film2 = response.body();
                Log.d("responInfo", "onResponse: "+response.body());
                AdapterInforFilm adapterInforFilm =
                        new AdapterInforFilm(InforFilmActivity.this,
                                R.layout.dong_layout_demo_project_film, film2);
                listView.setAdapter(adapterInforFilm);
            }

            @Override
            public void onFailure(Call<ArrayList<Film2>> call, Throwable t) {
                Toast.makeText(InforFilmActivity.this, "Lỗi!!", Toast.LENGTH_LONG).show();
                Log.d("aa", t.toString());
            }
        });
    }
}