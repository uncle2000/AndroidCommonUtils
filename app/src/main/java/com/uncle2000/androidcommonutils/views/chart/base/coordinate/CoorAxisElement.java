package com.uncle2000.androidcommonutils.views.chart.base.coordinate;

import android.graphics.Canvas;
import android.support.annotation.ColorInt;

/**
 * Created by 2000 on 2017/4/20.
 */

public class CoorAxisElement {
    private int direction;
    private String text;
    private int textRotateDegrees;
    @ColorInt
    private int textColor;

    private boolean showScale;
    private int scaleOffset;
    private int scaleLength;
    @ColorInt
    private int scaleColor;

    public void drawSelf(Canvas canvas) {

    }
}
