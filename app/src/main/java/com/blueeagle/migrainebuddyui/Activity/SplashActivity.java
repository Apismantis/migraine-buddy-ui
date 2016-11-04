package com.blueeagle.migrainebuddyui.Activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.blueeagle.migrainebuddyui.R;
import com.blueeagle.migrainebuddyui.SharePreManager;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent;

                if (SharePreManager.getUser(getApplicationContext()).equals(""))
                    intent = new Intent(SplashActivity.this, IntroductionActivity.class);
                else
                    intent = new Intent(SplashActivity.this, MainActivity.class); // MainActivity

                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}
