package com.example.zwx.myvideoview;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.zwx.myvideoview.bean.DetailedWeatherBean;
import com.example.zwx.myvideoview.bean.RealTimeWeatherBean;
import com.example.zwx.myvideoview.tool.AcaChes;
import com.example.zwx.myvideoview.tool.WeatherPictureTool;
import com.example.zwx.myvideoview.view.IndexHorizontalScrollView;
import com.example.zwx.myvideoview.view.Today24HourView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    private IndexHorizontalScrollView indexHorizontalScrollView;
    private String fileNames = "weatherjson.json";
    private AcaChes acaChes;
    private final int Five = 5;


    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {

                case Five:
                    DetailedWeatherBean detailedWeatherBeans = (DetailedWeatherBean) msg.obj;
                    setDataAdapter(detailedWeatherBeans);
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        indexHorizontalScrollView= (IndexHorizontalScrollView) findViewById(R.id.indexHorizontalScrollView);

        initData();
    }




    private void initData(){

        acaChes = AcaChes.get(this);
        noNetwork();
    }


    public void noNetwork() {
        try {
            final String weatherForecastdetails = acaChes.getAsString("WeatherForecastdetails");
            final Gson gson = new Gson();
            if (weatherForecastdetails != null && weatherForecastdetails.length() > 1) {
                DetailedWeatherBean detailedWeatherBeans = gson.fromJson(weatherForecastdetails, DetailedWeatherBean.class);
                setDataAdapter(detailedWeatherBeans);
            } else {

                                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        String weatherjson = WeatherPictureTool.getJson(MainActivity.this, fileNames);
                        DetailedWeatherBean detailedWeatherBeans = gson.fromJson(weatherjson, DetailedWeatherBean.class);
                        Message msg = mHandler.obtainMessage(Five, detailedWeatherBeans);
                        mHandler.sendMessage(msg);
                    }
                }.start();
            }

        } catch (Throwable e) {
            Log.e("有错误", e + "*************");
        }
    }
    public void setDataAdapter(DetailedWeatherBean detailedWeatherBean) {
        try {
            DetailedWeatherBean.DataBean samedayWeather = detailedWeatherBean.getData();


            DetailedWeatherBean.DataBean.DayWeatherBean day_weather = detailedWeatherBean.getData().getDay_weather();
            List<DetailedWeatherBean.DataBean.Ob5dayBean> ob_5day = detailedWeatherBean.getData().getOb_5day();



            List<String> listTime = new ArrayList<>();
            List<String> listurl = new ArrayList<>();
            List<String> listwind = new ArrayList<>();
            //24小时天气温度
            List<Integer> listTemperature = new ArrayList<>();
            List<Integer> weatherPicturelist = new ArrayList<>();
            //最高温最低温
            List<Integer> listTp = new ArrayList<>();
            DetailedWeatherBean.DataBean data1 = detailedWeatherBean.getData();
            List<List<String>> time_weather = data1.getTime_weather();
            for (int i = 0; i < time_weather.size(); i++) {
                listTime.add(time_weather.get(i).get(0));
                listurl.add(time_weather.get(i).get(6));
                listTemperature.add(Integer.parseInt(time_weather.get(i).get(3).replace("℃", "")));
                listwind.add(time_weather.get(i).get(4) + time_weather.get(i).get(5));
                if (time_weather.get(i).get(0).equals("20:00") || time_weather.get(i).get(0).equals("23:00")
                        || time_weather.get(i).get(0).equals("02:00") || time_weather.get(i).get(0).equals("05:00")) {
                    weatherPicturelist.add(WeatherPictureTool.getWeatherPicture(time_weather.get(i).get(2), time_weather.get(i).get(0)));
                } else {
                    weatherPicturelist.add(WeatherPictureTool.getWeatherPicture(time_weather.get(i).get(2), null));
                }
            }

            listTp.addAll(listTemperature);
            Collections.sort(listTp);
            RealTimeWeatherBean realTimeWeatherBean = new RealTimeWeatherBean();
            realTimeWeatherBean.setListTime(listTime);
            realTimeWeatherBean.setListurl(listurl);
            realTimeWeatherBean.setListwind(listwind);
            realTimeWeatherBean.setListTemperature(listTemperature);
            realTimeWeatherBean.setWeatherPicturelist(weatherPicturelist);
            DetailedWeatherBean.DataBean.DayWeatherBean day_weathers = data1.getDay_weather();
            realTimeWeatherBean.setMaxTemp(listTp.get(listTp.size() - 1));
            realTimeWeatherBean.setMinTemp(listTp.get(0));
            Today24HourView today24HourViews = new Today24HourView(this, realTimeWeatherBean);
            indexHorizontalScrollView.setToday24HourView(today24HourViews);
            indexHorizontalScrollView.removeAllViews();
            indexHorizontalScrollView.addView(today24HourViews);


        } catch (Throwable e) {
            Log.e("有错误", e + "*************");
        }
    }

}
