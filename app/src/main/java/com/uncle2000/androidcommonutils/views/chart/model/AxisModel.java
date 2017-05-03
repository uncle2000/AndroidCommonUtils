package com.uncle2000.androidcommonutils.views.chart.model;

import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.NonNull;

import com.uncle2000.androidcommonutils.views.chart.utils.Utils;

import java.util.List;

/**
 * Created by 2000 on 2017/5/3.
 */

public class AxisModel {
    private Anchor anchor;
    public List<ElementModel> list;
    private ArrawModel arrawModel;
    public Paint paint = new Paint();
    public int length = 600;
    public int angle;
    public float[] line;
    public int offset;

    public AxisModel(@NonNull Anchor anchor, int angle) {
        this(anchor, angle, null);
    }

    public AxisModel(@NonNull Anchor anchor, int angle, ArrawModel arrawModel) {
        this.anchor = anchor;
        this.angle = angle;
        this.arrawModel = arrawModel;
        if (arrawModel == null) {
            line = new float[4];
        } else {
            line = new float[12];
        }
        paint.setStrokeWidth(2f);

        mkLine(line, arrawModel, null != arrawModel);
    }

    private void mkLine(float[] line, ArrawModel arrawModel, boolean showArraw) {
        /*起点永远都是锚点*/
        line[0] = anchor.x;
        line[1] = anchor.y;
        if (angle % 90 == 0) {
            switch (angle % 360) {
                case 0:
                    line[1] -= offset;
                    line[2] = anchor.x;
                    line[3] = anchor.y - length;
                    if (showArraw) {
                        line[6] = line[2] - arrawModel.getArrawLessL();
                        line[7] = line[3] + arrawModel.getArrawLargerL();
                        line[10] = line[2] + arrawModel.getArrawLessL();
                        line[11] = line[3] + arrawModel.getArrawLargerL();
                    }
                    break;
                case 90:
                    line[0] -= offset;
                    line[2] = anchor.x + length;
                    line[3] = anchor.y;
                    if (showArraw) {
                        line[6] = line[2] - arrawModel.getArrawLargerL();
                        line[7] = line[3] - arrawModel.getArrawLessL();
                        line[10] = line[2] - arrawModel.getArrawLargerL();
                        line[11] = line[3] + arrawModel.getArrawLessL();
                    }
                    break;
                case 180:
                    line[1] += offset;
                    line[2] = anchor.x;
                    line[3] = anchor.y + length;
                    if (showArraw) {
                        line[6] = line[2] - arrawModel.getArrawLessL();
                        line[7] = line[3] - arrawModel.getArrawLargerL();
                        line[10] = line[2] + arrawModel.getArrawLessL();
                        line[11] = line[3] - arrawModel.getArrawLargerL();
                    }
                    break;
                case 270:
                    line[0] += offset;
                    line[2] = anchor.x - length;
                    line[3] = anchor.y;
                    if (showArraw) {
                        line[6] = line[2] + arrawModel.getArrawLargerL();
                        line[7] = line[3] - arrawModel.getArrawLessL();
                        line[10] = line[2] + arrawModel.getArrawLargerL();
                        line[11] = line[3] + arrawModel.getArrawLessL();
                    }
                    break;
            }
            if (showArraw) {
                line[4] = line[2];
                line[5] = line[3];
                line[8] = line[2];
                line[9] = line[3];
            }
        } else {
            Point endP = Utils.getPoint(anchor.x, anchor.y, angle, length);
            line[2] = endP.x;
            line[3] = endP.y;
            if (showArraw) {
                line[4] = line[8] = endP.x;
                line[5] = line[9] = endP.y;
                Point arrawP1 = Utils.getPoint(endP, angle - arrawModel.getArrawAngle() + 180, arrawModel.getArrawLargerL());
                Point arrawP2 = Utils.getPoint(endP, angle + arrawModel.getArrawAngle() + 180, arrawModel.getArrawLargerL());
                line[6] = arrawP1.x;
                line[7] = arrawP1.y;
                line[10] = arrawP2.x;
                line[11] = arrawP2.y;
            }
        }
    }

}
