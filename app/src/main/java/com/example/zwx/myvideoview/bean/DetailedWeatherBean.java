package com.example.zwx.myvideoview.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author：weixin on 2017/12/19 0019 15:27
 * <p>
 * E-mail：wx18311198679z@163.com
 *
 *   天气详情
 */

public class DetailedWeatherBean implements Serializable{


    /**
     * status : 200
     * msg : OK
     * data : {"xx":"2/7","cyzs":"冷； 建议着棉衣加羊毛衫等冬季服装。","dqfd":"静风 0级","dqtq":"晴","xdsd":"32%","kqzs":"中； 易感人群应适当减少室外活动。","gmzs":"少发； 无明显降温，感冒机率较低。","time_weather":[["26日08时","晴","-5℃","南风","<3级","http://img.wanzhao.com/group2/M00/FC/D4/wKgBzVo6HGKAaLKnAAA0qvDc30Q5579108"],["26日11时","晴","1℃","南风","<3级","http://img.wanzhao.com/group2/M00/FC/D4/wKgBzVo6HGKAaLKnAAA0qvDc30Q5579108"],["26日14时","晴","2℃","南风","<3级","http://img.wanzhao.com/group2/M00/FC/D4/wKgBzVo6HGKAaLKnAAA0qvDc30Q5579108"],["26日17时","晴","0℃","南风","<3级","http://img.wanzhao.com/group2/M00/FC/D4/wKgBzVo6HGKAaLKnAAA0qvDc30Q5579108"],["26日20时","晴","-1℃","南风","<3级","http://img.wanzhao.com/group2/M00/A2/F4/wKgBy1o6F9CAA7QoAAA53P89J744249226"],["26日23时","多云","-3℃","南风","<3级","http://img.wanzhao.com/group2/M00/A2/F4/wKgBy1o6FquAGqEsAAAMpZCscU07233241"],["27日02时","多云","-5℃","南风","<3级","http://img.wanzhao.com/group2/M00/A2/F4/wKgBy1o6FquAGqEsAAAMpZCscU07233241"],["27日05时","多云","-5℃","南风","<3级","http://img.wanzhao.com/group2/M00/A2/F4/wKgBy1o6FquAGqEsAAAMpZCscU07233241"],["27日08时","多云","-4℃","南风","<3级","http://img.wanzhao.com/group2/M00/FC/D4/wKgBzVo6GvWAGdIoAAAMpZCscU01578567"]],"day_weather":{"temp":"3℃","city":"101010100","cityname":"北京","tempn":"-6℃","weather":"晴间多云转晴转多云，平原地区有轻雾","ws":"<3级","wd":"南风"},"ob_5day":[{"ff":"东风","fg":"3-4级","fh":"3-4级","fi":"12/25","fj":"昨天","fk":"","fl":"","fm":"83.5","fn":"66.0","fburl":"http://img.wanzhao.com/group2/M00/A2/F4/wKgBy1o6F9CAA7QoAAA53P89J744249226","fa":"晴","fb":"晴","fc":"4","fd":"-5","fe":"西南风","faurl":"http://img.wanzhao.com/group2/M00/FC/D4/wKgBzVo6HGKAaLKnAAA0qvDc30Q5579108"},{"ff":"南风","fg":"<3级","fh":"<3级","fi":"12/26","fj":"今天","fk":"良","fl":"51","fm":"79.7","fn":"64.7","fburl":"http://img.wanzhao.com/group2/M00/A2/F4/wKgBy1o6FquAGqEsAAAMpZCscU07233241","fa":"晴","fb":"多云","fc":"3","fd":"-6","fe":"南风","faurl":"http://img.wanzhao.com/group2/M00/FC/D4/wKgBzVo6HGKAaLKnAAA0qvDc30Q5579108"},{"ff":"北风","fg":"<3级","fh":"<3级","fi":"12/27","fj":"周三","fk":"轻度污染","fl":"150","fm":"83.1","fn":"79.4","fburl":"http://img.wanzhao.com/group2/M00/A2/F4/wKgBy1o6F9CAA7QoAAA53P89J744249226","fa":"多云","fb":"晴","fc":"3","fd":"-5","fe":"西北风","faurl":"http://img.wanzhao.com/group2/M00/FC/D4/wKgBzVo6GvWAGdIoAAAMpZCscU01578567"},{"ff":"北风","fg":"<3级","fh":"<3级","fi":"12/28","fj":"周四","fk":"良","fl":"96","fm":"90.1","fn":"79.7","fburl":"http://img.wanzhao.com/group2/M00/A2/F4/wKgBy1o6FquAGqEsAAAMpZCscU07233241","fa":"晴","fb":"多云","fc":"5","fd":"-4","fe":"东风","faurl":"http://img.wanzhao.com/group2/M00/FC/D4/wKgBzVo6HGKAaLKnAAA0qvDc30Q5579108"},{"ff":"西北风","fg":"<3级","fh":"<3级","fi":"12/29","fj":"周五","fk":"中度污染","fl":"196","fm":"52.1","fn":"41.4","fburl":"http://img.wanzhao.com/group2/M00/A2/F4/wKgBy1o6FquAGqEsAAAMpZCscU07233241","fa":"多云","fb":"多云","fc":"4","fd":"-3","fe":"西北风","faurl":"http://img.wanzhao.com/group2/M00/FC/D4/wKgBzVo6GvWAGdIoAAAMpZCscU01578567"},{"ff":"西风","fg":"3-4级","fh":"<3级","fi":"12/30","fj":"周六","fk":"轻度污染","fl":"144","fm":"43.4","fn":"37.5","fburl":"http://img.wanzhao.com/group2/M00/A2/F4/wKgBy1o6F9CAA7QoAAA53P89J744249226","fa":"晴","fb":"晴","fc":"5","fd":"-6","fe":"西北风","faurl":"http://img.wanzhao.com/group2/M00/FC/D4/wKgBzVo6HGKAaLKnAAA0qvDc30Q5579108"}],"pm25":"31 优","dqurl":"http://img.wanzhao.com/group2/M00/FC/D4/wKgBzVo6HGKAaLKnAAA0qvDc30Q5579108","dqwd":"1","zwxzs":"弱； 辐射较弱，涂擦SPF12-15、PA+护肤品。","xczs":"较适宜； 无雨且风力较小，易保持清洁度。","ydzs":"较易波动； 血糖较易波动，注意监测。","rq":"12月26日(星期二)","bgurl":"http://img.wanzhao.com/group2/M00/FC/D4/wKgBzVo6HFOAcVytAABO3I2TjKM7159760"}
     */

