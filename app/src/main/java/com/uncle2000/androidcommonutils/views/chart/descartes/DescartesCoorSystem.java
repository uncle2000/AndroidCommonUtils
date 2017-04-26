package com.uncle2000.androidcommonutils.views.chart.descartes;

import android.graphics.Canvas;
import android.graphics.Point;
import android.util.SparseArray;

import com.uncle2000.androidcommonutils.views.chart.descartes.coordinate.Anchor;
import com.uncle2000.androidcommonutils.views.chart.utils.Utils;
import com.uncle2000.androidcommonutils.views.chart.descartes.content.Curve;
import com.uncle2000.androidcommonutils.views.chart.descartes.content.Points;
import com.uncle2000.androidcommonutils.views.chart.descartes.coordinate.axis.AxisModel;
import com.uncle2000.androidcommonutils.views.chart.descartes.coordinate.axis.CoorAxis;
import com.uncle2000.androidcommonutils.views.chart.descartes.coordinate.element.ElementModel;

import static com.uncle2000.androidcommonutils.views.chart.utils.ChartData.chartDataCopy;

/**
 * 笛卡尔坐标系
 * 构建二维坐标系
 * x轴和y轴的位置由锚点(原点)确定
 * <p>
 * Created by 2000 on 2017/4/20.
 */

public class DescartesCoorSystem {
    private float minRangeX, maxRangeX, minRangeY, maxRangeY;
    private int lPadding, tPadding, rPadding, bPadding;
    private int lMargin, tMargin, rMargin, bMargin;
    private CoorAxis xCoorAxis, yCoorAxis;
    private Anchor anchor;
    private Points points;

    public DescartesCoorSystem(Anchor anchor) {
        this.anchor = anchor;
        xCoorAxis = new CoorAxis(mkElement(0, 90));
        yCoorAxis = new CoorAxis(mkElement(1, 0));

//        float[] ptsL = new float[(chartDataCopy.length - 1) * 4];
//
//        for (int i = 0; i < chartDataCopy.length - 1; i++) {
//            ptsL[i * 4] = chartDataCopy[i].x;
//            ptsL[i * 4 + 1] = chartDataCopy[i].y;
//            ptsL[i * 4 + 2] = chartDataCopy[i + 1].x;
//            ptsL[i * 4 + 3] = chartDataCopy[i + 1].y;
//        }
//        points = new Curve(ptsL);
    }

    public void draw(Canvas canvas) {
        drawAnchor(canvas);
        xCoorAxis.draw(canvas);
        yCoorAxis.draw(canvas);
//        points.draw(canvas);
    }

    private void drawAnchor(Canvas canvas) {
        canvas.drawText(anchor.getText(),
                anchor.x + anchor.getTextOffsetX(),
                anchor.y + anchor.getTextOffsetY(),
                anchor.getAnchorPaint());
    }


    private AxisModel mkElement(int normalDirection, int angle) {
        AxisModel axisModel = new AxisModel();
        SparseArray<Point> normalP = new SparseArray<>();
        normalP.put(0, Utils.getPoint(anchor.x, anchor.y, angle, 75));
        for (int i = 1; i < 12; i++) {
            if (i % 2 == 0) {
                normalP.put(i, Utils.getPoint(normalP.get(i - 2).x, normalP.get(i - 2).y, angle, 75));
            } else {
                normalP.put(i, Utils.getPoint(normalP.get(i - 1).x, normalP.get(i - 1).y, angle - 90 + normalDirection * 180, 500));
            }
        }

        SparseArray<String> texts = new SparseArray<>();
        for (int i = 0; i < 4; i++) {
            texts.put(i, "" + i * 5);
        }

        ElementModel e = new ElementModel();
        e.setPoints(normalP);
        e.setTexts(texts);
        if (normalDirection == 0) {
            e.setTextOffsetY(30);
        } else {
            e.setTextOffsetX(-30);
        }

        axisModel.setNormalP(normalP);
        axisModel.setAnchor(this.anchor);
        axisModel.seteModel(e);
        axisModel.setAngle(angle);
        return axisModel;
    }
}
