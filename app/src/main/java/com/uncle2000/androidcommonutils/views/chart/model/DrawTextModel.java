package com.uncle2000.androidcommonutils.views.chart.model;

import android.graphics.Paint;
import android.support.annotation.ColorInt;
import android.util.SparseArray;

/**
 * Created by 2000 on 2017/5/3.
 */

public class DrawTextModel {

    /**
     * 显示的文字
     */
    private String text;
    private Paint textPaint;
    private float textSize = 36f;
    private int textRotateDegrees;
    @ColorInt
    private int textColor;
    private int textOffsetX;
    private int textOffsetY;

}
