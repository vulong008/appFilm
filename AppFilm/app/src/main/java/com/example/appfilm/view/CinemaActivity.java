package com.example.appfilm.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appfilm.R;
import com.example.appfilm.adapter.CinemaAdapter;
import com.example.appfilm.adapter.CitySpinnerAdapter;
import com.example.appfilm.interfaces.CinemaInterface;
import com.example.appfilm.interfaces.CityInterface;
import com.example.appfilm.model.Cinema;
import com.example.appfilm.model.City;
import com.example.appfilm.presenter.CinemaPresenter;
import com.example.appfilm.presenter.CityPresenter;

import java.util.List;

public class CinemaActivity extends AppCompatActivity implements CityInterface, CinemaInterface {
    Spinner spinnerCategory;
    CitySpinnerAdapter citySpinnerAdapter;
    CityPresenter cityPresenter = new CityPresenter(this);
    CinemaPresenter cinemaPresenter = new CinemaPresenter(this);
    CinemaAdapter cinemaAdapter;
    ListView lvCinema;
    int idFilm;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_cinema);
        spinnerCategory = findViewById(R.id.spn_category);
        lvCinema = findViewById(R.id.lvCinema);

        Intent intent = getIntent();
        idFilm = intent.getIntExtra("idFilm",-1);
        cityPresenter.readAPICity(this);

        cinemaPresenter.readAPICinema(this,idFilm);
    }

    @Override
    public void myToast(String message) {

    }

    @Override
    public void onSuccessCity(List<City> cities) {
        citySpinnerAdapter = new CitySpinnerAdapter(CinemaActivity.this, R.layout.item_selected,cities);
        spinnerCategory.setAdapter(citySpinnerAdapter);
    }

    @Override
    public void onSuccessCinema(List<Cinema> cinemas) {
        cinemaAdapter = new CinemaAdapter(CinemaActivity.this,R.layout.item_list,cinemas,idFilm);
        lvCinema.setAdapter(cinemaAdapter);
    }
}
