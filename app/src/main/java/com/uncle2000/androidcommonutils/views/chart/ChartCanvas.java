package com.uncle2000.androidcommonutils.views.chart;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import com.uncle2000.androidcommonutils.views.chart.coorsystem.BlankCoorSystem;
import com.uncle2000.androidcommonutils.views.chart.datalooks.ChartData;
import com.uncle2000.androidcommonutils.views.chart.coorsystem.Anchor;


/**
 * 图表的View类 负责将图表画到canvas上
 * Created by 2000 on 2017/4/26.
 */

public class ChartCanvas extends View {
    /**
     * 坐标系的基类，除非你不准备画坐标轴，否则请用多态的形式去用它
     * 要画的数据也已经包含进去了
     */
    ChartData[] chartData;
    Anchor anchor;
    BlankCoorSystem coorSystem;

    /**
     * 比例
     * 1px=1dataScale单位
     */
    protected float dataScale = 100;

    public ChartCanvas(Context context) {
        this(context, null);
    }

    public ChartCanvas(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ChartCanvas(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public ChartCanvas(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
    }


    private void setA() {
        if (null != anchor && null != coorSystem) {
            coorSystem.setAnchor(anchor);
        }
    }

//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
//        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
//        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
//        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
//
//        int width;
//        int height;
//
//        if (heightMode == MeasureSpec.EXACTLY) {
//            height = heightSize;
//        } else {
//            height = Math.max(getSuggestedMinimumHeight(), (int) warpHeight);
//        }
//
//        if (widthMode == MeasureSpec.EXACTLY) {
//            width = widthSize;
//        } else {
//            width = Math.max(getSuggestedMinimumWidth(), (int) warpWidth);
//        }
//
//        setMeasuredDimension(width, height);
//    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (null != chartData) {
            for (ChartData cd : chartData) {
                cd.draw(canvas);
            }
        }

        drawAnchor(canvas);

        if (coorSystem != null)
            coorSystem.draw(canvas);
    }

    private void drawAnchor(Canvas canvas) {
        if (null != anchor) {
            canvas.drawText(anchor.getText(),
                    anchor.x + anchor.getTextOffsetX(),
                    anchor.y + anchor.getTextOffsetY(),
                    anchor.getAnchorPaint());
        }
    }

    public ChartData[] getChartData() {
        return chartData;
    }

    public void setChartData(ChartData[] chartData) {
        this.chartData = chartData;
    }

    public Anchor getAnchor() {
        return anchor;
    }

    public void setAnchor(Anchor anchor) {
        this.anchor = anchor;
        setA();
    }

    public BlankCoorSystem getCoorSystem() {
        return coorSystem;
    }

    public void setCoorSystem(BlankCoorSystem coorSystem) {
        this.coorSystem = coorSystem;
        setA();
    }
}
