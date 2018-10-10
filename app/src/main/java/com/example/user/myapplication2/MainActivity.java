package com.example.user.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void choice(View v) {
        Button btn = (Button)v;
        if(btn.getText().toString().equals("계산기")) {
            Intent intent = new Intent(MainActivity.this, CalcActivity.class);
            startActivity(intent);
        } else if(btn.getText().toString().equals("플레이어")) {
            Intent intent = new Intent(MainActivity.this, PlayerActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(MainActivity.this, "다시 선택해주세요.", Toast.LENGTH_SHORT).show();
        }
    }


}
