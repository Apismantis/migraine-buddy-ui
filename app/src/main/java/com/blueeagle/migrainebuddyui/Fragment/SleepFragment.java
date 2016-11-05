package com.blueeagle.migrainebuddyui.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blueeagle.migrainebuddyui.Adapter.MigraineItem;
import com.blueeagle.migrainebuddyui.Adapter.SleepAdapter;
import com.blueeagle.migrainebuddyui.R;

import java.util.ArrayList;
import java.util.List;

public class SleepFragment extends Fragment {

    private Context mContext;
    private View rootLayout;

    public SleepFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootLayout = inflater.inflate(R.layout.fragment_sleep, container, false);
        mContext = getActivity();

        RecyclerView rcvSleeps = (RecyclerView) rootLayout.findViewById(R.id.rcvSleeps);
        rcvSleeps.setHasFixedSize(true);
        rcvSleeps.setLayoutManager(new LinearLayoutManager(mContext));
        rcvSleeps.setAdapter(new SleepAdapter(getSleeps()));

        return rootLayout;
    }

    private List<MigraineItem> getSleeps() {
        List<MigraineItem> migraineItems = new ArrayList<>();
        migraineItems.add(new MigraineItem("FRI 4", "11/1", "72h00m"));
        migraineItems.add(new MigraineItem("MON 1", "10/1", "72h00m"));
        migraineItems.add(new MigraineItem("THUR 15", "9/1", "72h00m"));
        migraineItems.add(new MigraineItem("TUES", "8/1", "72h00m"));

        return migraineItems;
    }
}
