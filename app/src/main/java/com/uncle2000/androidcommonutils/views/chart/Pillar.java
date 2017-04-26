package com.uncle2000.androidcommonutils.views.chart;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import com.uncle2000.androidcommonutils.views.chart.descartes.RadarCoorStstem;
import com.uncle2000.androidcommonutils.views.chart.descartes.coordinate.Anchor;
import com.uncle2000.androidcommonutils.views.chart.utils.DefaultData;
import com.uncle2000.androidcommonutils.views.chart.utils.Utils;

import static com.uncle2000.androidcommonutils.views.chart.utils.DefaultData.chartDataCopy;

/**
 * http://www.05935.com/bc/1374564/
 * Created by 2000 on 2017/4/19.
 */

public class Pillar extends View {
    private final TextPaint mTextPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
    private Paint mDatapaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private float minRangeX, maxRangeX, minRangeY, maxRangeY;
    private float minTableX = 50, maxTableX, minTableY = 50, maxTableY;
    private float tableSpanX, tableSpanY;
    private int rows, columns;
    private Point[] chartData;
    private float lPadding = 30, rPadding = 30, tPadding = 30, bPadding = 30;
    private float warpWidth, warpHeight;
    //    DescartesCoorSystem coorSystem;
    RadarCoorStstem coorSystem;

    public Pillar(Context context) {
        this(context, null);
    }

