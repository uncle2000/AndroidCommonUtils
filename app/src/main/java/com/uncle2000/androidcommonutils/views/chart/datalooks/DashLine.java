package com.uncle2000.androidcommonutils.views.chart.datalooks;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by 2000 on 2017/4/25.
 */

public class DashLine extends Points<List<Path>> {
    int phase = 0;

    public DashLine(@NonNull List<Path> listP) {
        this(listP, null);
    }

    public DashLine(@NonNull List<Path> listP, Paint paint) {
        super(listP, paint);
        init();
    }

    private void init() {
        //设置画直线格式
        paint.setStyle(Paint.Style.STROKE);
        //设置虚线效果
        paint.setPathEffect(new DashPathEffect(new float[]{25,5}, phase));
        paint.setStrokeWidth(3f);
//        saP = adjustData2Sa(pts);
    }

    @Override
    public void draw(Canvas canvas) {
        for (Path p : (List<Path>) t) {
            canvas.drawPath(p, paint);
        }
    }

}
