package com.example.convinence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private static final int SPLASH_SCREEN_TIME_OUT = 3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        ImageView shapeDrawables = findViewById(R.id.icon);
        shapeDrawables.setBackgroundResource(R.drawable.color_changer);
        AnimationDrawable iconDrawables = (AnimationDrawable) shapeDrawables.getBackground();
        iconDrawables.start();


        Animation shapeAnim = AnimationUtils.loadAnimation(this, R.anim.button_to_top_anim);
        shapeDrawables.startAnimation(shapeAnim);
        getSupportActionBar().hide();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this,
                        itemCategories.class);

                startActivity(i);

                finish();
            }
        }, SPLASH_SCREEN_TIME_OUT);
    }
}
