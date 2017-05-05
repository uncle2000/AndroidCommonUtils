package com.uncle2000.androidcommonutils.views.chart.coorsys;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.support.annotation.Size;
import android.util.AttributeSet;

import com.uncle2000.androidcommonutils.views.chart.Constant;
import com.uncle2000.androidcommonutils.views.chart.chart.Charts;
import com.uncle2000.androidcommonutils.views.chart.model.Anchor;
import com.uncle2000.androidcommonutils.views.chart.model.DescartesOption;
import com.uncle2000.androidcommonutils.views.chart.utils.Utils;

import java.util.Set;

/**
 * 笛卡尔坐标系
 * 构建二维坐标系
 * x轴和y轴的位置由锚点(原点)确定
 * <p>
 * Created by 2000 on 2017/4/20.
 */

public class DescartesCoorSystem extends BlankCoorSystem {
    private Set<Charts> charts;
    private int xDir = -1, yDir = 1;
    private int xAngle, yAngle;

    public int xLength = Constant.DEFALT_AXIS_X_LENGHT;
    public int yLength = Constant.DEFALT_AXIS_Y_LENGHT;
    public boolean showArraw = true;
    public int xOffset = Constant.DEFALT_AXIS_OFFSET_X;
    public int yOffset = Constant.DEFALT_AXIS_OFFSET_Y;
    /*arraw*/
    public int arrawL = Constant.DEFALT_ARRAW_LENGTH;
    @Size(max = 360, min = 0)
    public int arrawAngle = Constant.DEFALT_ARRAW_ANGLE;

    public DescartesCoorSystem(Context context) {
        super(context);
    }

    public DescartesCoorSystem(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DescartesCoorSystem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public DescartesCoorSystem(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (null != charts)
            for (Charts c : charts) {
//                c.setPaint(paint);
                c.draw(canvas);
            }

        paint.setStrokeWidth(2f);
        judgeAngle();

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
        if (anchor.x < getWidth() / 2) {
            xAngle = 90;
            xDir = 1;
        } else if (anchor.x > getWidth() / 2) {
            xAngle = 270;
            xDir = -1;
        } else {
            xAngle = 90;
            xDir = 1;
            xLength /= 2;
            xOffset = xLength;
        }

        if (anchor.y < getHeight() / 2) {
            yAngle = 0;
            yDir = -1;
        } else if (anchor.y > getHeight() / 2) {
            yAngle = 180;
            yDir = 1;
        } else {
            yAngle = 180;
            yDir = 1;
            yLength /= 2;
            yOffset = yLength;
        }
    }

    DescartesOption dop;
    public void setDescartesOption(DescartesOption descartesOption) {
        this.anchor = new Anchor(descartesOption.anchor.x, descartesOption.anchor.y);
        this.dop = descartesOption;
        this.anchor = dop.anchor;
        this.charts = dop.charts;
    }
}
