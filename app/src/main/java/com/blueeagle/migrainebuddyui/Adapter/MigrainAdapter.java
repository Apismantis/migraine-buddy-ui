package com.blueeagle.migrainebuddyui.Adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blueeagle.migrainebuddyui.Activity.MigraineSummaryActivity;
import com.blueeagle.migrainebuddyui.R;

import java.util.List;

public class MigrainAdapter extends RecyclerView.Adapter<MigrainAdapter.MigraineHolder> {

    List<MigraineItem> migraineItems;

    public MigrainAdapter(List<MigraineItem> migraineItemList) {
        this.migraineItems = migraineItemList;
    }

    @Override
    public MigraineHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_migraine_item, parent, false);
        return new MigraineHolder(v);
    }

    @Override
    public void onBindViewHolder(MigraineHolder holder, int position) {
        holder.setData(migraineItems.get(position));
    }

    @Override
    public int getItemCount() {
        return migraineItems.size();
    }

    public class MigraineHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvDate;
        TextView tvIntensity;
        TextView tvDuration;


        public MigraineHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            tvDate = (TextView) itemView.findViewById(R.id.tvDate);
            tvIntensity = (TextView) itemView.findViewById(R.id.tvIntensity);
            tvDuration = (TextView) itemView.findViewById(R.id.tvDuration);
        }

        public void setData(MigraineItem migraineItem) {
            tvDate.setText(migraineItem.getDate());
            tvIntensity.setText(migraineItem.getIntensity());
            tvDuration.setText(migraineItem.getDuration());
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), MigraineSummaryActivity.class);
            v.getContext().startActivity(intent);
        }
    }
}
