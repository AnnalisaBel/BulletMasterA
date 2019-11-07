package com.example.bulletmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class LevelsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        overridePendingTransition(R.anim.fadein, R.anim.fadeout);

        setContentView(R.layout.activity_levels);

        System.out.println("----Secondactivity activity---onCreates---");
    }
}
