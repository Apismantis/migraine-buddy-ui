package com.blueeagle.migrainebuddyui.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blueeagle.migrainebuddyui.R;

public class ReportFragment extends Fragment {
    private Context mContext;
    private View rootLayout;
    private RecyclerView rcvReports;

    public ReportFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContext = getActivity();
        rootLayout = inflater.inflate(R.layout.fragment_report, container, false);
        return rootLayout;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rcvReports = (RecyclerView) rootLayout.findViewById(R.id.rcvReports);
    }
}
