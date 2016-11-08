package com.blueeagle.migrainebuddyui.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.TabLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.blueeagle.migrainebuddyui.Adapter.PagerAdapter;

import com.blueeagle.migrainebuddyui.Adapter.MenuItemAdapter;
import com.blueeagle.migrainebuddyui.Adapter.NavMenuItem;
import com.blueeagle.migrainebuddyui.Fragment.BuddiesFragment;
import com.blueeagle.migrainebuddyui.Fragment.MeFragment;
import com.blueeagle.migrainebuddyui.Fragment.ReportFragment;
import com.blueeagle.migrainebuddyui.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private DrawerLayout drawerLayout;
    private ListView lvMenuItem;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Init drawer layout
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        // Init menu item
        lvMenuItem = (ListView) findViewById(R.id.lvMenuItem);
        final List<NavMenuItem> menuItems = initMenuItem();
        lvMenuItem.setAdapter(new MenuItemAdapter(menuItems, this));
        lvMenuItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(TAG, "aaaa");

                if (menuItems.get(i).getTitle().equals("Leave Feedback")) {
                    openFeedbackDialog();
                }
            }
        });

        // Init viewpager
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ReportFragment(), "REPORTS");
        adapter.addFragment(new MeFragment(), "ME");
        adapter.addFragment(new BuddiesFragment(), "BUDDIES");
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(1);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        initTabLayout();
        tabLayout.setupWithViewPager(viewPager);
    }

    private void openFeedbackDialog() {
        final Dialog dialog = new Dialog(getApplicationContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.layout_dialog_feedback);

        Button btnCancel = (Button) dialog.findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    private List<NavMenuItem> initMenuItem() {
        List<NavMenuItem> menuItems = new ArrayList<>();
        menuItems.add(new NavMenuItem(R.drawable.icn_export_normal, R.drawable.icn_export_clicked, "Export"));
        menuItems.add(new NavMenuItem(R.drawable.icn_feedback_normal, R.drawable.icn_feedback_clicked, "Leave Feedback"));
        menuItems.add(new NavMenuItem(R.drawable.icn_rate_normal, R.drawable.icn_rate_clicked, "Rate us 5 start!"));
        menuItems.add(new NavMenuItem(R.drawable.icn_settings_normal, R.drawable.icn_settings_clicked, "Settings"));
        menuItems.add(new NavMenuItem(R.drawable.btn_user_normal, R.drawable.btn_user_clicked, "My Profile"));
        menuItems.add(new NavMenuItem(R.drawable.icn_tutorial_normal, R.drawable.icn_tutorial_clicked, "How To Use?"));
        menuItems.add(new NavMenuItem(R.drawable.icn_about_normal, R.drawable.icn_about_clicked, "About"));
        menuItems.add(new NavMenuItem(R.drawable.icn_logout_normal, R.drawable.icn_logout_clicked, "Logout"));

        return menuItems;
    }

    public void initTabLayout() {
        tabLayout.addTab(tabLayout.newTab().setText("REPORTS"));
        tabLayout.addTab(tabLayout.newTab().setText("ME"));
        tabLayout.addTab(tabLayout.newTab().setText("BUDDIES"));
    }

    @Override
    public void onBackPressed() {
        // Open and close navigation
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_notification) {
            Intent intent = new Intent(MainActivity.this, NotificationActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
