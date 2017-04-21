package com.uncle2000.androidcommonutils.views.chart.base.coordinate;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.ColorInt;
import android.util.SparseArray;

import com.uncle2000.androidcommonutils.views.chart.base.Utils;

/**
 * Created by 2000 on 2017/4/20.
 */

public class CoorAxis {
    /**
     * form anchor to dirrction
     * [0°↑:y- ,90°→:x+ ,180°↓:y+ ,270°←:x-]
     */
    private int angle;
    public int length = 200, offset;
    public boolean showArraw;
    private int arrawLessL = 8;
    private int arrawLargerL = 50;
    private int arrawAngle = 38;
    private CoorAxisElement coorAxisElement;
    @ColorInt
    private int color = 0x000000;

    private final Anchor anchor;
    private Paint axisPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    CoorAxisElement cae;//= new CoorAxisElement(anchor, angle, i * 75);

    SparseArray<Point> normalP;

    public CoorAxis(Anchor anchor, int angle) {
        this.anchor = anchor;
        this.angle = angle;
        axisPaint.setStrokeWidth(2f);
    }

    public void mkElement(int normalDirection) {
        normalP = new SparseArray<>();
        normalP.put(0, Utils.getPoint(anchor.x, anchor.y, this.angle, 75));
        for (int i = 1; i < 12; i++) {
            if (i % 2 == 0) {
                normalP.put(i, Utils.getPoint(normalP.get(i - 2).x, normalP.get(i - 2).y, this.angle, 75));
            } else {
                normalP.put(i, Utils.getPoint(normalP.get(i - 1).x, normalP.get(i - 1).y, this.angle - 90 + normalDirection * 180, 500));
            }
        }

        SparseArray texts = new SparseArray();
        for (int i = 0; i < 4; i++) {
            texts.put(i, "" + i * 5);
        }
        ElementModel e = new ElementModel();
        e.setPoints(normalP);
        e.setTexts(texts);
        cae = new CoorAxisElement(e);
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
        if (angle % 90 == 0) {
            switch (angle % 360) {
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
            if (showArraw) {
                pts[4] = pts[2];
                pts[5] = pts[3];
                pts[8] = pts[2];
                pts[9] = pts[3];
            }
        } else {
            Point endP = Utils.getPoint(anchor.getOrigin(), angle, length);
            pts[2] = endP.x;
            pts[3] = endP.y;
            if (showArraw) {
                pts[4] = pts[8] = endP.x;
                pts[5] = pts[9] = endP.y;
                Point arrawP1 = Utils.getPoint(endP, angle - arrawAngle + 180, arrawLargerL);
                Point arrawP2 = Utils.getPoint(endP, angle + arrawAngle + 180, arrawLargerL);
                pts[6] = arrawP1.x;
                pts[7] = arrawP1.y;
                pts[10] = arrawP2.x;
                pts[11] = arrawP2.y;
            }
        }

        if (null != cae) {
            cae.draw(canvas);
        }
        canvas.drawLines(pts, axisPaint);
    }

    public CoorAxisElement getCoorAxisElement() {
        return coorAxisElement;
    }

    public void setCoorAxisElement(CoorAxisElement coorAxisElement) {
        this.coorAxisElement = coorAxisElement;
    }
}
