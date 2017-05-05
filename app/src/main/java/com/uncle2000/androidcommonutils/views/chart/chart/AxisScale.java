package com.uncle2000.androidcommonutils.views.chart.chart;

import android.graphics.Canvas;

import com.uncle2000.androidcommonutils.views.chart.model.DescartesOption;
import com.uncle2000.androidcommonutils.views.chart.model.NormalOption;

/**
 * Created by 2000 on 2017/5/4.
 */

public class AxisScale extends Charts {


    public AxisScale(DescartesOption dop) {
        super(dop);
    }

    @Override
    public void draw(Canvas canvas) {

    }

//    private void mkElement(AxisModel model, int normalLength, int normalSpan) {
//        Point nPoint1 = Utils.getPoint(anchor.x, anchor.y, model.angle - 90, normalLength);
//        Point axisPoint2 = Utils.getPoint(anchor.x, anchor.y, model.angle, normalSpan);
//        int xDiff = Math.abs(axisPoint2.x - anchor.x);
//        int yDiff = Math.abs(axisPoint2.y - anchor.y);
//        int yOffset = 15;
//        int xDir = 1, yDir = 1;
//        switch (model.angle % 360) {
//            case 0:
//                yDir = -1;
//                break;
//            case 90:
//                xDir = 1;
//                break;
//            case 180:
//                yDir = 1;
//                break;
//            case 270:
//                xDir = -1;
//                break;
//        }
//
//        List<ElementModel> list = new ArrayList<>();
//        for (int i = 0; i < 7; i++) {
//            ElementModel m = new ElementModel();
//            if (model.angle % 180 == 0) {//x
//                m.setText("y" + i);
//            } else {
//                m.setText("x" + i);
//            }
//            if (xDir == 1 & yDir == -1) {
//                m.setLine(
//                        anchor.x + xDiff * i * xDir + yOffset,
//                        anchor.y + yDiff * i * yDir,
//                        nPoint1.x + xDiff * i * xDir + yOffset,
//                        nPoint1.y + yDiff * i * yDir);
//            } else {
//                m.setLine(anchor.x + xDiff * i * xDir, anchor.y + yDiff * i * yDir,
//                        nPoint1.x + xDiff * i * xDir, nPoint1.y + yDiff * i * yDir);
//            }
//            list.add(m);
//        }
//        model.list = list;
//    }
}
