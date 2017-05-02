package com.uncle2000.androidcommonutils.views.chart.datalooks;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.support.annotation.NonNull;

import com.uncle2000.androidcommonutils.views.chart.RangeModel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 2000 on 2017/4/25.
 */

public class DashLine extends Points {
//    int phase = 0;

    public DashLine(RangeModel rangeModel) {
        super(rangeModel);
    }

    public DashLine(RangeModel rangeModel, Paint paint) {
        super(rangeModel, paint);
    }

    private void init() {
        //设置画直线格式
        paint.setStyle(Paint.Style.STROKE);
        //设置虚线效果
        paint.setPathEffect(new DashPathEffect(new float[]{25, 5}, 0));
        paint.setStrokeWidth(3f);
//        saP = adjustData2Sa(pts);
    }

    @Override
    public void draw(Canvas canvas) {
        for (Path p : toDash(rangeModel.list, 50, 650)) {
            canvas.drawPath(p, paint);
        }
    }

    /**
     * 画虚线
     * 这里的虚线并不是指多个点相链接，而是指每个点和X轴Y轴的法线
     *
     * @param sa
     * @return
     */
    private   List<Path> toDash(List<Point> sa, int minTableX, int maxTableY) {
        List<Path> saP = new ArrayList<>();
        Path path = new Path();
        for (int i = 0; i < sa.size() * 2; i++) {
            int loc = new BigDecimal(i / 2).setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
            if (i % 2 == 0) {
                path.moveTo(minTableX, sa.get(loc).y);
            } else {
                path.moveTo(sa.get(loc).x, maxTableY);
            }
            path.lineTo(sa.get(loc).x, sa.get(loc).y);
            saP.add(path);
        }
        return saP;
    }
}
