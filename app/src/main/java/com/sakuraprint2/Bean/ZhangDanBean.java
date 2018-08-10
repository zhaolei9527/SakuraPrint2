package com.sakuraprint2.Bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * com.sakuraprint2.Bean
 *
 * @author 赵磊
 * @date 2018/8/10
 * 功能描述：
 */
public class ZhangDanBean {

    /**
     * money : 0
     * huishui : 0
     * zj : 0
     * yingkui : 0
     * data : {"money":0,"huishui":0,"zj":0,"yingkui":0,"data":[{"status":1,"money":41,"qishu":"1","win":0,"yingkui":-41}],"code":true}
     * code : true
     */

    private int money;
    private int huishui;
    private int zj;
    private int yingkui;
    private DataBeanX data;
    private boolean code;

    public static List<ZhangDanBean> arrayZhangDanBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<ZhangDanBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getHuishui() {
        return huishui;
    }

    public void setHuishui(int huishui) {
        this.huishui = huishui;
    }

    public int getZj() {
        return zj;
    }

    public void setZj(int zj) {
        this.zj = zj;
    }

    public int getYingkui() {
        return yingkui;
    }

    public void setYingkui(int yingkui) {
        this.yingkui = yingkui;
    }

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public boolean isCode() {
        return code;
    }

    public void setCode(boolean code) {
        this.code = code;
    }

    public static class DataBeanX {
        /**
         * money : 0
         * huishui : 0
         * zj : 0
         * yingkui : 0
         * data : [{"status":1,"money":41,"qishu":"1","win":0,"yingkui":-41}]
         * code : true
         */

        private int money;
        private int huishui;
        private int zj;
        private int yingkui;
        private boolean code;
        private List<DataBean> data;

        public static List<DataBeanX> arrayDataBeanXFromData(String str) {

            Type listType = new TypeToken<ArrayList<DataBeanX>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            this.money = money;
        }

        public int getHuishui() {
            return huishui;
        }

        public void setHuishui(int huishui) {
            this.huishui = huishui;
        }

        public int getZj() {
            return zj;
        }

        public void setZj(int zj) {
            this.zj = zj;
        }

        public int getYingkui() {
            return yingkui;
        }

        public void setYingkui(int yingkui) {
            this.yingkui = yingkui;
        }

        public boolean isCode() {
            return code;
        }

        public void setCode(boolean code) {
            this.code = code;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * status : 1
             * money : 41
             * qishu : 1
             * win : 0
             * yingkui : -41
             */

            private int status;
            private int money;
            private String qishu;
            private int win;
            private int yingkui;

            public static List<DataBean> arrayDataBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<DataBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getMoney() {
                return money;
            }

            public void setMoney(int money) {
                this.money = money;
            }

            public String getQishu() {
                return qishu;
            }

            public void setQishu(String qishu) {
                this.qishu = qishu;
            }

            public int getWin() {
                return win;
            }

            public void setWin(int win) {
                this.win = win;
            }

            public int getYingkui() {
                return yingkui;
            }

            public void setYingkui(int yingkui) {
                this.yingkui = yingkui;
            }
        }
    }
}
