package com.blueeagle.migrainebuddyui.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.blueeagle.migrainebuddyui.R;

public class MigraineSummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_migraine_summary);

        getSupportActionBar().hide();
    }
}
