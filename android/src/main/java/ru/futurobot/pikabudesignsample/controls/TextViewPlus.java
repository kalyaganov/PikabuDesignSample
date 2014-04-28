package ru.futurobot.pikabudesignsample.controls;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;
import ru.futurobot.pikabudesignsample.R;

/**
 * Created by Alexey on 28.04.2014.
 */
public class TextViewPlus extends TextView {

    public TextViewPlus(Context context) {
        super(context);
    }

    public TextViewPlus(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode()) {
            setCustomFont(context, attrs);
        }
    }

    public TextViewPlus(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        if (!isInEditMode()) {
            setCustomFont(context, attrs);
        }
    }

    private void setCustomFont(Context ctx, AttributeSet attrs) {
        TypedArray a = ctx.obtainStyledAttributes(attrs, R.styleable.TextViewPlus);
        String customFont = a.getString(R.styleable.TextViewPlus_custom_font);
        boolean success = setCustomFont(ctx, customFont);
        a.recycle();
        if (!success) {
            throw new IllegalStateException(String.format("Could not get typeface %s", customFont));
        }
    }

    public boolean setCustomFont(Context ctx, String asset) {
        Typeface tf = null;
        try {
            tf = Typeface.createFromAsset(ctx.getAssets(), asset);
        } catch (Exception e) {
            Log.e(TextViewPlus.class.getSimpleName(), "Could not get typeface");
            return false;
        }

        setTypeface(tf);
        return true;
    }

}
