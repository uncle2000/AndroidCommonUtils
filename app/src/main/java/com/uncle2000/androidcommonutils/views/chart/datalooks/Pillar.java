package com.uncle2000.androidcommonutils.views.chart.datalooks;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.util.SparseArray;

import java.util.ArrayList;
import java.util.List;

/**
 * 柱状
 * Created by 2000 on 2017/4/25.
 */

public class Pillar extends Points<List<Rect>> {
    int pillarW = 5;

    public Pillar(@NonNull List<Rect> listR) {
        this(listR, null);
    }

    public Pillar(@NonNull List<Rect> listR, Paint paint) {
        super(listR, paint);
    }

    private void init() {
        paint.setStyle(Paint.Style.STROKE);
//        saR = adjustData2Sa(pts);
    }

    @Override
    public void draw(Canvas canvas) {
        for (Rect r : (List<Rect>)t) {
            canvas.drawRect(r, paint);
        }
    }

}
