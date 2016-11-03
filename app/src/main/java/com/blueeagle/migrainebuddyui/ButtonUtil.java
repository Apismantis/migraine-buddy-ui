package com.blueeagle.migrainebuddyui;

import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.widget.Button;
import android.widget.TextView;

public class ButtonUtil {

    public static void setTwoLineTextForButton(Button button, String bigText,
                                               String smallText, int bigSize, int smallSize, boolean isDpi) {

        SpannableStringBuilder spanSin = new SpannableStringBuilder();
        SpannableString itemasin = new SpannableString(bigText + "\n");
        itemasin.setSpan(new AbsoluteSizeSpan(bigSize, isDpi), 0, itemasin.length(), 0);
        itemasin.setSpan(new StyleSpan(Typeface.BOLD), 0, bigText.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        spanSin.append(itemasin);

        SpannableString itemsin = new SpannableString(smallText);
        itemsin.setSpan(new AbsoluteSizeSpan(smallSize, isDpi), 0, itemsin.length(), 0);
        spanSin.append(itemsin);
        button.setText(spanSin, TextView.BufferType.SPANNABLE);
    }
}
