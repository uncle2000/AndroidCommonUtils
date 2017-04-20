package com.uncle2000.androidcommonutils.views;

import java.util.Timer;
import java.util.TimerTask;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Region;
import android.os.Handler;
import android.util.Log;
import android.view.View;

/**
 * Created by 2000 on 2017/4/18.
 */

public class SimpleWaveView extends View{
    private Paint Paint = new Paint();
    private int Color=0xfffdd803;
    private int Alpha =255;
    private Path path= new Path();
    private Handler mHandler;
    private int Frequency=128;
    private long c = 0L;
    private double PeakSpacing=3;//波峰距离 越大越多
    private float SpeedH = 0.04F;  //速度
    private float SpeedV=0.033F;
    private boolean FlagO=true,FlagR=false;
    private float Percentage = 0.6F,Refresh=0;
    private float Amplitude = 3F; // 振幅
    private int ColorLevel1=0x0,ColorLevel2=0x0,ColorLevel3=0x0;//=0xfffdd803;
    private float Level1=0;
    private float Level2=0;
    public SimpleWaveView(Context context) {
        super(context);
        Paint.setStrokeWidth(1.0F);
        Paint.setAlpha(Alpha);
        mHandler = new Handler(){
            @Override
            public void handleMessage(android.os.Message msg) {
                if (msg.what == 0) {
                }else if(msg.what == 1){
                    if(Percentage>0.00 && FlagO){
                        Percentage-=SpeedV;
                    }else if(Percentage<Refresh){
                        FlagO=false;
                        Percentage+=SpeedV;
                    }else{
                        FlagO=true;
                        FlagR=false;
                    }
                }
                invalidate();
            }
        };
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                if(FlagR)
                    mHandler.sendEmptyMessage(1);
                else
                    mHandler.sendEmptyMessage(0);
            }
        },0, Frequency);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        int width = getWidth();
        int height = getHeight();
        if(Level1==0)
            Paint.setColor(Color);
        else if(Level2==0){
            if(Percentage>=0 &&Percentage <Level1 )
                Paint.setColor(ColorLevel1);
            else
                Paint.setColor(ColorLevel2);
        }else{
            if(Percentage>=0 &&Percentage <Level1 )
                Paint.setColor(ColorLevel1);
            else if(Percentage>=Level1&&Percentage <Level2)
                Paint.setColor(ColorLevel2);
            else if(Percentage>=Level2 &&Percentage <=1)
                Paint.setColor(ColorLevel3);
        }

        if ((width == 0) || (height == 0)) {
            canvas.drawRect(0.0F, height / 2, width, height, Paint);
            return;
        }
        if (this.c >= 8388607L) {
            this.c = 0L;
        }
        this.c++;
        float f1 = height * (1.0F - Percentage);
        int top = (int) (f1 + Amplitude);
        path.reset();
        path.addCircle(width/2,width/2, width/2, Path.Direction.CCW);
        canvas.clipPath(path, Region.Op.REPLACE);
        canvas.drawRect(0.0F, top, width, height, Paint);

        int stopX = 0;
        while (stopX < width) {
            int startY = (int) (f1 - Amplitude* Math.sin(Math.PI * (2.0F * (stopX*PeakSpacing+  this.c * width * this.SpeedH*2))/ width));
            canvas.drawLine(stopX, startY, stopX, top, Paint);
            int i4 = stopX + 1;
            stopX = i4;
        }
        canvas.restore();

        Log.i("changdu", ""+getWidth());
    }
    /**
     * Level1在(0%,100%)之间则ColorLevel1，ColorLevel2生效，有两种颜色。Level2在(Level1,100%)之间则ColorLevel1，ColorLevel2，ColorLevel3生效，有三种颜色。
     * 该方法一旦生效，则setColor()方法自动失效。
     * @param ColorLevel1 [0%,Level1)之间的波浪的颜色
     * @param ColorLevel2 Level2生效的情况下，显示为[Level1,Level2)之间的波浪的颜色，Level2不生效的情况下，显示为[Level1,100%]之间的波浪的颜色。
     * @param ColorLevel3 [Level2,100%]之间的波浪的颜色
     * @param Level1 第一分界
     * @param Level2 第二分界，大于Level1生效，否则默认失效。
     */
    public void setWaveDiffrentColor(int ColorLevel1,int ColorLevel2,int ColorLevel3,float Level1,float Level2) {
        this.ColorLevel1=ColorLevel1;
        this.ColorLevel2=ColorLevel2;
        this.ColorLevel3=ColorLevel3;
        if(Level1>0&&Level1<1)
            this.Level1=Level1;
        if(Level2>Level1&&Level2<1)
            this.Level2=Level2;
    }
    /**
     * 设置波浪的颜色，如果设置了setWaveDiffrentColor()方法则setColor()自动失效。
     * @param color 波浪颜色
     */
    public void setColor(int color) {
        Color = color;
    }

    /**
     * 从刷新前的高度降到0，然再升到刷新后的高度
     * @param refresh 刷新之后的高度
     */
    public void setRefresh(float refresh) {
        if(refresh>=0&&refresh<=1){
            Refresh = refresh;
            FlagR=true;
        }
    }
    public float getAlpha() {
        return Alpha;
    }
    /**
     * 取值0~255之间，255代表不透明。
     * @param alpha 透明度
     */
    public void setAlpha(int alpha) {
        if(alpha>=0&&alpha<=255)
            Alpha = alpha;
    }
    public double getPeakSpacing() {
        return PeakSpacing;
    }
    /**
     * 决定了两个波峰之间的距离，该参数越大，波峰之间的距离越小
     * @param peakSpacing 波间距（反比）
     */
    public void setPeakSpacing(double peakSpacing) {
        PeakSpacing = peakSpacing;
    }
    public float getPercentage() {
        return Percentage;
    }
    /**
     * 决定了当前波浪停留的位置。取值0~1之间。
     * @param percentage 百分比
     */
    public void setPercentage(float percentage) {
        if(percentage>=0F&&percentage<=1.0F)
            Percentage = percentage;
    }
    public float getAmplitude() {
        return Amplitude;
    }
    /**
     * 决定了波的高度
     * @param amplitude 幅度
     */
    public void setAmplitude(float amplitude) {
        Amplitude = amplitude;
    }
    public float getSpeedH() {
        return SpeedH;
    }
    public float getSpeedV() {
        return SpeedV;
    }
    /**
     *
     * @param speedH 水平波浪的速度
     */
    public void setSpeedH(float speedH) {
        SpeedH=speedH;
    }
    /**
     *
     * @param speedV 升降的速度
     */
    public void setSpeedV(float speedV) {
        SpeedV=speedV;
    }
}