package com.example.zwx.myvideoview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import com.example.zwx.myvideoview.R;
import com.example.zwx.myvideoview.bean.HourItem;
import com.example.zwx.myvideoview.bean.RealTimeWeatherBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangweixin on 2018/7/21.
 */

public class Today24HourView extends View{



    private static final String TAG = "Today24HourView";
    private static final int ITEM_SIZE = 9;  //24小时
    private static final int ITEM_WIDTH = 200; //每个Item的宽度   曲线上方移动模块
    private static final int MARGIN_LEFT_ITEM = 50; //左边预留宽度    距离左边的距离
    private static final int MARGIN_RIGHT_ITEM = 120; //右边预留宽度

    private static final int windyBoxAlpha = 200;  //风力盒子透明度
    private static final int windyBoxMaxHeight = 80;
    private static final int windyBoxMinHeight = 20;
    private static final int windyBoxSubHight = windyBoxMaxHeight - windyBoxMinHeight;
    private static final int bottomTextHeight = 60;

    private int mHeight, mWidth;
    private int tempBaseTop;  //温度折线的上边Y坐标
    private int tempBaseBottom; //温度折线的下边Y坐标
    private Paint bitmapPaint, windyBoxPaint, linePaint, pointPaint, dashLinePaint;
    private TextPaint textPaint;

    private Context context;
    private List<HourItem> listItems;
    private int maxScrollOffset = 0;//滚动条最长滚动距离
    private int scrollOffset = 0; //滚动条偏移量
    private int currentItemIndex = 0; //当前滚动的位置所对应的item下标
    private int currentWeatherRes = -1;

    private RealTimeWeatherBean realTimeWeatherBean;//实体类
    private  List<String> listTime;
    private List<String> listurl;
    private  List<String> listwind;
    private List<Integer> listTemperature;
    private   List<Integer>  weatherPicturelist;
    private int maxTemp = 26;
    private int minTemp = 10;
    private int maxWindy = 5;
    private int minWindy = 2;
    private static final int TEMP[] = { 2, 5, 6, 3, 2,
            1, -1, -2, -4};
    private static final int WINDY[] = {4, 4, 4, 4, 4,
            4, 4, 4, 4};
    private static final int WEATHER_RES[] ={R.mipmap.w0, R.mipmap.w1, R.mipmap.w3,  R.mipmap.w15,  R.mipmap.w15
            ,R.mipmap.w5, R.mipmap.w7, R.mipmap.w9,  R.mipmap.w15,  R.mipmap.w15
            , R.mipmap.w15, R.mipmap.w10, R.mipmap.w15, R.mipmap.w15,  R.mipmap.w15
            , R.mipmap.w15,  R.mipmap.w15,  R.mipmap.w15,  R.mipmap.w15,  R.mipmap.w15
            ,R.mipmap.w18,  R.mipmap.w15,  R.mipmap.w15, R.mipmap.w19};


    public Today24HourView(Context context,RealTimeWeatherBean realTimeWeatherBean) {
        super(context, null);
        this.context=context;
        this.realTimeWeatherBean=realTimeWeatherBean;
        listTime = realTimeWeatherBean.getListTime();
        listurl = realTimeWeatherBean.getListurl();
        listwind = realTimeWeatherBean.getListwind();
        maxTemp=realTimeWeatherBean.getMaxTemp();
        minTemp=realTimeWeatherBean.getMinTemp();
        listTemperature = realTimeWeatherBean.getListTemperature();
        weatherPicturelist= realTimeWeatherBean.getWeatherPicturelist();
        init();
    }

