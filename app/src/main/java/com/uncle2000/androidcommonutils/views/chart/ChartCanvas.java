package com.uncle2000.androidcommonutils.views.chart;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import com.uncle2000.androidcommonutils.views.chart.blank.BlankCoorSystem;

/**
 * 图表的View类 负责将图表画到canvas上
 * Created by 2000 on 2017/4/26.
 */

public class ChartCanvas extends View {
    /**
     * 坐标系的基类，除非你不准备画坐标轴，否则请用多态的形式去用它
     */
    BlankCoorSystem coorSystem;

    public ChartCanvas(Context context) {
        this(context, null);
    }

    public ChartCanvas(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ChartCanvas(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ChartCanvas(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        coorSystem.draw(canvas);
    }
}
