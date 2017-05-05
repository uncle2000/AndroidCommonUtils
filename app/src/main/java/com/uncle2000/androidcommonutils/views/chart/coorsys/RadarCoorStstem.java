package com.uncle2000.androidcommonutils.views.chart.coorsys;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;

import com.uncle2000.androidcommonutils.views.chart.model.NormalOption;
import com.uncle2000.androidcommonutils.views.chart.model.RadarOption;
import com.uncle2000.androidcommonutils.views.chart.utils.Utils;

/**
 * Created by 2000 on 2017/4/25.
 */

public class RadarCoorStstem extends BlankCoorSystem {
    private int angle;
    private int offset;

    public int span = 90;
    public int pointNum = 5;
    public Paint radarPaint;

    RadarOption radarOption;

    public RadarCoorStstem(Context context) {
        super(context);
    }

    public RadarCoorStstem(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RadarCoorStstem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public RadarCoorStstem(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    public void draw(Canvas canvas) {
        drawAnchor(canvas);
        for (Path p : radarOption.list) {
            canvas.drawPath(p, paint);
        }

        drawRing(canvas);
//        drawRail(canvas);
    }

    private void drawAnchor(Canvas canvas) {
        canvas.drawText(anchor.getText(),
                anchor.x + anchor.getTextOffsetX(),
                anchor.y + anchor.getTextOffsetY(),
                anchor.getAnchorPaint());
    }

    private void drawRing(Canvas canvas) {
        for (int i = 0; i < pointNum; i++) {
            canvas.drawCircle(
                    anchor.x,
                    anchor.y,
                    span * (i + 1),
                    radarPaint);
        }
    }

//    private void drawRail(Canvas canvas) {
//        Path path = new Path();
//        for (int j = 0; j < pointNum + 1; j++) {
//            Point point = Utils.getPoint(anchor.x, anchor.y, offset, span * j);
//            path.moveTo(point.x, point.y);
//            for (int i = 0; i < coorAxisNum + 1; i++) {
//                Point pointTo = Utils.getPoint(anchor.x, anchor.y, offset + i * angle, span * j);
//                path.lineTo(pointTo.x, pointTo.y);
//            }
//            canvas.drawPath(path, radarPaint);
//        }
//    }

//    private CoorSysModel mkElement(int angle) {
//        CoorSysModel axisModel = new CoorSysModel();
//        axisModel.setAnchor(this.anchor);
//        axisModel.setShowArraw(false);
//        axisModel.setAngle(angle);
//        axisModel.setLength(450);
//        return axisModel;
//    }
}
