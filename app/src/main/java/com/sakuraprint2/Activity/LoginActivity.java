package com.sakuraprint2.Activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.sakuraprint2.App;
import com.sakuraprint2.Bean.LoginBean;
import com.sakuraprint2.R;
import com.sakuraprint2.Utils.SpUtil;
import com.sakuraprint2.Utils.UrlUtils;
import com.sakuraprint2.Utils.Utils;
import com.sakuraprint2.Volley.VolleyInterface;
import com.sakuraprint2.Volley.VolleyRequest;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * sakura.printersakura.Activity
 *
 * @author 赵磊
 * @date 2017/11/22
 * 功能描述：
 */
public class LoginActivity extends BaseActivity {

    @BindView(R.id.et_account)
    EditText etAccount;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;

    private Dialog dialog;

    @Override
    protected void ready() {
        super.ready();
        fullScreen();
    }

    @Override
    protected int setthislayout() {
        return R.layout.activcity_login;
    }

    @Override
    protected void initListener() {
    }

    @OnClick(R.id.btn_login)
    void submit() {
        if (TextUtils.isEmpty(etAccount.getText().toString())) {
            Toast.makeText(context, etAccount.getHint().toString(), Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(etPassword.getText().toString())) {
            Toast.makeText(context, etPassword.getHint().toString(), Toast.LENGTH_SHORT).show();
            return;
        }
        if (Utils.isConnected(context)) {
            dialog = Utils.showLoadingDialog(context);
            if (!dialog.isShowing()) {
                dialog.show();
                login(etAccount.getText().toString().trim(), etPassword.getText().toString().trim(), context);
            }
        }
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        App.getQueues().cancelAll("login");
        //反注册EventBus
        EventBus.getDefault().unregister(context);
        System.gc();
    }

    @BindString(R.string.Abnormalserver)
    String Abnormalserver;

    /**
     * 登录
     */
    public void login(String uname, String upassword, final Context context) {
        HashMap<String, String> params = new HashMap<>(2);
        params.put("uname", uname);
        params.put("upassword", upassword);
        VolleyRequest.RequestPost(context, UrlUtils.URL + "login", "login", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                Log.e("RegisterActivity", result);
                try {
                    dialog.dismiss();
                    LoginBean loginBean = new Gson().fromJson(result, LoginBean.class);
                    if ("0".equals(loginBean.getCode())) {
                        SpUtil.putAndApply(context, "qishu", loginBean.getQishu());
                        SpUtil.putAndApply(context, "userid", loginBean.getUser().getUid());
                        SpUtil.putAndApply(context, "username", loginBean.getUser().getUsername());
                        startActivity(new Intent(context, MainActivity.class));
                    } else {
                        Toast.makeText(context, loginBean.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                    loginBean = null;
                    result = null;
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(context, Abnormalserver, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onMyError(VolleyError error) {
                dialog.dismiss();
                error.printStackTrace();
                Toast.makeText(context, Abnormalserver, Toast.LENGTH_SHORT).show();
            }
        });
    }


}



