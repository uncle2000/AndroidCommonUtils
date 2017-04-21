package com.uncle2000.androidcommonutils.views.chart.base.coordinate;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.ColorInt;

/**
 * Created by 2000 on 2017/4/20.
 */

public class CoorAxis {
    /**
     * form anchor to dirrction
     * [0°↑:y- ,90°→:x+ ,180°↓:y+ ,270°←:x-]
     */
    private int direction;
    public int length = 200, offset;
    public boolean showArraw;
    private int arrawLessL = 8;
    private int arrawLargerL = 16;
    private CoorAxisElement coorAxisElement;
    @ColorInt
    private int color = 0x000000;

    private Anchor anchor;
    private Paint axisPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public CoorAxis(Anchor anchor, int direction) {
        this.anchor = anchor;
        this.direction = direction;
        axisPaint.setStrokeWidth(2f);
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
    public void drawAxis(Canvas canvas) {
        float[] pts;
        if (showArraw) {
            pts = new float[12];
        } else {
            pts = new float[4];
        }
        /*起点永远都是锚点*/
        pts[0] = anchor.x;
        pts[1] = anchor.y;
        if (direction % 90 == 0) {
            switch (direction % 360) {
                case 0:
                    pts[2] = anchor.x;
                    pts[3] = anchor.y - length;
                    if (showArraw) {
                        pts[6] = pts[2] - arrawLessL;
                        pts[7] = pts[3] + arrawLargerL;
                        pts[10] = pts[2] + arrawLessL;
                        pts[11] = pts[3] + arrawLargerL;
                    }
                    break;
                case 90:
                    pts[2] = anchor.x + length;
                    pts[3] = anchor.y;
                    if (showArraw) {
                        pts[6] = pts[2] - arrawLargerL;
                        pts[7] = pts[3] - arrawLessL;
                        pts[10] = pts[2] - arrawLargerL;
                        pts[11] = pts[3] + arrawLessL;
                    }
                    break;
                case 180:
                    pts[2] = anchor.x;
                    pts[3] = anchor.y + length;
                    if (showArraw) {
                        pts[6] = pts[2] - arrawLessL;
                        pts[7] = pts[3] - arrawLargerL;
                        pts[10] = pts[2] + arrawLessL;
                        pts[11] = pts[3] - arrawLargerL;
                    }
                    break;
                case 270:
                    pts[2] = anchor.x - length;
                    pts[3] = anchor.y;
                    if (showArraw) {
                        pts[6] = pts[2] + arrawLargerL;
                        pts[7] = pts[3] - arrawLessL;
                        pts[10] = pts[2] + arrawLargerL;
                        pts[11] = pts[3] + arrawLessL;
                    }
                    break;
            }
        }
        if (showArraw) {
            pts[4] = pts[2];
            pts[5] = pts[3];
            pts[8] = pts[2];
            pts[9] = pts[3];
        }
        canvas.drawLines(pts, axisPaint);
        if (null != coorAxisElement) {
            coorAxisElement.drawSelf(canvas);
        }
    }

    public CoorAxisElement getCoorAxisElement() {
        return coorAxisElement;
    }

    public void setCoorAxisElement(CoorAxisElement coorAxisElement) {
        this.coorAxisElement = coorAxisElement;
    }
}