    private int status;
    private String msg;
    private DataBean data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * xx : 2/7
         * cyzs : 冷； 建议着棉衣加羊毛衫等冬季服装。
         * dqfd : 静风 0级
         * dqtq : 晴
         * xdsd : 32%
         * kqzs : 中； 易感人群应适当减少室外活动。
         * gmzs : 少发； 无明显降温，感冒机率较低。
         * time_weather : [["26日08时","晴","-5℃","南风","<3级","http://img.wanzhao.com/group2/M00/FC/D4/wKgBzVo6HGKAaLKnAAA0qvDc30Q5579108"],["26日11时","晴","1℃","南风","<3级","http://img.wanzhao.com/group2/M00/FC/D4/wKgBzVo6HGKAaLKnAAA0qvDc30Q5579108"],["26日14时","晴","2℃","南风","<3级","http://img.wanzhao.com/group2/M00/FC/D4/wKgBzVo6HGKAaLKnAAA0qvDc30Q5579108"],["26日17时","晴","0℃","南风","<3级","http://img.wanzhao.com/group2/M00/FC/D4/wKgBzVo6HGKAaLKnAAA0qvDc30Q5579108"],["26日20时","晴","-1℃","南风","<3级","http://img.wanzhao.com/group2/M00/A2/F4/wKgBy1o6F9CAA7QoAAA53P89J744249226"],["26日23时","多云","-3℃","南风","<3级","http://img.wanzhao.com/group2/M00/A2/F4/wKgBy1o6FquAGqEsAAAMpZCscU07233241"],["27日02时","多云","-5℃","南风","<3级","http://img.wanzhao.com/group2/M00/A2/F4/wKgBy1o6FquAGqEsAAAMpZCscU07233241"],["27日05时","多云","-5℃","南风","<3级","http://img.wanzhao.com/group2/M00/A2/F4/wKgBy1o6FquAGqEsAAAMpZCscU07233241"],["27日08时","多云","-4℃","南风","<3级","http://img.wanzhao.com/group2/M00/FC/D4/wKgBzVo6GvWAGdIoAAAMpZCscU01578567"]]
         * day_weather : {"temp":"3℃","city":"101010100","cityname":"北京","tempn":"-6℃","weather":"晴间多云转晴转多云，平原地区有轻雾","ws":"<3级","wd":"南风"}
         * ob_5day : [{"ff":"东风","fg":"3-4级","fh":"3-4级","fi":"12/25","fj":"昨天","fk":"","fl":"","fm":"83.5","fn":"66.0","fburl":"http://img.wanzhao.com/group2/M00/A2/F4/wKgBy1o6F9CAA7QoAAA53P89J744249226","fa":"晴","fb":"晴","fc":"4","fd":"-5","fe":"西南风","faurl":"http://img.wanzhao.com/group2/M00/FC/D4/wKgBzVo6HGKAaLKnAAA0qvDc30Q5579108"},{"ff":"南风","fg":"<3级","fh":"<3级","fi":"12/26","fj":"今天","fk":"良","fl":"51","fm":"79.7","fn":"64.7","fburl":"http://img.wanzhao.com/group2/M00/A2/F4/wKgBy1o6FquAGqEsAAAMpZCscU07233241","fa":"晴","fb":"多云","fc":"3","fd":"-6","fe":"南风","faurl":"http://img.wanzhao.com/group2/M00/FC/D4/wKgBzVo6HGKAaLKnAAA0qvDc30Q5579108"},{"ff":"北风","fg":"<3级","fh":"<3级","fi":"12/27","fj":"周三","fk":"轻度污染","fl":"150","fm":"83.1","fn":"79.4","fburl":"http://img.wanzhao.com/group2/M00/A2/F4/wKgBy1o6F9CAA7QoAAA53P89J744249226","fa":"多云","fb":"晴","fc":"3","fd":"-5","fe":"西北风","faurl":"http://img.wanzhao.com/group2/M00/FC/D4/wKgBzVo6GvWAGdIoAAAMpZCscU01578567"},{"ff":"北风","fg":"<3级","fh":"<3级","fi":"12/28","fj":"周四","fk":"良","fl":"96","fm":"90.1","fn":"79.7","fburl":"http://img.wanzhao.com/group2/M00/A2/F4/wKgBy1o6FquAGqEsAAAMpZCscU07233241","fa":"晴","fb":"多云","fc":"5","fd":"-4","fe":"东风","faurl":"http://img.wanzhao.com/group2/M00/FC/D4/wKgBzVo6HGKAaLKnAAA0qvDc30Q5579108"},{"ff":"西北风","fg":"<3级","fh":"<3级","fi":"12/29","fj":"周五","fk":"中度污染","fl":"196","fm":"52.1","fn":"41.4","fburl":"http://img.wanzhao.com/group2/M00/A2/F4/wKgBy1o6FquAGqEsAAAMpZCscU07233241","fa":"多云","fb":"多云","fc":"4","fd":"-3","fe":"西北风","faurl":"http://img.wanzhao.com/group2/M00/FC/D4/wKgBzVo6GvWAGdIoAAAMpZCscU01578567"},{"ff":"西风","fg":"3-4级","fh":"<3级","fi":"12/30","fj":"周六","fk":"轻度污染","fl":"144","fm":"43.4","fn":"37.5","fburl":"http://img.wanzhao.com/group2/M00/A2/F4/wKgBy1o6F9CAA7QoAAA53P89J744249226","fa":"晴","fb":"晴","fc":"5","fd":"-6","fe":"西北风","faurl":"http://img.wanzhao.com/group2/M00/FC/D4/wKgBzVo6HGKAaLKnAAA0qvDc30Q5579108"}]
         * pm25 : 31 优
         * dqurl : http://img.wanzhao.com/group2/M00/FC/D4/wKgBzVo6HGKAaLKnAAA0qvDc30Q5579108
         * dqwd : 1
         * zwxzs : 弱； 辐射较弱，涂擦SPF12-15、PA+护肤品。
         * xczs : 较适宜； 无雨且风力较小，易保持清洁度。
         * ydzs : 较易波动； 血糖较易波动，注意监测。
         * rq : 12月26日(星期二)
         * bgurl : http://img.wanzhao.com/group2/M00/FC/D4/wKgBzVo6HFOAcVytAABO3I2TjKM7159760
         */

