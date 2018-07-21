package com.example.zwx.myvideoview.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author：weixin on 2017/12/28 0028 09:40
 * <p>
 * E-mail：wx18311198679z@163.com
 *  天气
 */

public class RealTimeWeatherBean implements Serializable {



   private List<String> listTime;
   private List<String> listurl;
   private List<String> listwind;
    private List<Integer> listTemperature;
    private List<Integer>  weatherPicturelist;

    private int maxTemp;
    private int minTemp;


    public List<Integer> getWeatherPicturelist() {
        return weatherPicturelist;
    }

    public void setWeatherPicturelist(List<Integer> weatherPicturelist) {
        this.weatherPicturelist = weatherPicturelist;
    }

    public List<Integer> getListTemperature() {
        return listTemperature;
    }

    public void setListTemperature(List<Integer> listTemperature) {
        this.listTemperature = listTemperature;
    }

    public List<String> getListTime() {
        return listTime;
    }

    public void setListTime(List<String> listTime) {
        this.listTime = listTime;
    }

    public List<String> getListurl() {
        return listurl;
    }

    public void setListurl(List<String> listurl) {
        this.listurl = listurl;
    }

    public List<String> getListwind() {
        return listwind;
    }

    public void setListwind(List<String> listwind) {
        this.listwind = listwind;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(int maxTemp) {
        this.maxTemp = maxTemp;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(int minTemp) {
        this.minTemp = minTemp;
    }


    @Override
    public String toString() {
        return "RealTimeWeatherBean{" +
                "listTime=" + listTime +
                ", listurl=" + listurl +
                ", listwind=" + listwind +
                ", listTemperature=" + listTemperature +
                ", maxTemp=" + maxTemp +
                ", minTemp=" + minTemp +
                '}';
    }
}
