package com.blueeagle.migrainebuddyui.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class ReportAdapter extends RecyclerView.Adapter<ReportAdapter.ReportHolder> {

    private List<EmptyReportItem> emptyReportItems;

    @Override
    public ReportHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ReportHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ReportHolder extends RecyclerView.ViewHolder {



        public ReportHolder(View itemView) {
            super(itemView);
        }
    }
}
