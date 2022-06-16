package com.example.appfilm.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.appfilm.R;
import com.example.appfilm.adapter.AdapterInforFilm;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class PlayVideoActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    String id = "";
    YouTubePlayerView youTubePlayerView;
    int REQUEST_VIDEO = 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);
        youTubePlayerView = findViewById(R.id.PlayerVideo);

        Intent intent = getIntent();
        id = intent.getStringExtra("idVideoYT");
        youTubePlayerView.initialize(AdapterInforFilm.API_KEY, this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.loadVideo(id);
      youTubePlayer.setFullscreen(true);
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if (youTubeInitializationResult.isUserRecoverableError()) {
            youTubeInitializationResult.getErrorDialog(PlayVideoActivity.this, REQUEST_VIDEO);
        } else {
            Toast.makeText(this, "Error!!", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_VIDEO) {
            youTubePlayerView.initialize(AdapterInforFilm.API_KEY, PlayVideoActivity.this);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}