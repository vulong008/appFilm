package com.example.appfilm.presenter;

import com.example.appfilm.interfaces.ApiServer;
import com.example.appfilm.interfaces.TimeInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TimePresenter {
    TimeInterface timeInterface;
    List<Time> times;
    int idFilm,idCinema;
    String txtDate;

    public TimePresenter(TimeInterface timeInterface, List<Time> times, int idFilm, int idCinema, String txtDate) {
        this.timeInterface = timeInterface;
        this.times = times;
        this.idFilm = idFilm;
        this.idCinema = idCinema;
        this.txtDate = txtDate;
    }

    public void readTime( final TimeInterface timeInterface,int idFilm, int idCinema, String txtDate){
        ApiServer.API_SERVER.callTime(idFilm,idCinema,txtDate).enqueue(new Callback<List<Time>>() {
            @Override
            public void onResponse(Call<List<Time>> call, Response<List<Time>> response) {

                timeInterface.OnSuccessTime(response.body());
            }

            @Override
            public void onFailure(Call<List<Time>> call, Throwable t) {

            }
        });
    }
}
