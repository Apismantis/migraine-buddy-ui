package com.blueeagle.migrainebuddyui.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.blueeagle.migrainebuddyui.Adapter.StatusAdapter;
import com.blueeagle.migrainebuddyui.Adapter.StatusItem;
import com.blueeagle.migrainebuddyui.Decorator.DividerItemDecoration;
import com.blueeagle.migrainebuddyui.R;

import java.util.ArrayList;
import java.util.List;

public class BuddiesFragment extends Fragment {

    private View rootLayout;
    private Context mContext;
    private RecyclerView rcvStatus;

    public BuddiesFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContext = getActivity();
        rootLayout = inflater.inflate(R.layout.fragment_buddies, container, false);
        rcvStatus = (RecyclerView) rootLayout.findViewById(R.id.rcvStatus);

        rcvStatus.setHasFixedSize(true);
        rcvStatus.setLayoutManager(new LinearLayoutManager(mContext));

        rcvStatus.addItemDecoration(new DividerItemDecoration(mContext, LinearLayout.VERTICAL));
        rcvStatus.setAdapter(new StatusAdapter(getStatus()));

        Log.d("AAA", "Buddies on create view...");

        return rootLayout;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public List<StatusItem> getStatus() {
        List<StatusItem> statusItems = new ArrayList<>();

        statusItems.add(new StatusItem("Pressure Buddy",
                "The pressure is currently 0.0 millibar",
                "Last seen 12 minutes ago",
                R.drawable.ic_city_buddy));

        statusItems.add(new StatusItem("Show risk of migraines in your city",
                "Determining location can take up 2 minutes...",
                "Last seen 12 minutes ago",
                R.drawable.ic_city_buddy));

        return statusItems;
    }
}
