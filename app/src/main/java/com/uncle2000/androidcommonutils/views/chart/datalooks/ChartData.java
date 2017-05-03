package com.uncle2000.androidcommonutils.views.chart.datalooks;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.annotation.Size;

import com.uncle2000.androidcommonutils.views.chart.RangeModel;
import com.uncle2000.androidcommonutils.views.chart.coorsystem.Anchor;

import java.util.List;

/**
 * Created by 2000 on 2017/4/26.
 */

public class ChartData {
    protected RangeModel rangeModel;
    protected Paint paint;

    ChartData(RangeModel rangeModel) {
        this(rangeModel, null);
    }

    ChartData(RangeModel rangeModel, Paint paint) {
        if (null == paint) {
            paint = new Paint();
            paint.setStrokeWidth(5f);
        }
        this.paint = paint;
        this.rangeModel = rangeModel;
    }

    public void draw(Canvas canvas) {

    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }
}
