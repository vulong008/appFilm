package com.example.appfilm.presenter;

import com.example.appfilm.interfaces.ApiServer;
import com.example.appfilm.interfaces.CityInterface;
import com.example.appfilm.model.City;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CityPresenter {
    CityInterface cityInterface;
    List<City> cities;

    public CityPresenter(CityInterface cityInterface) {
        this.cityInterface = cityInterface;
    }

    public void readAPICity(final CityInterface cityInterface){
        ApiServer.API_SERVER.callCity().enqueue(new Callback<List<City>>() {
            @Override
            public void onResponse(Call<List<City>> call, Response<List<City>> response) {
                cityInterface.onSuccessCity(response.body());
            }

            @Override
            public void onFailure(Call<List<City>> call, Throwable t) {

            }
        });
    }
}
