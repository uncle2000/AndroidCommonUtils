//package com.uncle2000.androidcommonutils.views.chart.model;
//
//import android.content.Context;
//import android.graphics.Point;
//import android.support.annotation.NonNull;
//import android.support.annotation.Size;
//
//import com.uncle2000.androidcommonutils.uitls.equipment.ScreenUtils;
//import com.uncle2000.androidcommonutils.views.chart.utils.AdjustData;
//
//import java.util.List;
//
///**
// * Created by 2000 on 2017/5/2.
// */
//
//public class CanvasModel {
//    public int width;
//    public int height;
//    public float minRangeX, maxRangeX, minRangeY, maxRangeY;
//    public int lPadding, tPadding, rPadding, bPadding;
//    protected int screenW, screenH;
//
//    public CanvasModel(Context context) {
//        this(context, 1, 1);
//    }
//
//    public CanvasModel(Context context, float xScale, float yScale) {
//        init(context, xScale, yScale);
//    }
//
//    private void init(@NonNull Context context,
//                      float xScale, float yScale) {
//        screenW = ScreenUtils.getScreenWidth(context);
//        screenH = ScreenUtils.getScreenHeight(context);
//        if (screenW * screenH <= 0) {
//            throw new ExceptionInInitializerError();
//        }
//        if (xScale * yScale <= 0) {
//            throw new ExceptionInInitializerError();
//        }
//    }
//
//    public int getWarpWidth() {
//        lPadding = rPadding = 50;
//        width = screenW;
//        minRangeX = lPadding;
//        maxRangeX = width - rPadding;
//        return width;
//    }
//
//    public int getWarpHeight() {
//        tPadding = bPadding = 50;
//        height = 600;
//        minRangeY = tPadding;
//        maxRangeY = height - bPadding;
//        return height;
//    }
//}
