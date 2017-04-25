package com.uncle2000.androidcommonutils.views.chart.base.coordinate.axis;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.ColorInt;
import android.util.SparseArray;

import com.uncle2000.androidcommonutils.views.chart.base.Utils;
import com.uncle2000.androidcommonutils.views.chart.base.coordinate.Anchor;
import com.uncle2000.androidcommonutils.views.chart.base.coordinate.element.CoorAxisElement;
import com.uncle2000.androidcommonutils.views.chart.base.coordinate.element.ElementModel;

/**
 * Created by 2000 on 2017/4/20.
 */

public class CoorAxis {

    private AxisModel axisModel;
    private CoorAxisElement coorAxisElement;

    public CoorAxis(AxisModel axisModel) {
        this.axisModel = axisModel;
        if (null != axisModel.geteModels()) {
            coorAxisElement = new CoorAxisElement(axisModel.geteModels());
        } else if (null != axisModel.geteModel()) {
            coorAxisElement = new CoorAxisElement(axisModel.geteModel());
        }
    }

    /**
     * x1 y1 x2 y2
     * -----------
     * 0  1  2  3
     * 4  5  6  7
     * 8  9  10 11
     *
     * @param canvas
     */
    public void draw(Canvas canvas) {
        float[] pts;
        if (axisModel.isShowArraw()) {
            pts = new float[12];
        } else {
            pts = new float[4];
        }
        /*起点永远都是锚点*/
        pts[0] = axisModel.getAnchor().x;
        pts[1] = axisModel.getAnchor().y;
        if (axisModel.getAngle() % 90 == 0) {
            switch (axisModel.getAngle() % 360) {
                case 0:
                    pts[2] = axisModel.getAnchor().x;
                    pts[3] = axisModel.getAnchor().y - axisModel.getLength();
                    if (axisModel.isShowArraw()) {
                        pts[6] = pts[2] - axisModel.getArrawLessL();
                        pts[7] = pts[3] + axisModel.getArrawLargerL();
                        pts[10] = pts[2] + axisModel.getArrawLessL();
                        pts[11] = pts[3] + axisModel.getArrawLargerL();
                    }
                    break;
                case 90:
                    pts[2] = axisModel.getAnchor().x + axisModel.getLength();
                    pts[3] = axisModel.getAnchor().y;
                    if (axisModel.isShowArraw()) {
                        pts[6] = pts[2] - axisModel.getArrawLargerL();
                        pts[7] = pts[3] - axisModel.getArrawLessL();
                        pts[10] = pts[2] - axisModel.getArrawLargerL();
                        pts[11] = pts[3] + axisModel.getArrawLessL();
                    }
                    break;
                case 180:
                    pts[2] = axisModel.getAnchor().x;
                    pts[3] = axisModel.getAnchor().y + axisModel.getLength();
                    if (axisModel.isShowArraw()) {
                        pts[6] = pts[2] - axisModel.getArrawLessL();
                        pts[7] = pts[3] - axisModel.getArrawLargerL();
                        pts[10] = pts[2] + axisModel.getArrawLessL();
                        pts[11] = pts[3] - axisModel.getArrawLargerL();
                    }
                    break;
                case 270:
                    pts[2] = axisModel.getAnchor().x - axisModel.getLength();
                    pts[3] = axisModel.getAnchor().y;
                    if (axisModel.isShowArraw()) {
                        pts[6] = pts[2] + axisModel.getArrawLargerL();
                        pts[7] = pts[3] - axisModel.getArrawLessL();
                        pts[10] = pts[2] + axisModel.getArrawLargerL();
                        pts[11] = pts[3] + axisModel.getArrawLessL();
                    }
                    break;
            }
            if (axisModel.isShowArraw()) {
                pts[4] = pts[2];
                pts[5] = pts[3];
                pts[8] = pts[2];
                pts[9] = pts[3];
            }
        } else {
            Point endP = Utils.getPoint(axisModel.getAnchor().getOrigin(), axisModel.getAngle(), axisModel.getLength());
            pts[2] = endP.x;
            pts[3] = endP.y;
            if (axisModel.isShowArraw()) {
                pts[4] = pts[8] = endP.x;
                pts[5] = pts[9] = endP.y;
                Point arrawP1 = Utils.getPoint(endP, axisModel.getAngle() - axisModel.getArrawAngle() + 180, axisModel.getArrawLargerL());
                Point arrawP2 = Utils.getPoint(endP, axisModel.getAngle() + axisModel.getArrawAngle() + 180, axisModel.getArrawLargerL());
                pts[6] = arrawP1.x;
                pts[7] = arrawP1.y;
                pts[10] = arrawP2.x;
                pts[11] = arrawP2.y;
            }
        }

        if (null != coorAxisElement) {
            coorAxisElement.draw(canvas);
        }
        canvas.drawLines(pts, axisModel.getAxisPaint());
    }

}