        private String xx;
        private String cyzs;
        private String dqfd;
        private String dqtq;
        private String xdsd;
        private String kqzs;
        private String gmzs;
        private DayWeatherBean day_weather;
        private String pm25;
        private String pmms;
        private String dqurl;
        private String dqwd;
        private String zwxzs;
        private String xczs;
        private String ydzs;
        private String rq;
        private String bgurl;
        private List<List<String>> time_weather;
        private List<Ob5dayBean> ob_5day;


        public String getPmms() {
            return pmms;
        }

        public void setPmms(String pmms) {
            this.pmms = pmms;
        }

        public String getXx() {
            return xx;
        }

        public void setXx(String xx) {
            this.xx = xx;
        }

        public String getCyzs() {
            return cyzs;
        }

        public void setCyzs(String cyzs) {
            this.cyzs = cyzs;
        }

        public String getDqfd() {
            return dqfd;
        }

        public void setDqfd(String dqfd) {
            this.dqfd = dqfd;
        }

        public String getDqtq() {
            return dqtq;
        }

        public void setDqtq(String dqtq) {
            this.dqtq = dqtq;
        }

        public String getXdsd() {
            return xdsd;
        }

        public void setXdsd(String xdsd) {
            this.xdsd = xdsd;
        }

        public String getKqzs() {
            return kqzs;
        }

