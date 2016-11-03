package com.blueeagle.migrainebuddyui.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blueeagle.migrainebuddyui.R;

import java.util.List;

public class MenuItemAdapter extends BaseAdapter {
    List<NavMenuItem> navMenuItems;
    Context context;
    LayoutInflater layoutInflater;

    public MenuItemAdapter(List<NavMenuItem> navMenuItems, Context context) {
        this.navMenuItems = navMenuItems;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return navMenuItems.size();
    }

    @Override
    public Object getItem(int position) {
        return navMenuItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final MenuItemHolder holder;

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.layout_nav_menu_item, parent, false);
            holder = new MenuItemHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (MenuItemHolder) convertView.getTag();
        }

        holder.imvIcon.setImageResource(navMenuItems.get(position).getIcon());
        holder.tvTitle.setText(navMenuItems.get(position).getTitle());

        // Set on touch
        holder.lnMenuItem.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        holder.imvIcon.setImageResource(navMenuItems.get(position).getIconPressed());
                        holder.tvTitle.setTextColor(Color.WHITE);
                        break;

                    default:
                        holder.imvIcon.setImageResource(navMenuItems.get(position).getIcon());
                        holder.tvTitle.setTextColor(Color.parseColor("#7DC1C8"));
                        break;
                }

                return true;
            }
        });

        return convertView;
    }

    public class MenuItemHolder {
        LinearLayout lnMenuItem;
        ImageView imvIcon;
        TextView tvTitle;

        public MenuItemHolder(View view) {
            lnMenuItem = (LinearLayout) view.findViewById(R.id.lnMenuItem);
            imvIcon = (ImageView) view.findViewById(R.id.imvIcon);
            tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        }
    }
}
