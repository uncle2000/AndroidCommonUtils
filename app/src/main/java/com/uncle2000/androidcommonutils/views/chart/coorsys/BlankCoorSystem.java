package com.uncle2000.androidcommonutils.views.chart.coorsys;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.uncle2000.androidcommonutils.views.chart.Constant;
import com.uncle2000.androidcommonutils.views.chart.chart.Charts;
import com.uncle2000.androidcommonutils.views.chart.model.Anchor;
import com.uncle2000.androidcommonutils.views.chart.model.ChartOption;

import java.util.List;
import java.util.Set;

/**
 * 不一定所有的数据表格都需要坐标轴的称托，所以才需要一个什么都不画的类
 * 当然关键还是View绘制子类的时候方便拓展程序
 * Created by 2000 on 2017/4/25.
 */

public class BlankCoorSystem extends View {
    private Context context;
    protected Paint paint = new Paint();
    protected ChartOption chartOption;
    protected Anchor anchor;
    private Set<Charts> charts;

    public BlankCoorSystem(Context context) {
        super(context);
        this.context = context;
        this.anchor = new Anchor();
    }

    public BlankCoorSystem(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        this.anchor = new Anchor();
    }

    public BlankCoorSystem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        this.anchor = new Anchor();
    }

    public BlankCoorSystem(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.context = context;
        this.anchor = new Anchor();
    }

    public BlankCoorSystem(Context context, ChartOption chartOption) {
        super(context);
        this.context = context;
        this.chartOption = chartOption;
        this.anchor = new Anchor(chartOption.anchor.x, chartOption.anchor.y);
        this.charts = chartOption.charts;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width = Constant.DEFALT_CHART_WIDTH;
        int height = Constant.DEFALT_CHART_HEIGHT;

        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        }
        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        }

        setMeasuredDimension(width, height);
    }

    public void draw(Canvas canvas) {
        if (null != chartOption) {
            chartOption.chartHeight = getHeight();
            chartOption.chartWidth = getWidth();
        }
        drawAnchor(canvas);
    }

    private void drawAnchor(Canvas canvas) {
        if (null != anchor)
            canvas.drawText(anchor.getText(),
                    anchor.x + anchor.getTextOffsetX(),
                    anchor.y + anchor.getTextOffsetY(),
                    anchor.getAnchorPaint());

        if (null != charts)
            for (Charts c : charts) {
                c.setPaint(paint);
                c.draw(canvas);
            }
    }

    public void setChartOption(ChartOption chartOption) {
        this.chartOption = chartOption;
        this.anchor = chartOption.anchor;
        this.charts = chartOption.charts;
    }
}
