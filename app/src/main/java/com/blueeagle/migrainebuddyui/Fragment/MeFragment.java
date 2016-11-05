package com.blueeagle.migrainebuddyui.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.blueeagle.migrainebuddyui.Activity.MyRecordActivity;
import com.blueeagle.migrainebuddyui.R;

public class MeFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = "FragmentMe";
    private Context mContext;
    private View rootLayout;
    private Button btnDailyTracker, btnMyRecord, btnMyCalendar;
    private LinearLayout btnEditRunning;

    public MeFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContext = getActivity();
        rootLayout = inflater.inflate(R.layout.fragment_me, container, false);
        Log.d("AAA", "Me on create view...");

        btnEditRunning = (LinearLayout) rootLayout.findViewById(R.id.btnEditRunning);
        btnDailyTracker = (Button) rootLayout.findViewById(R.id.btnDailyTracker);
        btnMyRecord = (Button) rootLayout.findViewById(R.id.btnMyRecord);
        btnMyCalendar = (Button) rootLayout.findViewById(R.id.btnMyCalender);

        btnMyRecord.setOnClickListener(this);
        btnEditRunning.setOnClickListener(this);
        btnDailyTracker.setOnClickListener(this);
        btnMyCalendar.setOnClickListener(this);

        return rootLayout;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        Log.d(TAG, "onClick.....");

        switch (id) {
            case R.id.btnEditRunning:
                break;

            case R.id.btnMyRecord:
                Intent intent = new Intent(v.getContext(), MyRecordActivity.class);
                startActivity(intent);
                break;

            case R.id.btnDailyTracker:
            case R.id.btnMyCalender:
                Toast.makeText(mContext, "Chức năng không yêu cầu làm", Toast.LENGTH_LONG).show();
                break;
        }
    }
}
