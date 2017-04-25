package com.uncle2000.androidcommonutils.views.chart.base.coordinate;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
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
    private Paint coorPaint;

    public DescartesCoorSystem() {
        anchor = new Anchor(100, 600);
        xCoorAxis = new CoorAxis(anchor, 90);
        yCoorAxis = new CoorAxis(anchor, 0);
        yCoorAxis.length = 500;
        xCoorAxis.length = 800;

        yCoorAxis.mkElement(1);
        xCoorAxis.mkElement(0);


        xCoorAxis.showArraw = yCoorAxis.showArraw = true;

        coorPaint = new Paint();
        coorPaint.setAntiAlias(true);
        coorPaint.setColor(Color.BLACK);
        coorPaint.setStrokeWidth(1.2f);
        coorPaint.setTextSize(38f);

    }

    public void drawCoorSystem(Canvas canvas) {
        drawAnchor(canvas);
        xCoorAxis.drawAxis(canvas);
        yCoorAxis.drawAxis(canvas);
    }

    private void drawAnchor(Canvas canvas) {
        canvas.drawText("anchor", anchor.x - 38f, anchor.y + 38f, coorPaint);
    }
}
