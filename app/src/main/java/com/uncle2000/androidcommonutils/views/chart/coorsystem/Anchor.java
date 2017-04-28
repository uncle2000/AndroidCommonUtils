package com.uncle2000.androidcommonutils.views.chart.coorsystem;

import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.ColorInt;

/**
 * 锚点 坐标系的原点
 * Created by 2000 on 2017/4/20.
 */

public class Anchor {
    /**
     * 锚点的（x,y）表现形式
     * 这是屏幕上的点，并不是数学坐标系的原点
     */
    public int x = 200, y = 600;

    /**
     * 锚点在屏幕上的坐标
     */
    public Point screenCoor;
    /**
     * 数学坐标轴的原点
     * 显示文本和计算用
     */
    public Point mathCoor = new Point();

    /**
     * 锚点的文字偏移，如果不偏移文字会画到原点上
     */
    private int textOffsetX = -10, textOffsetY = 30;
    private float textSize = 38f;
    private String text;
    @ColorInt
    private int textColor = 0xff000000;
    private Paint anchorPaint;

    public Anchor() {
        this(null);
    }

    public Anchor(int x, int y) {
        this(new Point(x, y));
    }

    public Anchor(Point screenCoor) {
        if (null == screenCoor) {
            this.screenCoor = new Point(x, y);
        } else {
            this.x = screenCoor.x;
            this.y = screenCoor.y;
            this.screenCoor = screenCoor;
        }
        text = "(" + mathCoor.x + "," + mathCoor.y + ")";
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
