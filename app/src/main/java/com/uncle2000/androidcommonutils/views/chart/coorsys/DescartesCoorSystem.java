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
    private int xDir = 1, yDir = 1;
    private int xAngle, yAngle;
    public int xLength = 800, yLength = 500;
    public boolean showArraw = true;
    public int xOffset = 15, yOffset = 15;
    /*arraw*/
    public int arrawL = 30;
    public int arrawAngle = 30;

    public DescartesCoorSystem(Context context) {
        super(context);
    }

    public DescartesCoorSystem(Context context, ChartOption chartOption) {
        super(context, chartOption);
        paint.setStrokeWidth(2f);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        judgeAngle();
        xDir = judgeDirection2(xAngle);
        yDir = judgeDirection2(yAngle);

        canvas.drawLines(new float[]{
                //x axis
                anchor.x - xOffset * xDir, anchor.y,
                anchor.x + xLength * xDir, anchor.y,
                //y axis
                anchor.x, anchor.y + yOffset * yDir,
                anchor.x, anchor.y - yLength * yDir,
        }, paint);

        if (showArraw) {
            Point xArraw1 = Utils.getPoint(anchor.x + xLength * xDir, anchor.y, xAngle - arrawAngle + 180, arrawL);
            Point xArraw2 = Utils.getPoint(anchor.x + xLength * xDir, anchor.y, xAngle + arrawAngle + 180, arrawL);
            Point yArraw1 = Utils.getPoint(anchor.x, anchor.y - yLength * yDir, yAngle - arrawAngle, arrawL);
            Point yArraw2 = Utils.getPoint(anchor.x, anchor.y - yLength * yDir, yAngle + arrawAngle, arrawL);
            canvas.drawLines(new float[]{
                    anchor.x + xLength * xDir, anchor.y,
                    xArraw1.x, xArraw1.y,
                    anchor.x + xLength * xDir, anchor.y,
                    xArraw2.x, xArraw2.y,
                    anchor.x, anchor.y - yLength * yDir,
                    yArraw1.x, yArraw1.y,
                    anchor.x, anchor.y - yLength * yDir,
                    yArraw2.x, yArraw2.y,
            }, paint);
        }
    }


    /**********************************************************************************************/

    private void judgeAngle() {
        if (anchor.x <= getWidth() / 2) {
            xAngle = 90;
        } else {
            xAngle = 270;
        }

        if (anchor.y > getWidth() / 2) {
            yAngle = 180;
        } else {
            yAngle = 0;
        }
    }

    private int judgeDirection2(int angle) {
        int dir = 0;
        switch (angle % 360) {
            case 0:
                dir = -1;
                break;
            case 90:
                dir = 1;
                break;
            case 180:
                dir = 1;
                break;
            case 270:
                dir = -1;
                break;
        }
        return dir;
    }
}
