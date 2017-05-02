package com.uncle2000.androidcommonutils.views.chart.coorsystem;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.uncle2000.androidcommonutils.views.chart.RangeModel;

/**
 * 不一定所有的数据表格都需要坐标轴的称托，所以才需要一个什么都不画的类
 * 当然关键还是View绘制子类的时候方便拓展程序
 * Created by 2000 on 2017/4/25.
 */

public class BlankCoorSystem {
    protected RangeModel rangeModel;
    protected Anchor anchor;

    public BlankCoorSystem(RangeModel rangeModel) {
        this.rangeModel = rangeModel;
        anchor = rangeModel.anchor;
    }

    public void draw(Canvas canvas) {
        drawAnchor(canvas);
    }

    private void drawAnchor(Canvas canvas) {
        if (null != anchor) {
            canvas.drawText(anchor.getText(),
                    anchor.x + anchor.getTextOffsetX(),
                    anchor.y + anchor.getTextOffsetY(),
                    anchor.getAnchorPaint());
        }
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

    public void setAnchor(Anchor anchor) {
        this.anchor = anchor;
    }
}
