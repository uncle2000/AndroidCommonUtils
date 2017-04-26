package com.uncle2000.androidcommonutils.views.chart.descartes;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;

import com.uncle2000.androidcommonutils.views.chart.descartes.coordinate.Anchor;
import com.uncle2000.androidcommonutils.views.chart.descartes.coordinate.axis.AxisModel;
import com.uncle2000.androidcommonutils.views.chart.descartes.coordinate.axis.CoorAxis;
import com.uncle2000.androidcommonutils.views.chart.utils.Utils;

/**
 * Created by 2000 on 2017/4/25.
 */

public class RadarCoorStstem {
    private final int offset;
    private CoorAxis[] coorAxis;
    private int coorAxisNum = 0;
    private Anchor anchor;
    private int angle;

    public RadarCoorStstem(int angle) {
        this(angle, 0);
    }

    public RadarCoorStstem(int angle, int offset) {
        this.angle = angle;
        this.offset = offset;
        anchor = new Anchor(500, 600);
        if (360 % angle != 0 || angle <= 0 || angle >= 360) {
            throw new NumberFormatException("angle must be divisible by 360°");
        }
        coorAxisNum = 360 / angle;
        coorAxis = new CoorAxis[coorAxisNum];
        for (int i = 0; i < coorAxisNum; i++) {
            coorAxis[i] = new CoorAxis(mkElement(i * angle + offset));
        }
    }

    public void draw(Canvas canvas) {
        drawAnchor(canvas);
        for (CoorAxis ca : coorAxis) {
            ca.draw(canvas);
        }
//        drawRing(canvas);
        drawRail(canvas);
    }

    private void drawAnchor(Canvas canvas) {
        canvas.drawText(anchor.getText(),
                anchor.x + anchor.getTextOffsetX(),
                anchor.y + anchor.getTextOffsetY(),
                anchor.getAnchorPaint());
    }

    private void drawRing(Canvas canvas) {
        anchor.getAnchorPaint().setStyle(Paint.Style.STROKE);
        anchor.getAnchorPaint().setStrokeWidth(3f);
        for (int i = 0; i < 5; i++) {
            canvas.drawCircle(
                    anchor.x,
                    anchor.y,
                    90 * (i + 1),
                    anchor.getAnchorPaint());
        }
    }

    private void drawRail(Canvas canvas) {
        anchor.getAnchorPaint().setStyle(Paint.Style.STROKE);
        anchor.getAnchorPaint().setStrokeWidth(3f);
        Path path = new Path();
        for (int j = 0; j < 5+1; j++) {
            Point point = Utils.getPoint(anchor.x, anchor.y, offset, 90 * j);
            path.moveTo(point.x, point.y);
            for (int i = 0; i < coorAxisNum+1; i++) {
                Point pointTo = Utils.getPoint(anchor.x, anchor.y, offset + i * angle, 90 * j);
                path.lineTo(pointTo.x, pointTo.y);
            }
            canvas.drawPath(path, anchor.getAnchorPaint());
        }
    }

    private AxisModel mkElement(int angle) {

        AxisModel axisModel = new AxisModel();
        axisModel.setAnchor(this.anchor);
        axisModel.setShowArraw(false);
        axisModel.setLength(450);
        axisModel.setAngle(angle);
        return axisModel;
    }
}
