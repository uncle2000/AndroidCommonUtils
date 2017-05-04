package com.uncle2000.androidcommonutils.views.chart.coorsys;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;

import com.uncle2000.androidcommonutils.views.chart.model.ArrawModel;
import com.uncle2000.androidcommonutils.views.chart.model.AxisModel;
import com.uncle2000.androidcommonutils.views.chart.model.ChartOption;
import com.uncle2000.androidcommonutils.views.chart.utils.Utils;
import com.uncle2000.androidcommonutils.views.chart.coorsys.coordinate.axis.Axis;
import com.uncle2000.androidcommonutils.views.chart.model.ElementModel;

import java.util.ArrayList;
import java.util.List;

/**
 * 笛卡尔坐标系
 * 构建二维坐标系
 * x轴和y轴的位置由锚点(原点)确定
 * <p>
 * Created by 2000 on 2017/4/20.
 */

public class DescartesCoorSystem extends BlankCoorSystem {
    private Axis xAxis, yAxis;
    private AxisModel xModel, yModel;

    public DescartesCoorSystem(Context context, ChartOption chartOption) {
        super(context, chartOption);
        judgeDirection();

//        mkElement(xModel, 15, 80);
//        mkElement(yModel, 15, 50);

        xAxis = new Axis(xModel);
        yAxis = new Axis(yModel);
    }


    private void judgeDirection() {
        if (anchor.x <= getWidth()/ 2) {
            xModel = new AxisModel(anchor, 90, new ArrawModel());
        } else {
            xModel = new AxisModel(anchor, 270);
        }

        if (anchor.y > getWidth() / 2) {
            yModel = new AxisModel(anchor, 180);
        } else {
            yModel = new AxisModel(anchor, 0);
        }

        yModel.offset = 15;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        xAxis.draw(canvas);
        yAxis.draw(canvas);
    }

    private void mkElement(AxisModel model, int normalLength, int normalSpan) {
        Point nPoint1 = Utils.getPoint(anchor.x, anchor.y, model.angle - 90, normalLength);
        Point axisPoint2 = Utils.getPoint(anchor.x, anchor.y, model.angle, normalSpan);
        int xDiff = Math.abs(axisPoint2.x - anchor.x);
        int yDiff = Math.abs(axisPoint2.y - anchor.y);
        int yOffset = 15;
        int xDir = 1, yDir = 1;
        switch (model.angle % 360) {
            case 0:
                yDir = -1;
                break;
            case 90:
                xDir = 1;
                break;
            case 180:
                yDir = 1;
                break;
            case 270:
                xDir = -1;
                break;
        }

        List<ElementModel> list = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            ElementModel m = new ElementModel();
            if (model.angle % 180 == 0) {//x
                m.setText("y" + i);
            } else {
                m.setText("x" + i);
            }
            if (xDir == 1 & yDir == -1) {
                m.setLine(
                        anchor.x + xDiff * i * xDir + yOffset,
                        anchor.y + yDiff * i * yDir,
                        nPoint1.x + xDiff * i * xDir + yOffset,
                        nPoint1.y + yDiff * i * yDir);
            } else {
                m.setLine(anchor.x + xDiff * i * xDir, anchor.y + yDiff * i * yDir,
                        nPoint1.x + xDiff * i * xDir, nPoint1.y + yDiff * i * yDir);
            }
            list.add(m);
        }
        model.list = list;
    }
}
