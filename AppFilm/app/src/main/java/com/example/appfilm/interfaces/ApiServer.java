package com.example.appfilm.interfaces;

import com.example.appfilm.model.Advertise;
import com.example.appfilm.model.Cinema;
import com.example.appfilm.model.City;
import com.example.appfilm.model.Film;
import com.example.appfilm.model.Film2;
import com.example.appfilm.model.FilmNew;
import com.example.appfilm.model.FilmPlaying;
import com.example.appfilm.model.PreTicket;
import com.example.appfilm.model.Ticket;
import com.example.appfilm.model.User;
import com.example.appfilm.model.feedBackFilm;
import com.example.appfilm.presenter.Time;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiServer {
    //http://nguyentrongquang.freevar.com/getAllData/getFilmNew.php
    //https://www.youtube.com/watch?v=hEg6qgLBS1g&list=RDMMhEg6qgLBS1g&start_radio=1
    Gson gson = new GsonBuilder().setDateFormat("MM/dd/yyyy HH:mm:ss").create();
    ApiServer API_SERVER = new Retrofit.Builder().baseUrl("http://nguyentrongquang.freevar.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiServer.class);
    @GET("getAllData/getAllAds.php")
    Call<List<Advertise>> readGetDataAds();

    @GET("getAllData/getFilmPlaying.php")
    Call<List<FilmPlaying>> readGetFilmPlaying();

    @GET("getAllData/getFilmNew.php")
    Call<List<FilmNew>> readGetFilmNew();


    //Long
    @FormUrlEncoded
    @POST("getAllData/getAllInforFilm.php")
    Call<ArrayList<Film2>> getDetailForFilm(@Field("idPhim") int idPhim);

    @GET("getAllData/getAllFeedBack.php")
    Call<List<feedBackFilm>> getAllFeedBack();

    @FormUrlEncoded
    @POST("insertData/insertFeedBack.php")
    Call<feedBackFilm> insertFeedBack(@Field("tenDangNhap") String tenDangNhap,
                                      @Field("ratingFeedBack") float ratingFeedBack
            , @Field("commentFeedBack") String commentFeedBack);

    @GET("account/getUser.php")
    Call<List<User>> readGetUser();

    @GET("getAllData/getCityRap.php")
    Call<List<City>> callCity();

    @FormUrlEncoded
    @POST("getAllData/getCinema.php")
    Call<List<Cinema>> callCinema(@Field("idFilm") int idFilm);

    @FormUrlEncoded
    @POST("getAllData/getTime.php")
    Call<List<Time>> callTime(@Field("idFilm") int idFilm,@Field("idCinema") int idCinema,@Field("txtDate") String txtDate);

    @FormUrlEncoded
    @POST("getAllData/getTicketData.php")
    Call<List<Ticket>> callTicket(@Field("idPhim") int idPhim, @Field("idRap") int idRap, @Field("idKhunggio") int idKhunggio);
    @FormUrlEncoded
    @POST("getAllData/getPreTicket.php")
    Call<PreTicket> callPreTicket(@Field("idPhim") int idPhim, @Field("idRap") int idRap, @Field("idKhunggio") int idKhunggio);

}
