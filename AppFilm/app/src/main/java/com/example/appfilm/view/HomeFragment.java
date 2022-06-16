package com.example.appfilm.view;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.example.appfilm.R;
import com.example.appfilm.adapter.FilmAdapter;
import com.example.appfilm.adapter.FilmNewAdapter;
import com.example.appfilm.adapter.FilmPlayingAdapter;
import com.example.appfilm.adapter.PhotoAdapter;
import com.example.appfilm.interfaces.HomeInterface;
import com.example.appfilm.interfaces.VolleyInterface;
import com.example.appfilm.model.Advertise;
import com.example.appfilm.model.Film;
import com.example.appfilm.model.FilmNew;
import com.example.appfilm.model.FilmPlaying;
import com.example.appfilm.model.photo;
import com.example.appfilm.presenter.HomePresenter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator3;

public class HomeFragment extends Fragment implements HomeInterface, VolleyInterface {
    HomePresenter homePresenter =new HomePresenter(this);
    RecyclerView rvNewFilm;
    RecyclerView rvFilmPlaying;
    FilmNewAdapter filmNewAdapter;
    FilmPlayingAdapter filmPlayingAdapter;

    private ViewPager2 viewPager2;
    private CircleIndicator3 circleIndicator3;
    private List<Advertise> advertises;
    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            int currentPosition = viewPager2.getCurrentItem();
            if (currentPosition == advertises.size()-1){
                viewPager2.setCurrentItem(0);
            }else {
                viewPager2.setCurrentItem(currentPosition+1);
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        rvNewFilm = view.findViewById(R.id.rcv_Film1);
        rvFilmPlaying = view.findViewById(R.id.rcv_Film2);
        viewPager2 = view.findViewById(R.id.viewPager2);
        circleIndicator3 = view.findViewById(R.id.indicator);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        rvNewFilm.setLayoutManager(linearLayoutManager);
        rvNewFilm.setNestedScrollingEnabled(false);

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        rvFilmPlaying.setLayoutManager(linearLayoutManager1);
        rvFilmPlaying.setNestedScrollingEnabled(false);

        homePresenter.readAdsJson(this);
        homePresenter.readFilmNewJson(this);
        homePresenter.readFilmPlaying(this);
        return view;
    }

    @Override
    public void onSuccess(List<Advertise> advertises1) {
        advertises = advertises1;
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(0));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1-Math.abs(position);
                page.setScaleY(0.85f+r*0.15f);
            }
        });
        viewPager2.setPageTransformer(compositePageTransformer);

        PhotoAdapter photoAdapter = new PhotoAdapter(advertises);
        viewPager2.setAdapter(photoAdapter);
        circleIndicator3.setViewPager(viewPager2);


        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                handler.removeCallbacks(runnable);
                handler.postDelayed(runnable,3000);
            }
        });
    }

    @Override
    public void onSuccessFilmPlaying(List<FilmPlaying> films) {
        filmPlayingAdapter = new FilmPlayingAdapter(films,getContext());
        rvFilmPlaying.setAdapter(filmPlayingAdapter);
    }

    @Override
    public void onSuccessNewFilm(List<FilmNew> films) {
        filmNewAdapter =new FilmNewAdapter(films,getContext());
        rvNewFilm.setAdapter(filmNewAdapter);
    }

    @Override
    public void myToast(String message) {
        Toast.makeText(getActivity(),message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context TruyenContext() {
        return getActivity();
    }

    @Override
    public void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }

    @Override
    public void onResume() {
        super.onResume();
        handler.postDelayed(runnable,3000);
    }
}
