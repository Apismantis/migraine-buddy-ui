package com.blueeagle.migrainebuddyui.Activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.blueeagle.migrainebuddyui.Adapter.PagerAdapter;
import com.blueeagle.migrainebuddyui.Fragment.MigraineFragment;
import com.blueeagle.migrainebuddyui.Fragment.SleepFragment;
import com.blueeagle.migrainebuddyui.R;

public class MyRecordActivity extends AppCompatActivity {

    private static final String TAG = "MyRecordActivity";
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private boolean isShowAsyncBtn = true;
    private int currentTab = 0;
    private final int MIGGAINE_TAB = 0;
    private final int SLEEP_TAB = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_record);

        // Set up action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);
        getSupportActionBar().setElevation(0f);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                isShowAsyncBtn = position == 0;
                currentTab = position;
                invalidateOptionsMenu();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        initViewPager();
        initTabLayout();
    }

    private void initTabLayout() {
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_tab_migraine);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_tab_sleep);
    }

    private void initViewPager() {
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new MigraineFragment(), "MIGRAINE");
        adapter.addFragment(new SleepFragment(), "SLEEP");
        viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_my_record, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case android.R.id.home:
                onBackPressed();
                break;

            case R.id.action_add:
                openActivityForAddButton();
                break;

            case R.id.action_sync:
                Log.d(TAG, "Sync...");
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void openActivityForAddButton() {
        if(currentTab == SLEEP_TAB) {
            Intent intent = new Intent(MyRecordActivity.this, SleepTimeActivity.class);
            startActivity(intent);
        } else {

        }
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem item = menu.findItem(R.id.action_sync);

        if (isShowAsyncBtn) {
            item.setVisible(true);
        } else {
            item.setVisible(false);
        }

        return true;
    }
}
