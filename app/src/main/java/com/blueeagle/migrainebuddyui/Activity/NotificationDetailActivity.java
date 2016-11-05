package com.blueeagle.migrainebuddyui.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.blueeagle.migrainebuddyui.Constants.Constants;
import com.blueeagle.migrainebuddyui.R;

public class NotificationDetailActivity extends AppCompatActivity {

    private TextView tvTitle, tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);


        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvContent = (TextView) findViewById(R.id.tvContent);

        Intent intent = getIntent();
        tvTitle.setText(intent.getStringExtra(Constants.TITLE));
        tvContent.setText(intent.getStringExtra(Constants.CONTENT));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }
}
