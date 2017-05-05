package com.uncle2000.androidcommonutils.views.chart.utils;

import android.graphics.Point;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Size;

import com.uncle2000.androidcommonutils.views.chart.model.Anchor;

import java.util.ArrayList;
import java.util.List;

/**
 * 把数据调整成适合图表自身的样子
 * Created by 2000 on 2017/4/26.
 */

public class AdjustData {

    public static List<Point> adjustData2Px(List<Point> orign, Anchor anchor, float scale) {
        return adjustData2Px(orign, anchor, scale, scale);
    }

    public static List<Point> adjustData2Px(@NonNull @Size(min = 1) List<Point> orign, Anchor anchor, float scaleX, float scaleY) {
        List<Point> temp = new ArrayList<>();
        for (Point p : orign) {
            temp.add(new Point(
                    (int) (anchor.x + (p.x - anchor.xMath) / scaleX),
                    (int) (anchor.y - (p.y - anchor.yMath) / scaleY)
            ));
        }
        return temp;
    }

    public static List<Point> reversalData(@NonNull @Size(min = 1) List<Point> orign, Anchor anchor,
                                           boolean reversalX, boolean reversalY) {
        if (!reversalX && !reversalY) {
            return orign;
        }
        int x, y;
        List<Point> temp = new ArrayList<>();
        for (Point p : orign) {
            if (reversalX) {
                y = 2 * anchor.y - p.y;
            } else {
                y = p.y;
            }
            if (reversalY) {
                x = 2 * anchor.x - p.x;
            } else {
                x = p.x;
            }
            temp.add(new Point(x, y));
        }
        return temp;
    }

    public static List<Point> px2MathPoint(@NonNull @Size(min = 1) List<Point> orign, Anchor anchor, float scaleX, float scaleY) {
        List<Point> temp = new ArrayList<>();
        for (Point p : orign) {
            temp.add(new Point(
                    (int) (anchor.xMath + scaleX * (p.x - anchor.x)),
                    (int) (anchor.yMath + scaleY * (anchor.y - p.y))
            ));
        }
        return temp;
    }

//    public List<Rect> adjustData2Sa(List<Point> sa) {
//
//        return saR;
//    }
//    private void drawDataPadding(Canvas canvas) {
//        mDatapaint.setStrokeWidth(1f);
//        float[] pts = new float[]{
//                minRangeX - lPadding, minRangeY - tPadding, maxRangeX + rPadding, minRangeY - tPadding,
//                maxRangeX + rPadding, minRangeY - tPadding, maxRangeX + rPadding, maxRangeY + bPadding,
//                maxRangeX + rPadding, maxRangeY + bPadding, minRangeX - lPadding, maxRangeY + bPadding,
//                minRangeX - lPadding, maxRangeY + bPadding, minRangeX - lPadding, minRangeY - tPadding,
//        };
//        canvas.drawLines(pts, mDatapaint);
//    }
//
//    private void drawDataArea(Canvas canvas) {
//        mDatapaint.setStrokeWidth(1f);
//        float[] pts = new float[]{
//                minRangeX, minRangeY, maxRangeX, minRangeY,
//                maxRangeX, minRangeY, maxRangeX, maxRangeY,
//                maxRangeX, maxRangeY, minRangeX, maxRangeY,
//                minRangeX, maxRangeY, minRangeX, minRangeY,
//        };
//        canvas.drawLines(pts, mDatapaint);
//    }






}
