package com.example.appfilm.presenter;

import com.example.appfilm.interfaces.ApiServer;
import com.example.appfilm.interfaces.CinemaInterface;
import com.example.appfilm.model.Cinema;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CinemaPresenter {
    CinemaInterface cinemaInterface;

    public CinemaPresenter(CinemaInterface cinemaInterface) {
        this.cinemaInterface = cinemaInterface;
    }

    public void readAPICinema(final CinemaInterface cinemaInterface,int idFilm){
        ApiServer.API_SERVER.callCinema(idFilm).enqueue(new Callback<List<Cinema>>() {
            @Override
            public void onResponse(Call<List<Cinema>> call, Response<List<Cinema>> response) {
                cinemaInterface.onSuccessCinema(response.body());
            }

            @Override
            public void onFailure(Call<List<Cinema>> call, Throwable t) {

            }
        });
    }
}
