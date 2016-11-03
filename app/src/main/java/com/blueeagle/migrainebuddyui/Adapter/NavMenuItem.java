package com.blueeagle.migrainebuddyui.Adapter;

public class NavMenuItem {
    private int icon;
    private int iconPressed;
    private String title;

    public NavMenuItem(int icon, int iconPressed, String title) {
        this.icon = icon;
        this.iconPressed = iconPressed;
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIconPressed() {
        return iconPressed;
    }

    public void setIconPressed(int iconPressed) {
        this.iconPressed = iconPressed;
    }
}
