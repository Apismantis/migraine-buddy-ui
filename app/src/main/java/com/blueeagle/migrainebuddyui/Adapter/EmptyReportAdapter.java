package com.blueeagle.migrainebuddyui.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.blueeagle.migrainebuddyui.R;

import java.util.List;

public class EmptyReportAdapter extends RecyclerView.Adapter<EmptyReportAdapter.StatusHolder> {

    List<EmptyReportItem> reportItems;

    public EmptyReportAdapter(List<EmptyReportItem> reportItemList) {
        reportItems = reportItemList;
    }

    @Override
    public StatusHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_empty_report_item, parent, false);
        return new StatusHolder(v);
    }

    @Override
    public void onBindViewHolder(StatusHolder holder, int position) {
        holder.setData(reportItems.get(position));
    }

    @Override
    public int getItemCount() {
        return reportItems.size();
    }

    public class StatusHolder extends RecyclerView.ViewHolder {
        ImageView imvTitleBack;
        ImageView imvDes;
        TextView tvTitle;
        TextView tvDescription;


        public StatusHolder(View itemView) {
            super(itemView);

            imvTitleBack = (ImageView) itemView.findViewById(R.id.imvTitleBack);
            imvDes = (ImageView) itemView.findViewById(R.id.imvDesImage);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvDescription = (TextView) itemView.findViewById(R.id.tvDes);
        }

        public void setData(EmptyReportItem reportItem) {
            imvTitleBack.setImageResource(reportItem.getImTitle());
            imvDes.setImageResource(reportItem.getImDes());
            tvTitle.setText(reportItem.getTitle());
            tvDescription.setText(reportItem.getDes());
        }
    }
}
