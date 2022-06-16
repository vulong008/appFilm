package com.example.appfilm.interfaces;

import com.example.appfilm.model.Advertise;
import com.example.appfilm.model.Cinema;
import com.example.appfilm.model.Film;
import com.example.appfilm.model.FilmNew;
import com.example.appfilm.model.FilmPlaying;

import java.util.List;

public interface VolleyInterface {
    void onSuccess(List<Advertise> advertises);
    void onSuccessFilmPlaying(List<FilmPlaying> films);
    void onSuccessNewFilm(List<FilmNew> films);
}