        public void setKqzs(String kqzs) {
            this.kqzs = kqzs;
        }

        public String getGmzs() {
            return gmzs;
        }

        public void setGmzs(String gmzs) {
            this.gmzs = gmzs;
        }

        public DayWeatherBean getDay_weather() {
            return day_weather;
        }

        public void setDay_weather(DayWeatherBean day_weather) {
            this.day_weather = day_weather;
        }

        public String getPm25() {
            return pm25;
        }

        public void setPm25(String pm25) {
            this.pm25 = pm25;
        }

        public String getDqurl() {
            return dqurl;
        }

        public void setDqurl(String dqurl) {
            this.dqurl = dqurl;
        }

        public String getDqwd() {
            return dqwd;
        }

        public void setDqwd(String dqwd) {
            this.dqwd = dqwd;
        }

        public String getZwxzs() {
            return zwxzs;
        }

        public void setZwxzs(String zwxzs) {
            this.zwxzs = zwxzs;
        }

        public String getXczs() {
            return xczs;
        }

        public void setXczs(String xczs) {
            this.xczs = xczs;
        }

        public String getYdzs() {
            return ydzs;
        }

        public void setYdzs(String ydzs) {
            this.ydzs = ydzs;
        }

        public String getRq() {
            return rq;
        }

        public void setRq(String rq) {
            this.rq = rq;
        }

        public String getBgurl() {
            return bgurl;
        }

        public void setBgurl(String bgurl) {
            this.bgurl = bgurl;
        }

        public List<List<String>> getTime_weather() {
            return time_weather;
        }

        public void setTime_weather(List<List<String>> time_weather) {
            this.time_weather = time_weather;
        }

        public List<Ob5dayBean> getOb_5day() {
            return ob_5day;
        }

        public void setOb_5day(List<Ob5dayBean> ob_5day) {
            this.ob_5day = ob_5day;
        }




        public static class DayWeatherBean {
            /**
             * temp : 3℃
             * city : 101010100
             * cityname : 北京
             * tempn : -6℃
             * weather : 晴间多云转晴转多云，平原地区有轻雾
             * ws : <3级
             * wd : 南风
             */

            private String temp;
            private String city;
            private String cityname;
            private String tempn;
            private String weather;
            private String ws;
            private String wd;

            public String getTemp() {
                return temp;
            }

            public void setTemp(String temp) {
                this.temp = temp;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getCityname() {
                return cityname;
            }

            public void setCityname(String cityname) {
                this.cityname = cityname;
            }

            public String getTempn() {
                return tempn;
            }

            public void setTempn(String tempn) {
                this.tempn = tempn;
            }

            public String getWeather() {
                return weather;
            }

            public void setWeather(String weather) {
                this.weather = weather;
            }

            public String getWs() {
                return ws;
            }

            public void setWs(String ws) {
                this.ws = ws;
            }

            public String getWd() {
                return wd;
            }

            public void setWd(String wd) {
                this.wd = wd;
            }

            @Override
            public String toString() {
                return "DayWeatherBean{" +
                        "temp='" + temp + '\'' +
                        ", city='" + city + '\'' +
                        ", cityname='" + cityname + '\'' +
                        ", tempn='" + tempn + '\'' +
                        ", weather='" + weather + '\'' +
                        ", ws='" + ws + '\'' +
                        ", wd='" + wd + '\'' +
                        '}';
            }
        }

