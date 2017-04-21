package com.uncle2000.androidcommonutils.views.chart.base.coordinate;

import android.graphics.Point;
import android.support.annotation.ColorInt;

/**
 * 锚点 坐标系的原点
 * Created by 2000 on 2017/4/20.
 */

public class Anchor {
    public int x, y;
    private Point origin;
    private String text;
    private int direction;
    @ColorInt
    private int textColor;

    public Anchor(Point origin) {
        this.origin = origin;
    }

    public Anchor(int x, int y) {
        this.x = x;
        this.y = y;
        this.origin = new Point(x, y);
    }

    public Point getOrigin() {
        return origin;
    }

    public void setOrigin(Point origin) {
        this.origin = origin;
    }
}
