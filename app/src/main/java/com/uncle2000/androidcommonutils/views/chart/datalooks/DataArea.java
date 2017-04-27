package com.uncle2000.androidcommonutils.views.chart.datalooks;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.util.SparseArray;

/**
 * Created by 2000 on 2017/4/25.
 */

public class DataArea extends Points {
    Rect area, pArea;

    public DataArea(@NonNull float[] pts) {
        super(pts);
        init();
    }

    public DataArea(@NonNull float[] pts, Paint paint) {
        super(pts, paint);
        init();
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