        public static class Ob5dayBean {
            /**
             * ff : 东风
             * fg : 3-4级
             * fh : 3-4级
             * fi : 12/25
             * fj : 昨天
             * fk :
             * fl :
             * fm : 83.5
             * fn : 66.0
             * fburl : http://img.wanzhao.com/group2/M00/A2/F4/wKgBy1o6F9CAA7QoAAA53P89J744249226
             * fa : 晴
             * fb : 晴
             * fc : 4
             * fd : -5
             * fe : 西南风
             * faurl : http://img.wanzhao.com/group2/M00/FC/D4/wKgBzVo6HGKAaLKnAAA0qvDc30Q5579108
             */

            private String ff;
            private String fg;
            private String fh;
            private String fi;
            private String fj;
            private String fk;
            private String fl;
            private String fm;
            private String fn;
            private String fburl;
            private String fa;
            private String fb;
            private String fc;
            private String fd;
            private String fe;
            private String faurl;

            public String getFf() {
                return ff;
            }

            public void setFf(String ff) {
                this.ff = ff;
            }

            public String getFg() {
                return fg;
            }

            public void setFg(String fg) {
                this.fg = fg;
            }

            public String getFh() {
                return fh;
            }

            public void setFh(String fh) {
                this.fh = fh;
            }

            public String getFi() {
                return fi;
            }

            public void setFi(String fi) {
                this.fi = fi;
            }

            public String getFj() {
                return fj;
            }

            public void setFj(String fj) {
                this.fj = fj;
            }

            public String getFk() {
                return fk;
            }

            public void setFk(String fk) {
                this.fk = fk;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getFm() {
                return fm;
            }

            public void setFm(String fm) {
                this.fm = fm;
            }

            public String getFn() {
                return fn;
            }

            public void setFn(String fn) {
                this.fn = fn;
            }

            public String getFburl() {
                return fburl;
            }

            public void setFburl(String fburl) {
                this.fburl = fburl;
            }

            public String getFa() {
                return fa;
            }

            public void setFa(String fa) {
                this.fa = fa;
            }

            public String getFb() {
                return fb;
            }

            public void setFb(String fb) {
                this.fb = fb;
            }

            public String getFc() {
                return fc;
            }

            public void setFc(String fc) {
                this.fc = fc;
            }

            public String getFd() {
                return fd;
            }

            public void setFd(String fd) {
                this.fd = fd;
            }

            public String getFe() {
                return fe;
            }

            public void setFe(String fe) {
                this.fe = fe;
            }

            public String getFaurl() {
                return faurl;
            }

            public void setFaurl(String faurl) {
                this.faurl = faurl;
            }

            @Override
            public String toString() {
                return "Ob5dayBean{" +
                        "ff='" + ff + '\'' +
                        ", fg='" + fg + '\'' +
                        ", fh='" + fh + '\'' +
                        ", fi='" + fi + '\'' +
                        ", fj='" + fj + '\'' +
                        ", fk='" + fk + '\'' +
                        ", fl='" + fl + '\'' +
                        ", fm='" + fm + '\'' +
                        ", fn='" + fn + '\'' +
                        ", fburl='" + fburl + '\'' +
                        ", fa='" + fa + '\'' +
                        ", fb='" + fb + '\'' +
                        ", fc='" + fc + '\'' +
                        ", fd='" + fd + '\'' +
                        ", fe='" + fe + '\'' +
                        ", faurl='" + faurl + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "xx='" + xx + '\'' +
                    ", cyzs='" + cyzs + '\'' +
                    ", dqfd='" + dqfd + '\'' +
                    ", dqtq='" + dqtq + '\'' +
                    ", xdsd='" + xdsd + '\'' +
                    ", kqzs='" + kqzs + '\'' +
                    ", gmzs='" + gmzs + '\'' +
                    ", day_weather=" + day_weather +
                    ", pm25='" + pm25 + '\'' +
                    ", dqurl='" + dqurl + '\'' +
                    ", dqwd='" + dqwd + '\'' +
                    ", zwxzs='" + zwxzs + '\'' +
                    ", xczs='" + xczs + '\'' +
                    ", ydzs='" + ydzs + '\'' +
                    ", rq='" + rq + '\'' +
                    ", bgurl='" + bgurl + '\'' +
                    ", time_weather=" + time_weather +
                    ", ob_5day=" + ob_5day +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "DetailedWeatherBean{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
