//package com.uncle2000.androidcommonutils.views.chart.base.coordinate;
//
//import android.graphics.Canvas;
//import android.graphics.Point;
//
///**
// * Created by 2000 on 2017/4/20.
// */
//
//public class CoordinateSystem {
//
//    private float minRangeX, maxRangeX, minRangeY, maxRangeY;
//    private int lPadding, tPadding, rPadding, bPadding;
//    private int lMargin, tMargin, rMargin, bMargin;
//    private int xLine, yLine;
//    private int xLineLength, yLineLength;
//    private boolean xArrow, yArrow;
//    private Point anchor;
//
//
//    private void drawTable(Canvas canvas) {
//        float[] pts = {minTableX, minTableY, minTableX, maxTableY,
//                minTableX, maxTableY, maxTableX, maxTableY};
//        canvas.drawLines(pts, mTablepaint);
//
//        mTablepaint.setTextSize(38f);
//        canvas.drawText("anchor", anchor.x - 38f, anchor.y + 38f, mTablepaint);
//    }
//}
