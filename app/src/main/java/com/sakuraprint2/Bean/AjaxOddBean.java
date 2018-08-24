package com.sakuraprint2.Bean;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * com.sakuraprint2.Bean
 *
 * @author 赵磊
 * @date 2018/8/24
 * 功能描述：
 */
public class AjaxOddBean {


    /**
     * code : true
     * 0 : 1
     * 1 : 4定
     * 2 : 1234
     * 3 : 4定
     * 4 : 定
     * data : ["9800",99,"10","1",0,"1234"]
     */

    private boolean code;
    @SerializedName("0")
    private int _$0;
    @SerializedName("1")
    private String _$1;
    @SerializedName("2")
    private String _$2;
    @SerializedName("3")
    private String _$3;
    @SerializedName("4")
    private String _$4;
    private List<String> data;

    public static List<AjaxOddBean> arrayAjaxOddBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<AjaxOddBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public boolean isCode() {
        return code;
    }

    public void setCode(boolean code) {
        this.code = code;
    }

    public int get_$0() {
        return _$0;
    }

    public void set_$0(int _$0) {
        this._$0 = _$0;
    }

    public String get_$1() {
        return _$1;
    }

    public void set_$1(String _$1) {
        this._$1 = _$1;
    }

    public String get_$2() {
        return _$2;
    }

    public void set_$2(String _$2) {
        this._$2 = _$2;
    }

    public String get_$3() {
        return _$3;
    }

    public void set_$3(String _$3) {
        this._$3 = _$3;
    }

    public String get_$4() {
        return _$4;
    }

    public void set_$4(String _$4) {
        this._$4 = _$4;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
