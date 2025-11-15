package com.example.videoplayer2;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.SurfaceView;
import android.widget.Button;
import android.widget.SeekBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    SurfaceView surfaceView1, surfaceView2;
    SeekBar seekBar1, seekBar2;
    Button btn1, btn2;

    MediaPlayer md;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        surfaceView1 = findViewById(R.id.video1_surfaceView);
        surfaceView2 = findViewById(R.id.video2_surfaceView);
        seekBar1 = findViewById(R.id.video1_seekBar);
        seekBar2 = findViewById(R.id.video2_seekBar);
        btn1 = findViewById(R.id.play_pause_video1);
        btn2 = findViewById(R.id.play_pause_video2);

        md = MediaPlayer.create();

    }
}