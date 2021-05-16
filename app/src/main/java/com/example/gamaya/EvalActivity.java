package com.example.gamaya;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.gamaya.adapters.EvalAdapter;
import com.example.gamaya.databinding.ActivityEvalBinding;
import com.example.gamaya.utils.EvalVideoStore;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerCallback;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerFullScreenListener;

import org.jetbrains.annotations.NotNull;

public class EvalActivity extends AppCompatActivity {

    private ActivityEvalBinding binding;
    private EvalAdapter evalAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEvalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        evalAdapter = new EvalAdapter();
        getLifecycle().addObserver(binding.ypvExplanationVideo);

        evalAdapter.setOnItemClickListener((view, evalVideo, position) -> {
            binding.ypvExplanationVideo.getYouTubePlayerWhenReady(youTubePlayer ->
                    youTubePlayer.loadVideo(evalVideo.getVideoId(), 0)
            );
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        evalAdapter.submitList(EvalVideoStore.getEvalVideos());

        binding.ypvExplanationVideo.addFullScreenListener(new YouTubePlayerFullScreenListener() {
            @Override
            public void onYouTubePlayerEnterFullScreen() {
                toggleFullscreen(false);
            }

            @Override
            public void onYouTubePlayerExitFullScreen() {
                toggleFullscreen(true);
            }
        });

        binding.rvVideoExplanation.setAdapter(evalAdapter);
        binding.rvVideoExplanation.setLayoutManager(new LinearLayoutManager(this));

        binding.ypvExplanationVideo.getYouTubePlayerWhenReady(youTubePlayer -> {
            if (EvalVideoStore.getEvalVideos().isEmpty()) return;
            youTubePlayer.cueVideo(EvalVideoStore.getEvalVideos().get(0).getVideoId(), 0);
        });
    }

    void toggleFullscreen(boolean isFullscreen) {
        if (isFullscreen) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);

            if (getSupportActionBar() != null) {
                getSupportActionBar().show();
            }

            binding.rvVideoExplanation.setVisibility(View.VISIBLE);
            binding.tvTitleExplanation.setVisibility(View.VISIBLE);
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        } else {
            getWindow().getDecorView()
                    .setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

            if (getSupportActionBar() != null) {
                getSupportActionBar().hide();
            }

            binding.rvVideoExplanation.setVisibility(View.GONE);
            binding.tvTitleExplanation.setVisibility(View.GONE);
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
    }
}