package com.blueeagle.migrainebuddyui.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.blueeagle.migrainebuddyui.R;

public class ReliefActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout btnNext;
    private Button btnBotherLater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relief);

        getSupportActionBar().hide();

        btnNext = (LinearLayout) findViewById(R.id.btnNext);
        btnBotherLater = (Button) findViewById(R.id.btnBotherLater);

        btnBotherLater.setOnClickListener(this);
        btnNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.btnBotherLater:
                Intent intent = new Intent(ReliefActivity.this, MyRecordActivity.class);
                startActivity(intent);
                finish();
                break;

            case R.id.btnNext:
                Intent intent1 = new Intent(ReliefActivity.this, SymptomActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
