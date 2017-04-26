package com.uncle2000.androidcommonutils.views.chart.blank;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.uncle2000.androidcommonutils.views.chart.data.ChartData;
import com.uncle2000.androidcommonutils.views.chart.descartes.coordinate.Anchor;

/**
 * 不一定所有的数据表格都需要坐标轴的称托，所以才需要一个什么都不画的类
 * 当然关键还是View绘制子类的时候方便用多态来拓展程序
 * Created by 2000 on 2017/4/25.
 */

public class BlankCoorSystem {
    private float minRangeX, maxRangeX, minRangeY, maxRangeY;
    private int lPadding, tPadding, rPadding, bPadding;
    private int lMargin, tMargin, rMargin, bMargin;
    protected int screenW, screenH;
    protected ChartData chartData;
    protected Anchor anchor;

    public BlankCoorSystem(ChartData chartData) {
        this.chartData = chartData;
        this.anchor = chartData.getAnchor();
    }

    public void draw(Canvas canvas) {
        chartData.draw(canvas);
    }


    /**
     * 获得图表坐标轴的绘制范围，这样方便View去计算warp_content的时候应该占多大的位置。
     * 每种表应该有一个默认值
     * 如果表
     *
     * @return
     */
    public Rect getRange() {
        Rect rect = new Rect();

        return rect;
    }
}
