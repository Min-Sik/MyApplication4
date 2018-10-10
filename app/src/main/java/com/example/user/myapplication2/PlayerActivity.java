package com.example.user.myapplication2;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class PlayerActivity extends AppCompatActivity {

    private MediaPlayer mp = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
    }

    public void touch(View v) {
        Button btn = null;
        switch (v.getId()){
            case R.id.song1 :
                doStop();
                mp = MediaPlayer.create(this, R.raw.adele_hello);
                mp.start();
                btn = findViewById(R.id.pause);
                btn.setText(R.string.pause);
                break;
            case R.id.song2 :
                doStop();
                mp = MediaPlayer.create(this, R.raw.beyonce_halo);
                mp.start();
                btn = findViewById(R.id.pause);
                btn.setText(R.string.pause);
                break;
            case R.id.pause :

                btn = findViewById(R.id.pause);
                if(btn.getText().equals(R.string.pause)) {
                    mp.pause();
                    btn.setText(R.string.play);
                } else {
                    mp.start();
                    btn.setText(R.string.pause);
                }
                break;
            case R.id.stop:
                mp.stop();
                btn = findViewById(R.id.pause);
                btn.setText(R.string.pause);
                break;

        }
    }

    private void doStop() {
        if(mp!=null) {
            mp.stop();
            mp.release();
            mp = null;
        }
    }

}
