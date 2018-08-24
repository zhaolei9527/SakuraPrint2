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
 * @date 2018/8/13
 * 功能描述：
 */
public class XiaZhuBean {

    /**
     * code : false
     * titles : 下注金额超过单注上限金额
     */

    private boolean code;
    private String titles;

    public static List<XiaZhuBean> arrayXiaZhuBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<XiaZhuBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public boolean isCode() {
        return code;
    }

    public void setCode(boolean code) {
        this.code = code;
    }

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }
}
