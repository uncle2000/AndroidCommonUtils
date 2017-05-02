package com.uncle2000.androidcommonutils.views.chart.datalooks;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.util.SparseArray;

import com.uncle2000.androidcommonutils.views.chart.RangeModel;

/**
 * Created by 2000 on 2017/4/25.
 */

public class DataArea extends Points {
    Rect area, pArea;

    public DataArea(RangeModel rangeModel) {
        super(rangeModel);
    }

    public DataArea(RangeModel rangeModel, Paint paint) {
        super(rangeModel, paint);
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
