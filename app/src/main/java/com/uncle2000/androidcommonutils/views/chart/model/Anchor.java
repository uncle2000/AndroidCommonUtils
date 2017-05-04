package com.uncle2000.androidcommonutils.views.chart.model;

import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.ColorInt;

import com.uncle2000.androidcommonutils.views.chart.Constant;

/**
 * 锚点 坐标系的原点
 * Created by 2000 on 2017/4/20.
 */

public class Anchor {
    public int x, y;
    public int xMath, yMath;
    private int textOffsetX = Constant.DEFALT_ANCHOR_TEXT_OFFSET_X;
    private int textOffsetY = Constant.DEFALT_ANCHOR_TEXT_OFFSET_Y;
    private float textSize = Constant.DEFALT_ANCHOR_TEXT_SIZE;
    private String text;
    @ColorInt
    private int textColor = 0xff000000;
    private Paint anchorPaint;

    public Anchor() {
        this(Constant.DEFALT_ANCHOR_X, Constant.DEFALT_ANCHOR_Y,
                Constant.DEFALT_ANCHOR_MATH_X, Constant.DEFALT_ANCHOR_MATH_Y);
    }

    public Anchor(int x, int y) {
        this(x, y, Constant.DEFALT_ANCHOR_MATH_X, Constant.DEFALT_ANCHOR_MATH_Y);
    }

    public Anchor(int x, int y, int xMath, int yMath) {
        this.x = x;
        this.y = y;
        this.xMath = xMath;
        this.yMath = yMath;

        text = "(" + xMath + "," + yMath + ")";
    }


    public int getTextOffsetX() {
        return textOffsetX;
    }

    public void setTextOffsetX(int textOffsetX) {
        this.textOffsetX = textOffsetX;
    }

    public int getTextOffsetY() {
        return textOffsetY;
    }

    public void setTextOffsetY(int textOffsetY) {
        this.textOffsetY = textOffsetY;
    }

    public float getTextSize() {
        return textSize;
    }

    public void setTextSize(float textSize) {
        this.textSize = textSize;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public Paint getAnchorPaint() {
        if (null == anchorPaint) {
            anchorPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            anchorPaint.setStrokeWidth(1.2f);
            anchorPaint.setColor(textColor);
            anchorPaint.setTextSize(textSize);
            anchorPaint.setTextAlign(Paint.Align.RIGHT);
        }
        return anchorPaint;
    }

    public void setAnchorPaint(Paint anchorPaint) {
        this.anchorPaint = anchorPaint;
    }


}
