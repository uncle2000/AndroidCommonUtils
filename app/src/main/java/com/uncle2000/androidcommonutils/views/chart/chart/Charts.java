package com.uncle2000.androidcommonutils.views.chart.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;


import java.util.List;

/**
 * Created by 2000 on 2017/4/26.
 */

public abstract class Charts {
    public abstract void draw(Canvas canvas, List<Point> list, Paint paint);
}
