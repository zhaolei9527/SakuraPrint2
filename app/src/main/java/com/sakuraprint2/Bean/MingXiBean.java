package com.sakuraprint2.Bean;

import java.util.List;

/**
 * com.sakuraprint2.Bean
 *
 * @author 赵磊
 * @date 2018/8/6
 * 功能描述：
 */
public class MingXiBean {

    /**
     * money : 0
     * data : [{"id":"12","did":"201808061154524138","username":"user1","addtime":"2018-08-06 11:54","mingxi_1":"4定","mingxi_2":"2345","mingxi_3":"定","odds":"9800","money":"1.00","js":"0","status":"0","win":"0","zj":0,"yingkui":-1,"t_status":2},{"id":"11","did":"201808061154498377","username":"user1","addtime":"2018-08-06 11:54","mingxi_1":"4定","mingxi_2":"1234","mingxi_3":"定","odds":"9800","money":"1.00","js":"0","status":"0","win":"0","zj":0,"yingkui":-1,"t_status":2}]
     * code : true
     * sum : 2
     * show : 共 2 条 &nbsp; 1/1 页
     * qishu : 1
     */

    private int money;
    private boolean code;
    private String sum;
    private String show;
    private String qishu;
    private List<DataBean> data;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public boolean isCode() {
        return code;
    }

    public void setCode(boolean code) {
        this.code = code;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show;
    }

    public String getQishu() {
        return qishu;
    }

    public void setQishu(String qishu) {
        this.qishu = qishu;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 12
         * did : 201808061154524138
         * username : user1
         * addtime : 2018-08-06 11:54
         * mingxi_1 : 4定
         * mingxi_2 : 2345
         * mingxi_3 : 定
         * odds : 9800
         * money : 1.00
         * js : 0
         * status : 0
         * win : 0
         * zj : 0
         * yingkui : -1
         * t_status : 2
         */

        private String id;
        private String did;
        private String username;
        private String addtime;
        private String mingxi_1;
        private String mingxi_2;
        private String mingxi_3;
        private String odds;
        private String money;
        private String js;
        private String status;
        private String win;
        private int zj;
        private int yingkui;
        private int t_status;

        public boolean ischeck() {
            return ischeck;
        }

        public void setIscheck(boolean ischeck) {
            this.ischeck = ischeck;
        }

        private boolean ischeck;


        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDid() {
            return did;
        }

        public void setDid(String did) {
            this.did = did;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getAddtime() {
            return addtime;
        }

        public void setAddtime(String addtime) {
            this.addtime = addtime;
        }

        public String getMingxi_1() {
            return mingxi_1;
        }

        public void setMingxi_1(String mingxi_1) {
            this.mingxi_1 = mingxi_1;
        }

        public String getMingxi_2() {
            return mingxi_2;
        }

        public void setMingxi_2(String mingxi_2) {
            this.mingxi_2 = mingxi_2;
        }

        public String getMingxi_3() {
            return mingxi_3;
        }

        public void setMingxi_3(String mingxi_3) {
            this.mingxi_3 = mingxi_3;
        }

        public String getOdds() {
            return odds;
        }

        public void setOdds(String odds) {
            this.odds = odds;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getJs() {
            return js;
        }

        public void setJs(String js) {
            this.js = js;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getWin() {
            return win;
        }

        public void setWin(String win) {
            this.win = win;
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

        public int getT_status() {
            return t_status;
        }

        public void setT_status(int t_status) {
            this.t_status = t_status;
        }
    }
}