    public Today24HourView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
        init();
    }

    public Today24HourView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mWidth = MARGIN_LEFT_ITEM + MARGIN_RIGHT_ITEM + ITEM_SIZE * ITEM_WIDTH;
        mHeight = 600; //暂时先写死
        tempBaseTop = (500 - bottomTextHeight)/3;   //曲线距离顶部
        tempBaseBottom = (500 - bottomTextHeight)*2/3;  //曲线距离底部

        initHourItems();
        initPaint();
    }

    private void initPaint() {
        pointPaint = new Paint();
        //温度 点
        pointPaint.setColor(getResources().getColor(R.color.color_4bc8fc));
        pointPaint.setStyle(Paint.Style.STROKE);
        pointPaint.setStrokeWidth(5);//圆壁厚度
        pointPaint.setAntiAlias(true);
        pointPaint.setTextSize(20);

        linePaint = new Paint();
        //底部水平的白线
        linePaint.setColor(new Color().WHITE);
        linePaint.setAntiAlias(true);
        linePaint.setStyle(Paint.Style.STROKE);
        linePaint.setStrokeWidth(5);

        dashLinePaint = new Paint();
        dashLinePaint.setColor(new Color().RED);
        PathEffect effect = new DashPathEffect(new float[]{5, 5, 5, 5}, 1);
        dashLinePaint.setPathEffect(effect);
        dashLinePaint.setStrokeWidth(3);
        dashLinePaint.setAntiAlias(true);
        dashLinePaint.setStyle(Paint.Style.STROKE);

        windyBoxPaint = new Paint();
        //风力下面的 方块
        windyBoxPaint.setTextSize(1);
        windyBoxPaint.setColor(getResources().getColor(R.color.color_bbd7f8));
        windyBoxPaint.setAlpha(windyBoxAlpha);
        windyBoxPaint.setAntiAlias(true);

        textPaint = new TextPaint();
        textPaint.setTextSize(DisplayUtil.sp2px(getContext(), 12));
        textPaint.setColor(new Color().WHITE);
        textPaint.setAntiAlias(true);

        bitmapPaint = new Paint();
        bitmapPaint.setAntiAlias(true);
    }

    //简单初始化下，后续改为由外部传入
    private void initHourItems(){
        listItems = new ArrayList<>();
        for(int i=0; i<ITEM_SIZE; i++){
            String time;

            time=listTime.get(i);//时间

            int left =MARGIN_LEFT_ITEM  +  i * ITEM_WIDTH;
            int right = left + ITEM_WIDTH - 1;
            int top = (int)(mHeight -bottomTextHeight +
                    (maxWindy - WINDY[i])*1.0/(maxWindy - minWindy)*windyBoxSubHight
                    - windyBoxMaxHeight);
            int bottom =  mHeight - bottomTextHeight;
            Rect rect = new Rect(left, top, right, bottom);
            Point point = calculateTempPoint(left, right, listTemperature.get(i));

            HourItem hourItem = new HourItem();
            hourItem.windyBoxRect = rect;
            hourItem.time = time;
            hourItem.windy = WINDY[i];
            hourItem.temperature = listTemperature.get(i);
            hourItem.tempPoint = point;
            hourItem.res = WEATHER_RES[i];
            listItems.add(hourItem);
        }
    }

    //计算温度点
    private Point calculateTempPoint(int left, int right, int temp){
        double minHeight = tempBaseTop;
        double maxHeight = tempBaseBottom;
        double tempY = maxHeight - (temp - minTemp)* 1.0/(maxTemp - minTemp) * (maxHeight - minHeight);
        Point point = new Point((left + right)/2, (int)tempY);
        return point;
    }

    /**
     * 图形的宽度，根据左边预留宽度+右边预留宽度+温度文字大小+每个item的宽度
     *  高根据我们具体的需求设置
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(mWidth, mHeight);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        for(int i=0; i<listItems.size(); i++){
            Rect rect = listItems.get(i).windyBoxRect;
            final Point point = listItems.get(i).tempPoint;

            onDrawLine(canvas, i);//曲线

            //画风力的box和提示文字
            onDrawBox(canvas, rect, i);
            //画表示天气图片   曲线上的天气
            if(listItems.get(i).res != -1 && i != currentItemIndex){

                Drawable drawable = ContextCompat.getDrawable(getContext(), weatherPicturelist.get(i));
                drawable.setBounds(point.x - DisplayUtil.dip2px(getContext(), 10),
                        point.y - DisplayUtil.dip2px(getContext(), 25),
                        point.x + DisplayUtil.dip2px(getContext(), 10),
                        point.y - DisplayUtil.dip2px(getContext(), 5));
                drawable.draw(canvas);

            }
            //画温度的点
            onDrawTemp(canvas, i);
            onDrawText(canvas, i);  //时间



        }
        //底部水平的白线
        linePaint.setColor(new Color().WHITE);
    }

    /**
     *    曲线上的温度
     * @param canvas
     * @param i
     */
    private void onDrawTemp(final Canvas canvas, int i) {
        HourItem item = listItems.get(i);
        Point point = item.tempPoint;
        //数字是圆的半径
        canvas.drawCircle(point.x, point.y, 8, pointPaint);

        if(currentItemIndex == i) {
            //计算提示文字的运动轨迹
            final int Y = getTempBarY();

            //虚线
            Drawable drawablew = ContextCompat.getDrawable(getContext(), R.mipmap.dotted_lines);
            drawablew.setBounds(getScrollBarX()+95,
                    Y - DisplayUtil.dip2px(getContext(), 70),
                    getScrollBarX() +100,
                    450-Y/5);
            drawablew.draw(canvas);

            //画出背景图片
            Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.weather_text_bg);
            drawable.setBounds(getScrollBarX(),
                    Y - DisplayUtil.dip2px(getContext(), 34),
                    getScrollBarX() + ITEM_WIDTH,
                    Y - DisplayUtil.dip2px(getContext(), 2));
            drawable.draw(canvas);
            //画天气
            final int res = findCurrentRes(i);
            Integer integer = weatherPicturelist.get(i);
            if(res != -1) {

                Drawable drawTemp = ContextCompat.getDrawable(getContext(), integer);
                drawTemp.setBounds(getScrollBarX()+ITEM_WIDTH/2 + (ITEM_WIDTH/2 - DisplayUtil.dip2px(getContext(), 30))/2,
                        Y - DisplayUtil.dip2px(getContext(), 30),
                        getScrollBarX()+ITEM_WIDTH - (ITEM_WIDTH/2 - DisplayUtil.dip2px(getContext(), 20))/2,
                        Y - DisplayUtil.dip2px(getContext(), 6));
                drawTemp.draw(canvas);



            }
            //画出温度提示
            int offset = ITEM_WIDTH/2;
            if(res == -1){
                offset = ITEM_WIDTH;
            }
            Rect targetRect = new Rect(getScrollBarX(), Y - DisplayUtil.dip2px(getContext(), 34)
                    , getScrollBarX() + offset, Y - DisplayUtil.dip2px(getContext(), 4));
            Paint.FontMetricsInt fontMetrics = textPaint.getFontMetricsInt();
            int baseline = (targetRect.bottom + targetRect.top - fontMetrics.bottom - fontMetrics.top) / 2;
            textPaint.setTextAlign(Paint.Align.CENTER);
            textPaint.setColor(getResources().getColor(R.color.tvtitle));
            textPaint.setTextSize(DisplayUtil.dip2px(getContext(), 16));
            canvas.drawText(item.temperature + "°", targetRect.centerX(), baseline, textPaint);
        }
    }

    private int findCurrentRes(int i) {
        if(listItems.get(i).res != -1){
            return listItems.get(i).res;
        }
        for(int k=i; k>=0; k--){
            if(listItems.get(k).res != -1){
                return listItems.get(k).res;
            }
        }
        return -1;
    }

    //画底部风力的BOX
    private void onDrawBox(Canvas canvas, Rect rect, int i) {
        // 新建一个矩形
        RectF boxRect = new RectF(rect);
        HourItem item = listItems.get(i);
        String s = listwind.get(i);
        String wind = s.replace("级", "");
        if(i == currentItemIndex) {
            windyBoxPaint.setAlpha(255);
            canvas.drawRoundRect(boxRect, 4, 4, windyBoxPaint);
            //画出box上面的风力提示文字
            Rect targetRect = new Rect(getScrollBarX(), rect.top - DisplayUtil.dip2px(getContext(), -16)
                    , getScrollBarX() + ITEM_WIDTH, rect.top - DisplayUtil.dip2px(getContext(), 0));
            Paint.FontMetricsInt fontMetrics = textPaint.getFontMetricsInt();
            int baseline = (targetRect.bottom + targetRect.top - fontMetrics.bottom - fontMetrics.top) / 2;
            textPaint.setTextAlign(Paint.Align.CENTER);
            textPaint.setColor(getResources().getColor(R.color.oa_all_title_bg));
            textPaint.setTextSize(DisplayUtil.dip2px(getContext(), 12));
            canvas.drawText(wind + "级", targetRect.centerX(), baseline, textPaint);
        } else {
            windyBoxPaint.setAlpha(windyBoxAlpha);
            canvas.drawRoundRect(boxRect, 4, 4, windyBoxPaint);
        }
    }

    //温度的折线,为了折线比较平滑，做了贝塞尔曲线
    private void onDrawLine(Canvas canvas, int i) {
        //曲线渐变色
        LinearGradient linearGradient = new LinearGradient(0, 0, 500, 500, new int[] {
                getResources().getColor(R.color.color_2491eb), getResources().getColor(R.color.color_50d0fe),
                getResources().getColor(R.color.color_2490eb)}, null,
                Shader.TileMode.REPEAT);

        linePaint.setColor(getResources().getColor(R.color.color_4bc8fc));
        linePaint.setStrokeWidth(4);
        Point point = listItems.get(i).tempPoint;
        if(i != 0){
            Point pointPre = listItems.get(i-1).tempPoint;
            Path path = new Path();
            path.moveTo(pointPre.x, pointPre.y);
            if(i % 2 == 0){
                path.cubicTo((pointPre.x+point.x)/2, (pointPre.y+point.y)/2-7, (pointPre.x+point.x)/2, (pointPre.y+point.y)/2+7, point.x, point.y);
            } else{
                path.cubicTo((pointPre.x+point.x)/2, (pointPre.y+point.y)/2+7, (pointPre.x+point.x)/2, (pointPre.y+point.y)/2-7, point.x, point.y);
            }
            linePaint.setShader(linearGradient);
            canvas.drawPath(path, linePaint);
        }
    }

    //绘制底部时间
    private void onDrawText(Canvas canvas, int i) {
        //此处的计算是为了文字能够居中
        Rect rect = listItems.get(i).windyBoxRect;
        Rect targetRect = new Rect(rect.left, rect.bottom, rect.right, rect.bottom - bottomTextHeight-130);//时间显示位置
        Paint.FontMetricsInt fontMetrics = textPaint.getFontMetricsInt();
        int baseline = (targetRect.bottom + targetRect.top - fontMetrics.bottom - fontMetrics.top) / 2;
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setColor(getResources().getColor(R.color.title_text_color));
        textPaint.setTextSize(DisplayUtil.dip2px(getContext(), 14));
        String text = listItems.get(i).time;
        canvas.drawText(text, targetRect.centerX(), baseline, textPaint);
    }


    public void drawLeftTempText(Canvas canvas, int offset){
        //画最左侧的文字
        textPaint.setTextAlign(Paint.Align.LEFT);
        canvas.drawText(maxTemp + "°", DisplayUtil.dip2px(getContext(), 6) + offset, tempBaseTop, textPaint);
        canvas.drawText(minTemp + "°", DisplayUtil.dip2px(getContext(), 6) + offset, tempBaseBottom, textPaint);
    }

    //设置scrollerView的滚动条的位置，通过位置计算当前的时段
    public void setScrollOffset(int offset, int maxScrollOffset){
        this.maxScrollOffset = maxScrollOffset;
        scrollOffset = offset;
        int index = calculateItemIndex(offset);
        currentItemIndex = index;
        invalidate();
    }

    //通过滚动条偏移量计算当前选择的时刻
    private int calculateItemIndex(int offset){
//        Log.d(TAG, "maxScrollOffset = " + maxScrollOffset + "  scrollOffset = " + scrollOffset);
        int x = getScrollBarX();
        int sum = MARGIN_LEFT_ITEM  - ITEM_WIDTH/2;
        for(int i=0; i<ITEM_SIZE; i++){
            sum += ITEM_WIDTH;
            if(x < sum){
                return i;
            }

        }
        return ITEM_SIZE - 1;
    }

    private int getScrollBarX(){
        int x = 0;
        if (maxScrollOffset!=0){
            x = (ITEM_SIZE - 1) * ITEM_WIDTH * scrollOffset / maxScrollOffset;
        }
        x = x + MARGIN_LEFT_ITEM;
        return x;
    }

    //计算温度提示文字的运动轨迹
    private int getTempBarY(){
        int x = getScrollBarX();
        int sum = MARGIN_LEFT_ITEM ;
        Point startPoint = null, endPoint;
        int i;
        for(i=0; i<ITEM_SIZE; i++){
            sum += ITEM_WIDTH;
            if(x < sum) {
                startPoint = listItems.get(i).tempPoint;
                break;
            }
        }
        if(i+1 >= ITEM_SIZE || startPoint == null){
            return listItems.get(ITEM_SIZE-1).tempPoint.y;
        }
        endPoint = listItems.get(i+1).tempPoint;

        Rect rect = listItems.get(i).windyBoxRect;
        int y = (int)(startPoint.y + (x - rect.left)*1.0/ITEM_WIDTH * (endPoint.y - startPoint.y));
        return y;
    }
}
