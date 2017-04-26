package com.uncle2000.androidcommonutils.views.chart.descartes.coordinate.element;

import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.ColorInt;
import android.support.annotation.Size;
import android.util.SparseArray;

/**
 * Created by 2000 on 2017/4/21.
 */

public class ElementModel {
    /**
     * form->to
     */
    private Point pointF, pointT;
    private SparseArray<Point> points;

    /**
     * 显示的文字
     */
    private String text;
    private SparseArray<String> texts;
    private float textSize = 36f;
    private int textRotateDegrees;
    private Paint textPaint;
    @ColorInt
    private int textColor;
    private int textOffsetX;
    private int textOffsetY;

    /**
     * normal(法线)
     */
    private boolean showNormal;
    private Paint normalPaint;
    public int nSpanL = 75;
    private int nL = 20;
    private int nSpanOffset;
    private float thickness = 1.2f;
    @ColorInt
    private int normalColor = 0xff000000;

    public Point getPointF() {
        return pointF;
    }

    public void setPointF(Point pointF) {
        this.pointF = pointF;
    }

    public Point getPointT() {
        return pointT;
    }

    public void setPointT(Point pointT) {
        this.pointT = pointT;
    }

    public SparseArray<Point> getPoints() {
        return points;
    }

    public void setPoints(@Size(min = 2, multiple = 2) SparseArray<Point> points) {
        this.points = points;
    }

    public String getText() {
        if (null == text)
            return "";
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public SparseArray<String> getTexts() {
        return texts;
    }

    public void setTexts(SparseArray<String> texts) {
        this.texts = texts;
    }

    public float getTextSize() {
        return textSize;
    }

    public void setTextSize(float textSize) {
        this.textSize = textSize;
    }

    public int getTextRotateDegrees() {
        return textRotateDegrees;
    }

    public void setTextRotateDegrees(int textRotateDegrees) {
        this.textRotateDegrees = textRotateDegrees;
    }

    public Paint getTextPaint() {
        if (null == textPaint) {
            textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        }
        textPaint.setStrokeWidth(thickness);
        textPaint.setTextSize(textSize);
        textPaint.setColor(normalColor);
        textPaint.setTextAlign(Paint.Align.CENTER);
        return textPaint;
    }

    public void setTextPaint(Paint textPaint) {
        this.textPaint = textPaint;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public boolean isShowNormal() {
        return showNormal;
    }

    public void setShowNormal(boolean showNormal) {
        this.showNormal = showNormal;
    }

    public Paint getNormalPaint() {
        if (null == normalPaint) {
            normalPaint = new Paint();
        }
        normalPaint.setStrokeWidth(thickness);
        normalPaint.setTextSize(textSize);
        normalPaint.setColor(normalColor);
        return normalPaint;
    }

    public void setNormalPaint(Paint normalPaint) {
        this.normalPaint = normalPaint;
    }

    public int getnSpanL() {
        return nSpanL;
    }

    public void setnSpanL(int nSpanL) {
        this.nSpanL = nSpanL;
    }

    public int getnL() {
        return nL;
    }

    public void setnL(int nL) {
        this.nL = nL;
    }

    public int getnSpanOffset() {
        return nSpanOffset;
    }

    public void setnSpanOffset(int nSpanOffset) {
        this.nSpanOffset = nSpanOffset;
    }

    public float getThickness() {
        return thickness;
    }

    public void setThickness(float thickness) {
        this.thickness = thickness;
    }

    public int getNormalColor() {
        return normalColor;
    }

    public void setNormalColor(int normalColor) {
        this.normalColor = normalColor;
    }

    public boolean haveText() {
        if ((null == texts || texts.size() <= 0) && (null == text || text.length() <= 0)) {
            return false;
        }
        return true;
    }

    /**
     * only for Array
     *
     * @return
     */
    public SparseArray<String> adjustTexts() {
        if (null != texts && texts.size() >= 0 && null != points) {
            int j = points.size() / 2;
            if (texts.size() == j) {
                return texts;
            } else {
                SparseArray<String> temp = new SparseArray<>();
                for (int i = 0; i < j; i++) {
                    if (i < texts.size()) {
                        temp.put(i, texts.get(i));
                    } else {
                        temp.put(i, "");
                    }
                }
                return temp;
            }
        } else if (null != text && text.length() >= 0 && null != points) {
            SparseArray<String> temp = new SparseArray<>();
            for (int i = 0; i < points.size() / 2; i++) {
                temp.put(i, text);
            }
            return temp;
        } else
            return null;
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
}
