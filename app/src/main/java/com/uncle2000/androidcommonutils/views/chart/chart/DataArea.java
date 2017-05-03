package com.uncle2000.androidcommonutils.views.chart.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.uncle2000.androidcommonutils.views.chart.model.CanvasModel;

/**
 * Created by 2000 on 2017/4/25.
 */

public class DataArea extends Points {
    Rect area, pArea;

    public DataArea(CanvasModel canvasModel) {
        super(canvasModel);
    }

    public DataArea(CanvasModel canvasModel, Paint paint) {
        super(canvasModel, paint);
    }

    private void init() {
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRect(area, paint);
        canvas.drawRect(pArea, paint);
    }

}
