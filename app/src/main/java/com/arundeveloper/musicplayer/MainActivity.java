package com.arundeveloper.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MediaPlayer player;
    private Button bplay,bpause,bstop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bplay=findViewById(R.id.play);
        bpause=findViewById(R.id.pause);
        bstop=findViewById(R.id.stop);
    }

    public void play(View v) {
        bpause.setTextColor(getApplication().getResources().getColor(R.color.gray)); //TAKE DEFAULT COLOR
        bstop.setTextColor(getApplication().getResources().getColor(R.color.gray)); //TAKE DEFAULT COLOR
        bplay.setTextColor(getApplication().getResources().getColor(R.color.red)); //TAKE DEFAULT COLOR

        if (player == null) {
            player = MediaPlayer.create(this, R.raw.ringtone);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }

        player.start();
    }

    public void pause(View v) {
        bstop.setTextColor(getApplication().getResources().getColor(R.color.gray)); //TAKE DEFAULT COLOR
        bplay.setTextColor(getApplication().getResources().getColor(R.color.gray)); //TAKE DEFAULT COLOR
        bpause.setTextColor(getApplication().getResources().getColor(R.color.red)); //TAKE DEFAULT COLOR
        if (player != null) {
            player.pause();
        }
    }

    public void stop(View v) {
        bplay.setTextColor(getApplication().getResources().getColor(R.color.gray)); //TAKE DEFAULT COLOR
        bpause.setTextColor(getApplication().getResources().getColor(R.color.gray)); //TAKE DEFAULT COLOR
        bstop.setTextColor(getApplication().getResources().getColor(R.color.red)); //TAKE DEFAULT COLOR
        stopPlayer();
    }

    private void stopPlayer() {
        if (player != null) {
            player.release();
            player = null;
            Toast.makeText(this, "MediaPlayer released", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
    }
}