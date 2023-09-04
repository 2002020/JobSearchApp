package my.edu.utar.jobsearchapp;

import android.content.Intent;
import android.os.Handler;
import android.support.constraint.motion.MotionLayout;
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

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, SplashScreen.class);
                startActivity(intent);
                finish();
            }
        }, 2000);

    }
}