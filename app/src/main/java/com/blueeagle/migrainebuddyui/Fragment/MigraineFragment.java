package com.blueeagle.migrainebuddyui.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blueeagle.migrainebuddyui.Adapter.MigrainAdapter;
import com.blueeagle.migrainebuddyui.Adapter.MigraineItem;
import com.blueeagle.migrainebuddyui.R;

import java.util.ArrayList;
import java.util.List;

public class MigraineFragment extends Fragment {

    private Context mContext;
    private View rootLayout;

    public MigraineFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootLayout = inflater.inflate(R.layout.fragment_migraine, container, false);
        mContext = getActivity();

        RecyclerView rcvMigraineList = (RecyclerView) rootLayout.findViewById(R.id.rcvMigraineList);
        rcvMigraineList.setHasFixedSize(true);
        rcvMigraineList.setLayoutManager(new LinearLayoutManager(mContext));
        rcvMigraineList.setAdapter(new MigrainAdapter(getMigraines()));

        return rootLayout;
    }

    private List<MigraineItem> getMigraines() {
        List<MigraineItem> migraineItems = new ArrayList<>();
        migraineItems.add(new MigraineItem("11/2/16", "11/1", "72h00m"));
        migraineItems.add(new MigraineItem("10/2/16", "10/1", "72h00m"));
        migraineItems.add(new MigraineItem("9/2/16", "9/1", "72h00m"));
        migraineItems.add(new MigraineItem("8/2/16", "8/1", "72h00m"));

        return migraineItems;
    }
}
