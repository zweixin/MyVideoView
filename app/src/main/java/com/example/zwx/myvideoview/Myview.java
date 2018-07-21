package com.example.zwx.myvideoview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zhangweixin on 2018/7/21.
 *   自定义view
 */

public class Myview extends View {


    private Paint paint1;
    private Bitmap bitmap;


    private static final int TEMP[] = { 2, 5, 6, 3, 2,
            1, -1, -2, -4};
    private static final int WINDY[] = {4, 4, 4, 4, 4,
            4, 4, 4, 4};
    private static final int WEATHER_RES[] ={R.mipmap.w0, R.mipmap.w1, R.mipmap.w3,  R.mipmap.w15,  R.mipmap.w15
            ,R.mipmap.w5, R.mipmap.w7, R.mipmap.w9,  R.mipmap.w15,  R.mipmap.w15
            , R.mipmap.w15, R.mipmap.w10, R.mipmap.w15, R.mipmap.w15,  R.mipmap.w15
            , R.mipmap.w15,  R.mipmap.w15,  R.mipmap.w15,  R.mipmap.w15,  R.mipmap.w15
            ,R.mipmap.w18,  R.mipmap.w15,  R.mipmap.w15, R.mipmap.w19};



    public Myview(Context context) {
        super(context);
        paint1=new Paint();
        paint1.setTextSize(30);
        paint1.setColor(getResources().getColor(R.color.colorPrimary));
    }

    public Myview(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint1=new Paint();
        paint1.setTextSize(30);//设置字体大小
        paint1.setColor(getResources().getColor(R.color.colorPrimary));//设置字体颜色

        bitmap= BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);


    }

    public Myview(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawText("你好，我在这",0,30,paint1);//文字显示
        canvas.drawLine(0,60,100,60,paint1);//线
        canvas.drawRect(0,90,100,190,paint1);//正方形
        Rect rect=new Rect(150,90,250,190);//正方形
        canvas.drawRect(rect,paint1);
        RectF rectF=new RectF(350,90,450,190);
        canvas.drawRect(rectF,paint1);
        //以上是正方形
        //圆角矩形
        RectF rectF2=new RectF(0,220,100,320);
        canvas.drawRoundRect(rectF2,10,10,paint1);
        //第一个参数x起始距离，第二个y起始距离，第三个半径，第四个画笔
        paint1.setStyle(Paint.Style.STROKE);//设置空心
        canvas.drawCircle(80,379,50,paint1);

        //绘制图片
        canvas.drawBitmap(bitmap,30,450,paint1);



    }
}
