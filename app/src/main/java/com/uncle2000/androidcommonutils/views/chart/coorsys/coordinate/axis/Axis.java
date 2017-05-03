package com.uncle2000.androidcommonutils.views.chart.coorsys.coordinate.axis;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.uncle2000.androidcommonutils.views.chart.model.AxisModel;
import com.uncle2000.androidcommonutils.views.chart.model.ElementModel;

import java.util.List;

/**
 * Created by 2000 on 2017/4/20.
 */

public class Axis {
    private AxisModel axisModel;
    private List<ElementModel> list;
    private Paint paint;

    public Axis(AxisModel axisModel) {
        this.axisModel = axisModel;
        this.list = axisModel.list;
        this.paint = axisModel.paint;
        paint.setTextSize(36f);
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
        canvas.drawLines(axisModel.line, axisModel.paint);
        if (null != list && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                canvas.drawLines(list.get(i).getLine(), paint);
                canvas.drawText(list.get(i).getText(),
                        list.get(i).getLine()[0],
                        list.get(i).getLine()[1], paint);
            }
        }
    }
}
