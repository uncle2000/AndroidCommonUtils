package com.uncle2000.androidcommonutils.views.chart.utils;

import android.graphics.Point;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Size;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 2000 on 2017/4/18.
 */

public class ConvertData {


    /**********************************************************************************************
     * a[] -> b[]
     **********************************************************************************************/
    /**
     * [a1,a2,a3]->[(span1,a1),(span2,a2),(span3,a3)]
     *
     * @param intA
     * @param span
     * @return
     */
    public static Point[] intA2PointA(@NonNull @Size(min = 1) int[] intA, int span) {
        Point[] pointA = new Point[intA.length];
        for (int i = 0; i < pointA.length; i++) {
            pointA[i] = new Point(span * (i + 1), intA[i]);
        }
        return pointA;
    }

    /**
     * [x1,y1,x2,y2]->[(x1,y1),(x2,y2)]
     *
     * @param intA
     * @return
     */
    public static Point[] intA2PointA(@NonNull @Size(min = 2, multiple = 2) int[] intA) {
        Point[] pointA = new Point[intA.length / 2];
        for (int i = 0; i < pointA.length; i++) {
            pointA[i] = new Point(intA[i * 2], intA[i * 2 + 1]);
        }
        return pointA;
    }

    public static float[] pointA2FloatA(@NonNull @Size(min = 1) Point[] pointA) {
        float[] floatA = new float[pointA.length * 2];
        for (int i = 0; i < pointA.length; i++) {
            floatA[i * 2 + 0] = pointA[i].x;
            floatA[i * 2 + 1] = pointA[i].y;
        }
        return floatA;
    }

    /**
     * [(x1,y1),(x2,y2)]->Rect(x1-span,y1,x1+span,y2)
     *
     * @param pointA
     * @param span
     * @return
     */
    public static Rect[] pointA2RectA(@NonNull @Size(min = 2) Point[] pointA, int span) {
        Rect[] rectA = new Rect[pointA.length];
        for (int i = 0; i < rectA.length - 1; i++) {
            rectA[i] = new Rect(
                    pointA[i + 0].x - span,
                    pointA[i + 0].y == pointA[i + 1].y ? pointA[i + 0].y - 1 : Math.min(pointA[i + 0].y, pointA[i + 1].y),
                    pointA[i + 0].x + span,
                    pointA[i + 0].y == pointA[i + 1].y ? pointA[i + 0].y + 1 : Math.max(pointA[i + 0].y, pointA[i + 1].y)
            );
        }
        rectA[rectA.length - 1] = new Rect(
                pointA[pointA.length - 1].x - span,
                pointA[pointA.length - 1].y - 1,
                pointA[pointA.length - 1].x + span,
                pointA[pointA.length - 1].y + 1
        );

        return rectA;
    }

    /**
     * [(x1,y1),(x2,y2)]->Rect(x1,y1.x2.y2)
     *
     * @param pointA
     * @return
     */
    public static Rect[] pointA2RectA(@NonNull @Size(min = 2, multiple = 2) Point[] pointA) {
        Rect[] rectA = new Rect[pointA.length / 2];
        for (int i = 0; i < rectA.length; i++) {
            rectA[i] = new Rect(
                    pointA[i * 2 + 0].x,
                    pointA[i * 2 + 0].y,
                    pointA[i * 2 + 1].x,
                    pointA[i * 2 + 1].y
            );
        }
        return rectA;
    }

    /**
     * [x1,y1,x2,y2]->[(x1,y1),(x2,y2)]->Rect(x1,y1.x2.y2)
     * [x1,y1,x2,y2]->Recy(x1-span,y1,x1+span,y2)
     *
     * @param intA
     * @param span
     * @return
     */
    public static Rect[] intA2RectA(@NonNull @Size(min = 4, multiple = 4) int[] intA, int span) {
        if (span <= 0) {
            return pointA2RectA(intA2PointA(intA));
        } else {
            Rect[] rectA = new Rect[intA.length / 4];
            for (int i = 0; i < rectA.length; i++) {
                rectA[i] = new Rect(
                        intA[i * 4 + 0] - span,
                        intA[i * 4 + 1],
                        intA[i * 4 + 0] + span,
                        intA[i * 4 + 3]
                );
            }
            return rectA;
        }
    }

    /**********************************************************************************************
     * a<> -> b<>
     **********************************************************************************************/
    public static List<Point> intL2PointL(@NonNull @Size(min = 1) List<Integer> intL, int span) {
        List<Point> pointL = new ArrayList<>();
        for (int i = 0; i < intL.size(); i++) {
            Point p = new Point(span * (i + 1), intL.get(i));
            pointL.add(p);
        }
        return pointL;
    }

    public static List<Point> intL2PointL(@NonNull @Size(min = 2, multiple = 2) List<Integer> intL) {
        List<Point> pointL = new ArrayList<>();
        for (int i = 0; i < intL.size() / 2; i++) {
            Point p = new Point(intL.get(i), intL.get(i + 1));
            pointL.add(p);
        }
        return pointL;
    }

    public static List<Rect> pointL2RectL(@NonNull @Size(min = 2) List<Point> pointL, int span) {
        List<Rect> rectL = new ArrayList<>();
        for (int i = 0; i < pointL.size() - 1; i++) {
            Rect r = new Rect(
                    pointL.get(i).x - span,
                    pointL.get(i).y,
                    pointL.get(i).x + span,
                    pointL.get(i + 1).y
            );
            rectL.add(r);
        }
        return rectL;
    }

    public static List<Rect> pointL2RectL(@NonNull @Size(min = 2, multiple = 2) List<Point> pointL) {
        List<Rect> rectL = new ArrayList<>();
        for (int i = 0; i < pointL.size() / 2; i++) {
            Rect r = new Rect(
                    pointL.get(i * 2).x,
                    pointL.get(i * 2).y,
                    pointL.get(i * 2 + 1).x,
                    pointL.get(i * 2 + 1).y
            );
            rectL.add(r);
        }
        return rectL;
    }

    public static List<Rect> intL2RectL(@NonNull @Size(min = 4, multiple = 4) List<Integer> intL, int span) {
        if (span <= 0) {
            return pointL2RectL(intL2PointL(intL));
        } else {
            List<Rect> rectL = new ArrayList<>();
            for (int i = 0; i < intL.size() / 4; i++) {
                Rect r = new Rect(
                        intL.get(i * 4 + 0),
                        intL.get(i * 4 + 1),
                        intL.get(i * 4 + 2),
                        intL.get(i * 4 + 3)
                );
                rectL.add(r);
            }
            return rectL;
        }
    }
}
