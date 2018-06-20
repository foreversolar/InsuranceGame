package com.example.captain.insurancegame;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by liyongxiang on 2017/4/30.
 */

public class MarqueeTextView extends TextView {

    public MarqueeTextView(Context context) {
        this(context, null);
    }

    public MarqueeTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MarqueeTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * a.当前控件的焦点,第一次xml加载 的情况
     */
    @Override
    public boolean isFocused() {
        return true;//告诉我们的系统 ,我这里是一直有焦点的
    }

    //b.在更改焦点时,有别的控件申请焦点的情况下
    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        if (focused) {//有焦点
            super.onFocusChanged(focused, direction, previouslyFocusedRect);
        }
    }

    //c.弹出对话框的情况下
    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        if (hasWindowFocus) {
            super.onWindowFocusChanged(hasWindowFocus);
        }
    }
}