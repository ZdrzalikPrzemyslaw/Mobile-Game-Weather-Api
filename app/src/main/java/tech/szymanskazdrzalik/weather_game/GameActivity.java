package tech.szymanskazdrzalik.weather_game;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import tech.szymanskazdrzalik.weather_game.databinding.ActivityGameBinding;
import tech.szymanskazdrzalik.weather_game.gameView.GameView;

public class GameActivity extends AppCompatActivity {

    ActivityGameBinding binding;

    public interface GameOverListener{
        void onGameOver();
    }

    public interface ScoreListener {
        void onScoreChange();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        binding = ActivityGameBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.textViewScore.setText("Score = 0");

    }

    @Override
    protected void onPause() {
        super.onPause();
        binding.gameView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        binding.gameView.resume();
        binding.gameView.setGameOverListener(() -> {
            Intent intent = new Intent(GameActivity.this, MainActivity.class);
            startActivity(intent);
        });
        binding.gameView.setScoreListener(() -> runOnUiThread(() -> binding.textViewScore.setText("Score = " + binding.gameView.getScore())));
    }
}
