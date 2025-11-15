package com.example.videoplayer2;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    SurfaceView surfaceView1, surfaceView2;
    SeekBar seekBar1, seekBar2;
    Button btn1, btn2;

    MediaPlayer md1, md2;

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

        View.OnClickListener commonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();
                if(id == R.id.play_pause_video1){
                    if(md1.isPlaying()){
                        md1.pause();
                        btn1.setText("Play");
                        md2.start();
                    }
                    else{
                        md1.start();
                        btn1.setText("Pause");
                        md2.pause();

                    }
                }else if(id == R.id.play_pause_video2){
                    if(md2.isPlaying()){
                        md2.pause();
                        btn2.setText("Play");
                        md1.start();
                    }
                    else{
                        md2.start();
                        btn2.setText("Pause");
                        md1.pause();
                    }
                }
            }
        };


        md1 = MediaPlayer.create(this, R.raw.jhandai);
        SurfaceHolder holder1 = surfaceView1.getHolder();


        holder1.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {
            }

            @Override
            public void surfaceCreated(@NonNull SurfaceHolder holder) {
                md1.setDisplay(holder1);
                md1.start();
            }

            @Override
            public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

            }
        });
        btn1.setOnClickListener(commonClickListener);


        md2 = MediaPlayer.create(this,R.raw.jhandai);
        SurfaceHolder holder2 = surfaceView2.getHolder();
        holder2.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceCreated(@NonNull SurfaceHolder holder) {
                md2.setDisplay(holder2);
                md2.start();
            }

            @Override
            public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

            }
        });
        btn2.setOnClickListener(commonClickListener);


    }
}