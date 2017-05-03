package com.uncle2000.androidcommonutils.views.chart.coorsystem;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;

import com.uncle2000.androidcommonutils.views.chart.RangeModel;
import com.uncle2000.androidcommonutils.views.chart.coorsystem.Anchor;
import com.uncle2000.androidcommonutils.views.chart.coorsystem.BlankCoorSystem;
import com.uncle2000.androidcommonutils.views.chart.datalooks.ChartData;
import com.uncle2000.androidcommonutils.views.chart.coorsystem.coordinate.axis.AxisModel;
import com.uncle2000.androidcommonutils.views.chart.coorsystem.coordinate.axis.CoorAxis;
import com.uncle2000.androidcommonutils.views.chart.utils.Utils;

/**
 * Created by 2000 on 2017/4/25.
 */

public class RadarCoorStstem extends BlankCoorSystem {
    private int angle;
    private int offset;
    private int coorAxisNum;
    private CoorAxis[] coorAxis;

    public int span = 90;
    public int pointNum = 5;
    public Paint radarPaint;


    public RadarCoorStstem(RangeModel rangeModel, int angle) {
        this(rangeModel, angle, 0);
    }

    public RadarCoorStstem(RangeModel rangeModel, int angle, int offset) {
        super(rangeModel);
        this.angle = angle;
        this.offset = offset;

        if (360 % angle != 0 || angle <= 0 || angle >= 360) {
            throw new NumberFormatException("angle must be divisible by 360°");
        }

        coorAxisNum = 360 / angle;
        coorAxis = new CoorAxis[coorAxisNum];
        for (int i = 0; i < coorAxisNum; i++) {
            coorAxis[i] = new CoorAxis(mkElement(i * angle + offset));
        }
        radarPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        radarPaint.setStyle(Paint.Style.STROKE);
        radarPaint.setStrokeWidth(3f);
    }

    public void draw(Canvas canvas) {
        drawAnchor(canvas);
        for (CoorAxis ca : coorAxis) {
            ca.draw(canvas);
        }
        drawRing(canvas);
        drawRail(canvas);
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

    private void drawRail(Canvas canvas) {
        Path path = new Path();
        for (int j = 0; j < pointNum + 1; j++) {
            Point point = Utils.getPoint(anchor.x, anchor.y, offset, span * j);
            path.moveTo(point.x, point.y);
            for (int i = 0; i < coorAxisNum + 1; i++) {
                Point pointTo = Utils.getPoint(anchor.x, anchor.y, offset + i * angle, span * j);
                path.lineTo(pointTo.x, pointTo.y);
            }
            canvas.drawPath(path, radarPaint);
        }
    }

    private AxisModel mkElement(int angle) {
        AxisModel axisModel = new AxisModel();
        axisModel.setAnchor(this.anchor);
        axisModel.setShowArraw(false);
        axisModel.setAngle(angle);
        axisModel.setLength(450);
        return axisModel;
    }
}
