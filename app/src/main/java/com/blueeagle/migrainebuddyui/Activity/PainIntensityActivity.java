package com.blueeagle.migrainebuddyui.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import com.blueeagle.migrainebuddyui.R;

public class PainIntensityActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private LinearLayout btnNext;
    private Button btnBotherLater;
    private RadioGroup rbgIntensityRate;
    private LinearLayout lnCurrIntensityDes;
    private LinearLayout lnCurrIntensityInfo;

    private int[] colors = new int[]{
            R.color.colorIntensity10Checked,
            R.color.colorIntensity9Checked,
            R.color.colorIntensity8Checked,
            R.color.colorIntensity7Checked,
            R.color.colorIntensity6Checked,
            R.color.colorIntensity5Checked,
            R.color.colorIntensity4Checked,
            R.color.colorIntensity3Checked,
            R.color.colorIntensity2Checked,
            R.color.colorIntensity10Checked
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pain_intensity);

        getSupportActionBar().hide();

        btnNext = (LinearLayout) findViewById(R.id.btnNext);
        btnBotherLater = (Button) findViewById(R.id.btnBotherLater);
        rbgIntensityRate = (RadioGroup) findViewById(R.id.rbgIntensityRate);
        lnCurrIntensityDes = (LinearLayout) findViewById(R.id.lnIntensity3);
        lnCurrIntensityInfo = (LinearLayout) findViewById(R.id.lnIntensity33);

        btnBotherLater.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        rbgIntensityRate.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.btnBotherLater:
                Intent intent = new Intent(PainIntensityActivity.this, MyRecordActivity.class);
                startActivity(intent);
                finish();
                break;

            case R.id.btnNext:
                Intent intent1 = new Intent(PainIntensityActivity.this, PainOnsetActivity.class);
                startActivity(intent1);
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        int id = group.getId();

        if (id == R.id.rbgIntensityRate) {
            View rd = rbgIntensityRate.findViewById(checkedId);
            int idx = rbgIntensityRate.indexOfChild(rd);
            changeIntensityDes(idx);
            changeIntensityInfo(idx);
        }
    }

    private void changeIntensityInfo(int idx) {
        int color = getResources().getColor(colors[idx]);
        lnCurrIntensityInfo.setBackgroundColor(color);
    }

    private void changeIntensityDes(int idx) {

        lnCurrIntensityDes.setVisibility(View.INVISIBLE);
        lnCurrIntensityInfo.setBackgroundColor(getResources().getColor(R.color.colorBackground));

        switch (idx) {
            case 9:
            case 8:
                lnCurrIntensityDes = (LinearLayout) findViewById(R.id.lnIntensity1);
                lnCurrIntensityInfo = (LinearLayout) findViewById(R.id.lnIntensity11);
                break;

            case 7:
            case 6:
                lnCurrIntensityDes = (LinearLayout) findViewById(R.id.lnIntensity2);
                lnCurrIntensityInfo = (LinearLayout) findViewById(R.id.lnIntensity22);
                break;

            case 5:
            case 4:
                lnCurrIntensityDes = (LinearLayout) findViewById(R.id.lnIntensity3);
                lnCurrIntensityInfo = (LinearLayout) findViewById(R.id.lnIntensity33);
                break;

            case 3:
            case 2:
                lnCurrIntensityDes = (LinearLayout) findViewById(R.id.lnIntensity4);
                lnCurrIntensityInfo = (LinearLayout) findViewById(R.id.lnIntensity44);
                break;

            case 1:
            case 0:
                lnCurrIntensityDes = (LinearLayout) findViewById(R.id.lnIntensity5);
                lnCurrIntensityInfo = (LinearLayout) findViewById(R.id.lnIntensity55);
                break;
        }

        lnCurrIntensityDes.setVisibility(View.VISIBLE);
    }
}
