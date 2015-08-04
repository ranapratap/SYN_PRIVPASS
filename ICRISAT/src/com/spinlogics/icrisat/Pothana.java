package com.spinlogics.icrisat;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class Pothana extends TextView {


    public Pothana(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public Pothana(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Pothana(Context context) {
        super(context);
        init();
    }

    public void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "pothana.ttf");
        setTypeface(tf ,1);

    }
}
