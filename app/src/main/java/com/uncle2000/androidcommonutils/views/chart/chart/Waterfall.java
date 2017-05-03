//package com.uncle2000.androidcommonutils.views.chart.datalooks;
//
//import android.graphics.Canvas;
//import android.graphics.Paint;
//import android.graphics.Rect;
//import android.support.annotation.NonNull;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * 瀑布图
// * Created by 2000 on 2017/4/25.
// */
//
//public class Waterfall extends Points<List<Rect>> {
//
//    public Waterfall(@NonNull List<Rect> listR) {
//        this(listR, null);
//        init();
//    }
//
//    public Waterfall(@NonNull List<Rect> listR, Paint paint) {
//        super(listR, paint);
//        init();
//    }
//
//    private void init() {
//        paint.setStyle(Paint.Style.STROKE);
//    }
//
//    @Override
//    public void draw(Canvas canvas) {
//        for (Rect r : (List<Rect>) t) {
//            canvas.drawRect(r, paint);
//        }
//    }
//
//}
