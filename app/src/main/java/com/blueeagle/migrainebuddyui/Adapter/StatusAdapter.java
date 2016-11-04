package com.blueeagle.migrainebuddyui.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.blueeagle.migrainebuddyui.R;

import java.util.List;

public class StatusAdapter extends RecyclerView.Adapter<StatusAdapter.StatusHolder> {

    List<StatusItem> statusItems;

    public StatusAdapter(List<StatusItem> statusItemList) {
        statusItems = statusItemList;
    }

    @Override
    public StatusHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_status_item, parent, false);
        return new StatusHolder(v);
    }

    @Override
    public void onBindViewHolder(StatusHolder holder, int position) {
        holder.setData(statusItems.get(position));
    }

    @Override
    public int getItemCount() {
        return statusItems.size();
    }

    public class StatusHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView title;
        TextView content;
        TextView time;


        public StatusHolder(View itemView) {
            super(itemView);

            icon = (ImageView) itemView.findViewById(R.id.imvIcon);
            title = (TextView) itemView.findViewById(R.id.tvTitle);
            time = (TextView) itemView.findViewById(R.id.tvTime);
            content = (TextView) itemView.findViewById(R.id.tvContent);
        }

        public void setData(StatusItem status) {
            icon.setImageResource(status.getIcon());
            title.setText(status.getTitle());
            time.setText(status.getTime());
            content.setText(status.getContent());
        }
    }
}
