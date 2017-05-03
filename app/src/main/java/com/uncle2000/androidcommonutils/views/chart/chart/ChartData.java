package com.uncle2000.androidcommonutils.views.chart.chart;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.uncle2000.androidcommonutils.views.chart.model.CanvasModel;

/**
 * Created by 2000 on 2017/4/26.
 */

public class ChartData {
    protected CanvasModel canvasModel;
    protected Paint paint;

    ChartData(CanvasModel canvasModel) {
        this(canvasModel, null);
    }

    ChartData(CanvasModel canvasModel, Paint paint) {
        if (null == paint) {
            paint = new Paint();
            paint.setStrokeWidth(5f);
        }
        this.paint = paint;
        this.canvasModel = canvasModel;
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
