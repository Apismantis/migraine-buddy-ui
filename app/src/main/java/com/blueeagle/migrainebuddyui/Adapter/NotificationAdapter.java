package com.blueeagle.migrainebuddyui.Adapter;

import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.blueeagle.migrainebuddyui.Activity.NotificationDetailActivity;
import com.blueeagle.migrainebuddyui.Constants.Constants;
import com.blueeagle.migrainebuddyui.R;

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationHolder> {

    List<NotificationItem> notificationItems;

    public NotificationAdapter(List<NotificationItem> notificationItemList) {
        notificationItems = notificationItemList;
    }

    @Override
    public NotificationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_notification_item, parent, false);
        return new NotificationHolder(v);
    }

    @Override
    public void onBindViewHolder(NotificationHolder holder, int position) {
        holder.setData(notificationItems.get(position));

        // Set data
        holder.title = notificationItems.get(position).getTitle();
        holder.content = notificationItems.get(position).getContent();
    }

    @Override
    public int getItemCount() {
        return notificationItems.size();
    }

    public class NotificationHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView icon;
        TextView tvTitle;
        TextView tvContent;
        TextView tvDate;
        TextView tvTime;

        String title;
        String content;


        public NotificationHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            icon = (ImageView) itemView.findViewById(R.id.imvIcon);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvContent = (TextView) itemView.findViewById(R.id.tvContent);
            tvDate = (TextView) itemView.findViewById(R.id.tvDate);
            tvTime = (TextView) itemView.findViewById(R.id.tvTime);
        }

        public void setData(NotificationItem notificationItem) {
            icon.setImageResource(notificationItem.getIcon());
            tvTitle.setText(notificationItem.getTitle());
            tvContent.setText(notificationItem.getContent());
            tvDate.setText(notificationItem.getDate());
            tvTime.setText(notificationItem.getTime());
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), NotificationDetailActivity.class);
            intent.putExtra(Constants.TITLE, title);
            intent.putExtra(Constants.CONTENT, content);
            v.getContext().startActivity(intent);
        }
    }
}