    public Pillar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Pillar(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public Pillar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        final Resources res = getResources();

        mTextPaint.density = res.getDisplayMetrics().density;
        mTextPaint.setTextSize(38f);

//        mDatapaint = new Paint();

        getChartData();
        int[] a = new int[]{0, 0, 0, 0};
        if (null != chartData) {
            a = Utils.getMaxMin(chartData);
        }
        Utils.adjustData(lPadding, tPadding);

        int[] b = Utils.getMaxMin(chartDataCopy);
        minRangeX = b[0];
        maxRangeX = b[1];
        minRangeY = b[2];
        maxRangeY = b[3];
        rows = 6;
        columns = 8;
        columns = chartData.length + 1;

        tableSpanX = (a[1] - a[0]) / columns;
        tableSpanY = (a[3] - a[2]) / rows;
        warpWidth = a[1] + lPadding + rPadding;
        warpHeight = a[3] + mTextPaint.getFontMetricsInt(null) + tPadding + bPadding;
        maxTableX = warpWidth;
        maxTableY = warpHeight - 50 - bPadding;


        Anchor anchor = new Anchor(500, 600);
//        coorSystem = new DescartesCoorSystem(anchor);
//        coorSystem = new RadarCoorStstem(anchor,60);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width;
        int height;

        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {
            height = Math.max(getSuggestedMinimumHeight(), (int) warpHeight);
        }

        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else {
            width = Math.max(getSuggestedMinimumWidth(), (int) warpWidth);
        }

        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        drawTable(canvas);
        coorSystem.draw(canvas);
//        drawData(canvas);
    }

//    private void drawData(Canvas canvas) {
////        drawDataArea(canvas);
//        drawDataPadding(canvas);
//        drawPoints(canvas);
////        drawCrossLine(canvas);
////        drawLines(canvas);
////        drawHorizontalLines(canvas);
////        drawPillars(canvas);
//        drawScrollLine(canvas);
////        drawDashLine(canvas);
//        drawWaterfall(canvas);
//    }
//
//    private void drawDataPadding(Canvas canvas) {
//        mDatapaint.setStrokeWidth(1f);
//        float[] pts = new float[]{
//                minRangeX - lPadding, minRangeY - tPadding, maxRangeX + rPadding, minRangeY - tPadding,
//                maxRangeX + rPadding, minRangeY - tPadding, maxRangeX + rPadding, maxRangeY + bPadding,
//                maxRangeX + rPadding, maxRangeY + bPadding, minRangeX - lPadding, maxRangeY + bPadding,
//                minRangeX - lPadding, maxRangeY + bPadding, minRangeX - lPadding, minRangeY - tPadding,
//        };
//        canvas.drawLines(pts, mDatapaint);
//    }
//
//    private void drawDataArea(Canvas canvas) {
//        mDatapaint.setStrokeWidth(1f);
//        float[] pts = new float[]{
//                minRangeX, minRangeY, maxRangeX, minRangeY,
//                maxRangeX, minRangeY, maxRangeX, maxRangeY,
//                maxRangeX, maxRangeY, minRangeX, maxRangeY,
//                minRangeX, maxRangeY, minRangeX, minRangeY,
//        };
//        canvas.drawLines(pts, mDatapaint);
//    }
//
//    private void drawPoints(Canvas canvas) {
//        mDatapaint.setStrokeWidth(10f);
//        float[] pts = new float[chartDataCopy.length * 2];
//        for (int i = 0; i < chartDataCopy.length; i++) {
//            pts[i * 2] = chartDataCopy[i].x;
//            pts[i * 2 + 1] = chartDataCopy[i].y;
//        }
//        canvas.drawPoints(pts, mDatapaint);
//    }
//
//    private void drawCrossLine(Canvas canvas) {
//        mDatapaint.setStrokeWidth(1.2f);
//        float[] pts = new float[(chartDataCopy.length) * 8];
//        int crossLineW = 25;
//        for (int i = 0; i < chartDataCopy.length; i++) {
//            pts[i * 8 + 0] = chartDataCopy[i].x - crossLineW;
//            pts[i * 8 + 1] = chartDataCopy[i].y;
//            pts[i * 8 + 2] = chartDataCopy[i].x + crossLineW;
//            pts[i * 8 + 3] = chartDataCopy[i].y;
//            pts[i * 8 + 4] = chartDataCopy[i].x;
//            pts[i * 8 + 5] = chartDataCopy[i].y - crossLineW;
//            pts[i * 8 + 6] = chartDataCopy[i].x;
//            pts[i * 8 + 7] = chartDataCopy[i].y + crossLineW;
//        }
//        canvas.drawLines(pts, mDatapaint);
//    }
//
//    private void drawLines(Canvas canvas) {
//        mDatapaint.setStrokeWidth(1.2f);
//        float[] ptsL = new float[(chartDataCopy.length - 1) * 4];
//
//        for (int i = 0; i < chartDataCopy.length - 1; i++) {
//            ptsL[i * 4] = chartDataCopy[i].x;
//            ptsL[i * 4 + 1] = chartDataCopy[i].y;
//            ptsL[i * 4 + 2] = chartDataCopy[i + 1].x;
//            ptsL[i * 4 + 3] = chartDataCopy[i + 1].y;
//        }
//        canvas.drawLines(ptsL, mDatapaint);
//    }
//
//    private void drawHorizontalLines(Canvas canvas) {
//        mDatapaint.setStrokeWidth(1.2f);
//        float[] ptsL = new float[(chartDataCopy.length - 1) * 4];
//
//        for (int i = 0; i < chartDataCopy.length - 1; i++) {
//            ptsL[i * 4] = chartDataCopy[i].x;
//            ptsL[i * 4 + 1] = chartDataCopy[i].y;
//            ptsL[i * 4 + 2] = chartDataCopy[i + 1].x;
//            ptsL[i * 4 + 3] = chartDataCopy[i].y;
//        }
//        canvas.drawLines(ptsL, mDatapaint);
//    }
//
//    private void drawPillars(Canvas canvas) {
//        int pillarW = 25;
//        for (int i = 0; i < chartDataCopy.length; i++) {
//            canvas.drawRect(new RectF(
//                    chartDataCopy[i].x - pillarW,
//                    chartDataCopy[i].y,
//                    chartDataCopy[i].x + pillarW,
//                    maxTableY
//            ), mDatapaint);
//        }
//
//    }
//
//    private void drawWaterfall(Canvas canvas) {
//        int pillarW = 25;
//        Rect[] r = ConvertData.pointA2RectA(chartDataCopy, pillarW);
//        for (int i = 0; i < r.length; i++) {
//            canvas.drawRect(r[i], mDatapaint);
//        }
//    }
//
//    private void drawScrollLine(Canvas canvas) {
//        mDatapaint.setStrokeWidth(2.5f);
//        mDatapaint.setStyle(Paint.Style.STROKE);
//        Point startp = new Point();
//        Point endp = new Point();
//        for (int i = 0; i < chartDataCopy.length - 1; i++) {
//            startp = chartDataCopy[i];
//            endp = chartDataCopy[i + 1];
//            int wt = (startp.x + endp.x) / 2;
//            Point p3 = new Point();
//            Point p4 = new Point();
//            p3.y = startp.y;
//            p3.x = wt;
//            p4.y = endp.y;
//            p4.x = wt;
//
//            Path path = new Path();
//            path.moveTo(startp.x, startp.y);
//            path.cubicTo(p3.x, p3.y, p4.x, p4.y, endp.x, endp.y);
//            canvas.drawPath(path, mDatapaint);
//        }
//    }
//
//    int phase = 0;
//
//    private void drawDashLine(Canvas canvas) {
//        Paint paint = new Paint();
//        paint.setColor(Color.BLACK);
//        //设置画直线格式
//        paint.setStyle(Paint.Style.STROKE);
//        //设置虚线效果
//        paint.setPathEffect(new DashPathEffect(new float[]{25, 25}, phase));
//
//        paint.setStrokeWidth(1.2f);
//        Path path = new Path();
//        float[] pts = new float[(chartDataCopy.length) * 8];
//        for (int i = 0; i < chartDataCopy.length; i++) {
//            path.moveTo(chartDataCopy[i].x, chartDataCopy[i].y);
//            path.lineTo(minTableX, chartDataCopy[i].y);
//            canvas.drawPath(path, paint);
//            path.moveTo(chartDataCopy[i].x, chartDataCopy[i].y);
//            path.lineTo(chartDataCopy[i].x, maxTableY);
//            canvas.drawPath(path, paint);
//        }
//
//        phase += 1;
//        invalidate();
//    }

    public Point[] getChartData() {
        return chartData = DefaultData.chartData;
    }

    public void setChartData(Point[] chartData) {
        this.chartData = chartData;
    }
}
