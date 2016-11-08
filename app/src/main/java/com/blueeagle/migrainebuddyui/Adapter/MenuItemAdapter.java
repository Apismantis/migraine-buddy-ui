package com.blueeagle.migrainebuddyui.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
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

        holder.lnMenuItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position == 1) {
                    final Dialog dialog = new Dialog(context);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.layout_dialog_feedback);

                    Button btnCancel = (Button) dialog.findViewById(R.id.btnCancel);
                    btnCancel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });

                    dialog.show();
                }
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
