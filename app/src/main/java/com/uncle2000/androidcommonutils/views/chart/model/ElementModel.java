package com.uncle2000.androidcommonutils.views.chart.model;

import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.ColorInt;
import android.support.annotation.Size;
import android.util.SparseArray;

import java.util.List;

/**
 * Created by 2000 on 2017/4/21.
 */

public class ElementModel {
    private float[] line;
    private String text;

    public ElementModel() {
        line = new float[4];
    }

    public float[] getLine() {
        return line;
    }

    public void setLine(float... line) {
        this.line = line;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
