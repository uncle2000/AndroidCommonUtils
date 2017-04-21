package com.uncle2000.androidcommonutils.views.chart.base.coordinate;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.util.SparseArray;

/**
 * Created by 2000 on 2017/4/20.
 */

public class CoorAxisElement {
    private boolean bardian = false;
    private SparseArray<ElementModel> eModels;
    private ElementModel eModel;
    private float[] pts;
    private SparseArray<String> tests;

    public CoorAxisElement(@NonNull ElementModel eModel) {
        bardian = false;
        this.eModel = eModel;
        pts = new float[eModel.getPoints().size() * 2];
        tests = eModel.adjustTexts();
        for (int i = 0; i < eModel.getPoints().size(); i++) {
            pts[i * 2 + 0] = eModel.getPoints().get(i).x;
            pts[i * 2 + 1] = eModel.getPoints().get(i).y;
        }
    }

    public CoorAxisElement(@NonNull SparseArray<ElementModel> eModels) {
        bardian = true;
        this.eModels = eModels;
        pts = new float[eModels.size() * 4];
        tests = new SparseArray<>();
        for (int i = 0; i < eModels.size(); i++) {
            pts[i * 4 + 0] = eModels.get(i).getPointF().x;
            pts[i * 4 + 1] = eModels.get(i).getPointF().y;
            pts[i * 4 + 2] = eModels.get(i).getPointT().x;
            pts[i * 4 + 3] = eModels.get(i).getPointT().y;
            tests.put(i, eModels.get(i).getText());
        }
    }

    public void draw(Canvas canvas) {
        drawNormal(canvas);
        drawKey(canvas);
    }

    private void drawNormal(Canvas canvas) {
        if (bardian) {
            for (int i = 0; i < eModels.size(); i++) {
                ElementModel e = eModels.get(i);
                canvas.drawLine(
                        e.getPointF().x, e.getPointF().y, e.getPointT().x, e.getPointT().y,
                        e.getNormalPaint());
            }
        } else {
            canvas.drawLines(pts, eModel.getNormalPaint());
        }
    }

    private void drawKey(Canvas canvas) {
        if (tests == null)
            return;
        for (int i = 0; i < tests.size(); i++) {
            if (bardian) {
                ElementModel e = eModels.get(i);
                canvas.drawTextOnPath(tests.get(i),
                        null,
                        e.getPointF().x,
                        e.getPointF().y,
                        e.getTextPaint());
            } else {
                canvas.drawText(tests.get(i),
                        pts[i * 4 + 0],
                        pts[i * 4 + 1],
                        eModel.getTextPaint());

            }

        }
    }
}
