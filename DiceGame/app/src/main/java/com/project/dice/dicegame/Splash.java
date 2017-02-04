package com.project.dice.dicegame;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.widget.ImageView;
public class Splash extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        try {
          final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    Intent intent = new Intent(Splash.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                  }
                }, 5000);

            } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            }
        }
}