package com.blueeagle.migrainebuddyui;


import android.content.Context;
import android.content.SharedPreferences;

import com.blueeagle.migrainebuddyui.Constants.Constants;

public class SharePreManager {

    public static void saveUser(String email, Context context) {
        if (!email.isEmpty()) {
            SharedPreferences sp = context.getSharedPreferences(Constants.SHARE_PRE_NAME, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putString(Constants.USER_EMAIL, email);
            editor.apply();
        }
    }

    public static String getUser(Context context) {
        SharedPreferences sp = context.getSharedPreferences(Constants.SHARE_PRE_NAME, Context.MODE_PRIVATE);
        return sp.getString(Constants.USER_EMAIL, "");
    }
}
