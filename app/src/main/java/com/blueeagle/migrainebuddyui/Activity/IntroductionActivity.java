package com.blueeagle.migrainebuddyui.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.blueeagle.migrainebuddyui.R;

public class IntroductionActivity extends AppCompatActivity {

    private ViewPager introPaper;
    private int[] layouts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        getSupportActionBar().hide();

        layouts = new int[]{
                R.layout.layout_intro_1,
                R.layout.layout_intro_2,
                R.layout.layout_intro_3,
                R.layout.layout_intro_4,
                R.layout.layout_intro_5
        };

        introPaper = (ViewPager) findViewById(R.id.vpIntro);

        MyViewPaperAdapter myViewPaperAdapter = new MyViewPaperAdapter();
        introPaper.setAdapter(myViewPaperAdapter);
    }

    public class MyViewPaperAdapter extends PagerAdapter {

        private LayoutInflater layoutInflater;

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(layouts[position], container, false);
            container.addView(view);

            // Set onClick for button
            if (position == 4) {

                ((Button) view.findViewById(R.id.btnCreateAccount)).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(IntroductionActivity.this, SignUpActivity.class);
                        startActivity(intent);
                    }
                });

                ((Button) view.findViewById(R.id.btnLoginAccount)).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(IntroductionActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }
                });
            }

            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }
}
