package com.example.zwx.myvideoview.tool;


import android.content.Context;
import android.content.res.AssetManager;

import com.example.zwx.myvideoview.R;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author：weixin on 2018/1/11 0011 20:28
 * <p>
 * E-mail：wx18311198679z@163.com
 * 天气图片
 */

public class WeatherPictureTool {


    /**
     *
     * @param weathername 天气状况
     * @param time   天气时间
     * @return
     */
    public static int getWeatherPicture(String weathername,String time){


        if (weathername.equals("晴")&&time==null){
            return R.mipmap.taiyuang_bai;
        }else if (weathername.equals("晴")&&time!=null){
            return R.mipmap.yueliang_wan;
        }

        if (weathername.equals("暴雪")){
            return R.mipmap.baoxue;
        }else if (weathername.equals("暴雨")){
            return R.mipmap.baoyu;
        }else if (weathername.equals("大暴雨")){
            return R.mipmap.dabaoyu;
        }else if (weathername.equals("大暴雨到特大暴雨")){
            return R.mipmap.dabaoyudaotedabaoyu;
        }else if (weathername.equals("大到暴雨")){
            return R.mipmap.dadaobaoyu;
        }else if (weathername.equals("大雪")){
            return R.mipmap.daxue;
        }else if (weathername.equals("大雨")){
            return R.mipmap.dayu;
        }else if (weathername.equals("冻雨")){
            return R.mipmap.dongyu;
        }else if (weathername.equals("多云")&&time==null){
            return R.mipmap.duoyun_bai2;
        }else if (weathername.equals("多云")&&time!=null){
            return R.mipmap.duoyun_wan1;
        }else if (weathername.equals("浮尘")){
            return R.mipmap.fuchen;
        }else if (weathername.equals("雷阵雨")){
            return R.mipmap.leizhenyu;
        }else if (weathername.equals("雷阵雨伴有冰雹")){
            return R.mipmap.leizhenyubanyoubingbao;
        }else if (weathername.equals("霾")){
            return R.mipmap.mai;
        }else if (weathername.equals("强沙尘暴")){
            return R.mipmap.qiangshachenbao;
        }else if (weathername.equals("沙尘暴")){
            return R.mipmap.shachenbao;
        }else if (weathername.equals("特大暴雨")){
            return R.mipmap.tedabaoyu;
        }else if (weathername.equals("雾")){
            return R.mipmap.wu;
        }else if (weathername.equals("小到中雪")){
            return R.mipmap.xiaodaozhongxue;
        }else if (weathername.equals("小到中雨")){
            return R.mipmap.xiaodaozhongyu;
        }else if (weathername.equals("小雪")){
            return R.mipmap.xiaoxue;
        }else if (weathername.equals("小雨")){
            return R.mipmap.xiaoyu;
        }else if (weathername.equals("扬沙")){
            return R.mipmap.yangsha;
        }else if (weathername.equals("阴")){
            return R.mipmap.yin_shou;
        }else if (weathername.equals("雨夹雪")){
            return R.mipmap.yujiaxue;
        }else if (weathername.equals("阵雪")){
            return R.mipmap.zhenxue;
        }else if (weathername.equals("阵雨")&&time==null){
            return R.mipmap.zhenyu_bai;
        }else if (weathername.equals("阵雨")&&time!=null){
            return R.mipmap.zhenyu_wan;
        }else if (weathername.equals("中到大雨")){
            return R.mipmap.zhongdaodayu;
        }else if (weathername.equals("中雪")){
            return R.mipmap.zhongxue;
        }else if (weathername.equals("中雪到大雪")){
            return R.mipmap.zhongxuedaodaxue;
        }else if (weathername.equals("中雨")){
            return R.mipmap.zhongyu;
        }else if (weathername.equals("雨")){
            return R.mipmap.xiaoyu;
        }else if (weathername.equals("雪")){
            return R.mipmap.xiaoxue;
        }


            return R.mipmap.yin_shou;
    }


    /**
     *  读取本地文件   assets中的文件
     * @param context
     * @param fileName
     * @return
     */
    public static String getJson(Context context, String fileName) {

        StringBuilder stringBuilder = new StringBuilder();
        try {
            AssetManager assetManager = context.getAssets();
            BufferedReader bf = new BufferedReader(new InputStreamReader(
                    assetManager.open(fileName)));
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

}
