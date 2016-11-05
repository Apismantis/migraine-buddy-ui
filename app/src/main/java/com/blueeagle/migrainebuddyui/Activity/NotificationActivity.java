package com.blueeagle.migrainebuddyui.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.blueeagle.migrainebuddyui.Adapter.NotificationAdapter;
import com.blueeagle.migrainebuddyui.Adapter.NotificationItem;
import com.blueeagle.migrainebuddyui.Decorator.DividerItemDecoration;
import com.blueeagle.migrainebuddyui.R;

import java.util.ArrayList;
import java.util.List;

public class NotificationActivity extends AppCompatActivity {

    private RecyclerView rcvNotifications;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);

        rcvNotifications = (RecyclerView) findViewById(R.id.rcvNotifications);
        rcvNotifications.setHasFixedSize(true);
        rcvNotifications.setLayoutManager(new LinearLayoutManager(this));
        rcvNotifications.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        rcvNotifications.setAdapter(new NotificationAdapter(getNotifications()));
    }

    private List<NotificationItem> getNotifications() {
        List<NotificationItem> notificationItems = new ArrayList<>();

        notificationItems.add(new NotificationItem("Welcome back!",
                "Welcome to Migraine Buddy!", "10/9/16", "11:39 PM",
                R.drawable.ic_notification_info_table));

        notificationItems.add(new NotificationItem("Update New Version",
                "Migraine Buddy version 20.3", "10/8/16", "6:40 PM",
                R.drawable.ic_notification_info_table));

        notificationItems.add(new NotificationItem("Welcome!",
                "Welcome to Migraine Buddy!", "10/7/16", "11:00 PM",
                R.drawable.ic_notification_info_table));

        return notificationItems;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
