package com.example.appfilm.presenter;

import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.appfilm.interfaces.ApiServer;
import com.example.appfilm.interfaces.HomeInterface;
import com.example.appfilm.interfaces.VolleyInterface;
import com.example.appfilm.model.Advertise;
import com.example.appfilm.model.Film;
import com.example.appfilm.model.FilmNew;
import com.example.appfilm.model.FilmPlaying;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePresenter {
    HomeInterface homeInterface;
    List<Advertise> advertises = new ArrayList<>();
    List<FilmNew> filmNew = new ArrayList<>();
    List<FilmPlaying> filmPlaying = new ArrayList<>();

    public HomePresenter(HomeInterface homeInterface) {
        this.homeInterface = homeInterface;
    }

    public void readAdsJson(final VolleyInterface volleyInterface){
        ApiServer.API_SERVER.readGetDataAds().enqueue(new Callback<List<Advertise>>() {
            @Override
            public void onResponse(Call<List<Advertise>> call, retrofit2.Response<List<Advertise>> response) {
                advertises = response.body();
                volleyInterface.onSuccess(advertises);
            }

            @Override
            public void onFailure(Call<List<Advertise>> call, Throwable t) {
                homeInterface.myToast(t.toString());
            }
        });

    }

    public void readFilmNewJson(final VolleyInterface volleyInterface){
        ApiServer.API_SERVER.readGetFilmNew().enqueue(new Callback<List<FilmNew>>() {
            @Override
            public void onResponse(Call<List<FilmNew>> call, Response<List<FilmNew>> response) {
                filmNew = response.body();
                volleyInterface.onSuccessNewFilm(filmNew);
            }

            @Override
            public void onFailure(Call<List<FilmNew>> call, Throwable t) {
                homeInterface.myToast(t.toString());
            }
        });
    }

    public void readFilmPlaying(final VolleyInterface volleyInterface){
        ApiServer.API_SERVER.readGetFilmPlaying().enqueue(new Callback<List<FilmPlaying>>() {
            @Override
            public void onResponse(Call<List<FilmPlaying>> call, retrofit2.Response<List<FilmPlaying>> response) {
                filmPlaying = response.body();
                volleyInterface.onSuccessFilmPlaying(filmPlaying);
            }

            @Override
            public void onFailure(Call<List<FilmPlaying>> call, Throwable t) {
                homeInterface.myToast(t.toString());
            }
        });
    }

}
