package com.uncle2000.androidcommonutils.views.chart.utils;

import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;

import com.uncle2000.androidcommonutils.views.chart.coorsystem.Anchor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 把数据调整成适合图表自身的样子
 * Created by 2000 on 2017/4/26.
 */

public class AdjustData {

    public static List<Point> adjustData2Px(List<Point> orign, Anchor anchor, float scale) {
        return adjustData2Px(orign, anchor, scale, scale);
    }

    public static List<Point> adjustData2Px(List<Point> orign, Anchor anchor, float scaleX, float scaleY) {
        float oX, oY;
        oX = anchor.x;
        oY = anchor.y;

        List<Point> temp = new ArrayList<>();
        for (Point p : orign) {
            temp.add(new Point(
                    (int) (oX + p.x / scaleX),
                    (int) (oY - p.y / scaleY)
            ));
        }
        return temp;
    }

//    public List<Rect> adjustData2Sa(List<Point> sa) {
//
//        return saR;
//    }
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

    /**
     * 画散点
     *
     * @param sa
     * @return
     */
    public static float[] toPoints(List<Point> sa) {
        float[] pts = new float[sa.size() * 2];
        for (int i = 0; i < sa.size(); i++) {
            pts[i * 2] = sa.get(i).x;
            pts[i * 2 + 1] = sa.get(i).y;
        }
        return pts;
    }


    /**
     * 画折线
     *
     * @param sa
     * @return
     */
    public static float[] toCurve(List<Point> sa) {
        float[] pts = new float[(sa.size() - 1) * 4];
        for (int i = 0; i < sa.size() - 1; i++) {
            pts[i * 4] = sa.get(i).x;
            pts[i * 4 + 1] = sa.get(i).y;
            pts[i * 4 + 2] = sa.get(i + 1).x;
            pts[i * 4 + 3] = sa.get(i + 1).y;
        }
        return pts;
    }

    /**
     * 画十字线
     *
     * @param sa
     * @return
     */
    public static float[] toCrossLine(List<Point> sa, float crossLineW) {
        float[] pts = new float[sa.size() * 8];
        for (int i = 0; i < sa.size(); i++) {
            pts[i * 8 + 0] = sa.get(i).x - crossLineW;
            pts[i * 8 + 1] = sa.get(i).y;
            pts[i * 8 + 2] = sa.get(i).x + crossLineW;
            pts[i * 8 + 3] = sa.get(i).y;
            pts[i * 8 + 4] = sa.get(i).x;
            pts[i * 8 + 5] = sa.get(i).y - crossLineW;
            pts[i * 8 + 6] = sa.get(i).x;
            pts[i * 8 + 7] = sa.get(i).y + crossLineW;
        }
        return pts;
    }

    /**
     * 画虚线
     * 这里的虚线并不是指多个点相链接，而是指每个点和X轴Y轴的法线
     *
     * @param sa
     * @return
     */
    public static List<Path> toDash(List<Point> sa, int minTableX, int maxTableY) {
        List<Path> saP = new ArrayList<>();
        Path path = new Path();
        for (int i = 0; i < sa.size() * 2; i++) {
            int loc = new BigDecimal(i / 2).setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
            if (i % 2 == 0) {
                path.moveTo(minTableX, sa.get(loc).y);
            } else {
                path.moveTo(sa.get(loc).x, maxTableY);
            }
            path.lineTo(sa.get(loc).x, sa.get(loc).y);
            saP.add(path);
        }
        return saP;
    }


    /**
     * 画横线
     *
     * @param sa
     * @return
     */
    public static float[] toHorizontal(List<Point> sa) {
        float[] pts = new float[(sa.size() - 1) * 4];
        for (int i = 0; i < sa.size() - 1; i++) {
            pts[i * 4] = sa.get(i).x;
            pts[i * 4 + 1] = sa.get(i).y;
            pts[i * 4 + 2] = sa.get(i + 1).x;
            pts[i * 4 + 3] = sa.get(i).y;
        }
        return pts;
    }


    /**
     * 画柱子
     *
     * @param sa
     * @return
     */
    public static List<Rect> toPillar(List<Point> sa) {
        List<Rect> saR = new ArrayList<>();
        Rect rect;
        for (int i = 0; i < sa.size(); i++) {
//            rect = new Rect(
//                    chartDataCopy[i].x - pillarW,
//                    chartDataCopy[i].y,
//                    chartDataCopy[i].x + pillarW,
//                    maxTableY
//            );
//            saR.put( rect);
        }
        return saR;
    }


    /**
     * 画曲线
     *
     * @param sa
     * @return
     */
    public static List<Path> toRolyline(List<Point> sa) {
        List<Path> saP = new ArrayList<>();
        Point startp;
        Point endp;
        for (int i = 0; i < sa.size() - 1; i++) {
            startp = sa.get(i);
            endp = sa.get(i + 1);
            int wt = (startp.x + endp.x) / 2;
            Point p3 = new Point();
            Point p4 = new Point();
            p3.y = startp.y;
            p3.x = wt;
            p4.y = endp.y;
            p4.x = wt;
            Path path = new Path();
            path.moveTo(startp.x, startp.y);
            path.cubicTo(p3.x, p3.y, p4.x, p4.y, endp.x, endp.y);
            saP.add(path);
        }
        return saP;
    }


    /**
     * @param sa
     * @return
     */
    public static List<Rect> adjustData2Sa(List<Point> sa) {
        List<Rect> saR = new ArrayList<>();
        Rect rect;
//        ConvertData.pointA2RectA(chartDataCopy, pillarW);
        return saR;
    }

}
