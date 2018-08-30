package com.sakuraprint2.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.sakuraprint2.Adapter.KuaiDaDaYinAdapter;
import com.sakuraprint2.Adapter.KuaiDaTingYaAdapter;
import com.sakuraprint2.Adapter.KuaiDaXiaZhuAdapter;
import com.sakuraprint2.Bean.AjaxOddBean;
import com.sakuraprint2.Bean.KuaiDaBean;
import com.sakuraprint2.Bean.XiaZhuBean;
import com.sakuraprint2.R;
import com.sakuraprint2.Utils.EasyToast;
import com.sakuraprint2.Utils.SpUtil;
import com.sakuraprint2.Utils.UrlUtils;
import com.sakuraprint2.View.SakuraLinearLayoutManager;
import com.sakuraprint2.View.WenguoyiRecycleView;
import com.sakuraprint2.Volley.VolleyInterface;
import com.sakuraprint2.Volley.VolleyRequest;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.sakuraprint2.App.context;
import static com.sakuraprint2.R.string.Abnormalserver;

/**
 * com.sakuraprint2
 *
 * @author 赵磊
 * @date 2018/7/21
 * 功能描述：
 */
public class KuaiDaFragment extends Fragment implements View.OnClickListener {

    @BindView(R.id.cb_checkalltingya)
    CheckBox cbCheckalltingya;
    @BindView(R.id.rv_tingya)
    WenguoyiRecycleView rvTingya;
    @BindView(R.id.tv_tingya_bishu)
    TextView tvTingyaBishu;
    @BindView(R.id.tv_tingya_money)
    TextView tvTingyaMoney;
    @BindView(R.id.btn_fangda_tingya)
    Button btnFangdaTingya;
    @BindView(R.id.btn_delete_tingya)
    Button btnDeleteTingya;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_user)
    TextView tvUser;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.rv_dayin)
    WenguoyiRecycleView rvDayin;
    @BindView(R.id.tv_dayin_bishu)
    TextView tvDayinBishu;
    @BindView(R.id.tv_dayin_money)
    TextView tvDayinMoney;
    @BindView(R.id.btn_qingkong)
    Button btnQingkong;
    @BindView(R.id.btn_dayin)
    Button btnDayin;
    @BindView(R.id.tv_qishu)
    TextView tvQishu;
    @BindView(R.id.rv_xiazhu)
    WenguoyiRecycleView rvXiazhu;
    @BindView(R.id.et_haoma)
    EditText etHaoma;
    @BindView(R.id.et_money)
    EditText etMoney;
    @BindView(R.id.cb_sizixian)
    CheckBox cbSizixian;
    @BindView(R.id.cb_quanzhuan)
    CheckBox cbQuanzhuan;
    @BindView(R.id.peilv)
    TextView peilv;
    @BindView(R.id.kexia)
    TextView kexia;
    Unbinder unbinder;
    @BindView(R.id.btn5)
    Button btn5;
    @BindView(R.id.btn4)
    Button btn4;
    @BindView(R.id.btn3)
    Button btn3;
    @BindView(R.id.btn2)
    Button btn2;
    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.btn6)
    Button btn6;
    @BindView(R.id.btn7)
    Button btn7;
    @BindView(R.id.btn8)
    Button btn8;
    @BindView(R.id.btn9)
    Button btn9;
    @BindView(R.id.btn0)
    Button btn0;
    @BindView(R.id.btnx)
    Button btnx;
    @BindView(R.id.btn_submit)
    Button btnSubmit;
    @BindView(R.id.btn_tuima)
    Button btnTuima;

    private SakuraLinearLayoutManager line1;
    private SakuraLinearLayoutManager line2;
    private SakuraLinearLayoutManager line3;

    private boolean ishaoma = true;
    private boolean ismoney = false;
    private KuaiDaTingYaAdapter kuaiDaTingYaAdapter;
    private KuaiDaDaYinAdapter kuaiDaDaYinAdapter;
    private KuaiDaXiaZhuAdapter kuaiDaXiaZhuAdapter;
    private StringBuffer stringBuffer;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kuaida, container, false);
        unbinder = ButterKnife.bind(this, view);

        line1 = new SakuraLinearLayoutManager(context);
        line1.setOrientation(LinearLayoutManager.VERTICAL);
        rvTingya.setLayoutManager(line1);
        rvTingya.setItemAnimator(new DefaultItemAnimator());

        line2 = new SakuraLinearLayoutManager(context);
        line2.setOrientation(LinearLayoutManager.VERTICAL);
        rvDayin.setLayoutManager(line2);
        rvDayin.setItemAnimator(new DefaultItemAnimator());

        line3 = new SakuraLinearLayoutManager(context);
        line3.setOrientation(LinearLayoutManager.VERTICAL);
        rvXiazhu.setLayoutManager(line3);
        rvXiazhu.setItemAnimator(new DefaultItemAnimator());

        etHaoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ishaoma = true;
                ismoney = false;
                etHaoma.setText("");
                btnx.setText("x");
            }
        });

        etMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ismoney = true;
                ishaoma = false;
                etMoney.setText("");
                btnx.setText(".");
            }
        });

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnx.setOnClickListener(this);
        btnSubmit.setOnClickListener(this);
        btnTuima.setOnClickListener(this);

        cbSizixian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cbQuanzhuan.isChecked()) {
                    cbQuanzhuan.setChecked(false);
                }
            }
        });

        cbQuanzhuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cbSizixian.isChecked()) {
                    cbSizixian.setChecked(false);
                }
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        kuaidaData();
    }

    /**
     * 获取快打页面数据
     */
    public void kuaidaData() {
        HashMap<String, String> params = new HashMap<>(2);
        params.put("qishu", String.valueOf(SpUtil.get(context, "qishu", "")));
        params.put("appUid", String.valueOf(SpUtil.get(context, "userid", "")));
        params.put("uname", String.valueOf(SpUtil.get(context, "username", "")));
        VolleyRequest.RequestPost(context, UrlUtils.URL + "kuaida_data", "kuaida_data", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                Log.e("kuaidaData", result);
                try {

                    KuaiDaBean kuaiDaBean = new Gson().fromJson(result, KuaiDaBean.class);

                    if (kuaiDaBean.isCode1()) {
                        kuaiDaTingYaAdapter = new KuaiDaTingYaAdapter(getActivity(), kuaiDaBean.getData1());
                        rvTingya.setAdapter(kuaiDaTingYaAdapter);
                    }

                    if (kuaiDaBean.isCode2()) {
                        kuaiDaDaYinAdapter = new KuaiDaDaYinAdapter(getActivity(), kuaiDaBean.getData2());
                        rvDayin.setAdapter(kuaiDaDaYinAdapter);
                    }

                    if (kuaiDaBean.isCode3()) {
                        kuaiDaXiaZhuAdapter = new KuaiDaXiaZhuAdapter(getActivity(), kuaiDaBean.getData3());
                        rvXiazhu.setAdapter(kuaiDaXiaZhuAdapter);
                    }

                    result = null;
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(context, Abnormalserver, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onMyError(VolleyError error) {
                error.printStackTrace();
                Toast.makeText(context, Abnormalserver, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onClick(View view) {

        if (ishaoma) {
            if (etHaoma.getText().toString().length() >= 4) {
                ajaxOdd();
                ishaoma = false;
                ismoney = true;
                btnx.setText(".");
            }
        }

        switch (view.getId()) {

            case R.id.btn0:
                if (ishaoma) {
                    etHaoma.setText(etHaoma.getText().toString() + "0");
                } else if (ismoney) {
                    etMoney.setText(etMoney.getText().toString() + "0");
                }
                break;
            case R.id.btn1:
                if (ishaoma) {
                    etHaoma.setText(etHaoma.getText().toString() + "1");
                } else if (ismoney) {
                    etMoney.setText(etMoney.getText().toString() + "1");
                }
                break;
            case R.id.btn2:
                if (ishaoma) {
                    etHaoma.setText(etHaoma.getText().toString() + "2");
                } else if (ismoney) {
                    etMoney.setText(etMoney.getText().toString() + "2");
                }
                break;
            case R.id.btn3:
                if (ishaoma) {
                    etHaoma.setText(etHaoma.getText().toString() + "3");
                } else if (ismoney) {
                    etMoney.setText(etMoney.getText().toString() + "3");
                }
                break;
            case R.id.btn4:
                if (ishaoma) {
                    etHaoma.setText(etHaoma.getText().toString() + "4");
                } else if (ismoney) {
                    etMoney.setText(etMoney.getText().toString() + "4");
                }
                break;
            case R.id.btn5:
                if (ishaoma) {
                    etHaoma.setText(etHaoma.getText().toString() + "5");
                } else if (ismoney) {
                    etMoney.setText(etMoney.getText().toString() + "5");
                }
                break;
            case R.id.btn6:
                if (ishaoma) {
                    etHaoma.setText(etHaoma.getText().toString() + "6");
                } else if (ismoney) {
                    etMoney.setText(etMoney.getText().toString() + "6");
                }
                break;
            case R.id.btn7:
                if (ishaoma) {
                    etHaoma.setText(etHaoma.getText().toString() + "7");
                } else if (ismoney) {
                    etMoney.setText(etMoney.getText().toString() + "7");
                }
                break;
            case R.id.btn8:
                if (ishaoma) {
                    etHaoma.setText(etHaoma.getText().toString() + "8");
                } else if (ismoney) {
                    etMoney.setText(etMoney.getText().toString() + "8");
                }
                break;
            case R.id.btn9:
                if (ishaoma) {
                    etHaoma.setText(etHaoma.getText().toString() + "9");
                } else if (ismoney) {
                    etMoney.setText(etMoney.getText().toString() + "9");
                }
                break;
            case R.id.btnx:
                if (ishaoma) {
                    etHaoma.setText(etHaoma.getText().toString() + "x");
                } else if (ismoney) {
                    etMoney.setText(etMoney.getText().toString() + ".");
                }
                break;
            case R.id.btn_submit:

                if (TextUtils.isEmpty(etHaoma.getText().toString())) {
                    EasyToast.showShort(context, "请输入下注号码");
                    return;
                }

                if (TextUtils.isEmpty(etMoney.getText().toString())) {
                    EasyToast.showShort(context, "请输入下注金额");
                    return;
                }

//                double v = Double.parseDouble(etMoney.getText().toString());
//                if (v < 1) {
//                    EasyToast.showShort(context, "下注金额不能小于1");
//                    return;
//                }

                xiazhu();
                break;
            case R.id.btn_tuima:

                for (int i = 0; i < kuaiDaXiaZhuAdapter.getDatas().size(); i++) {
                    if (9 == kuaiDaXiaZhuAdapter.getDatas().get(i).getT_status()) {
                        stringBuffer = new StringBuffer();
                        if (stringBuffer.length() > 0) {
                            stringBuffer.append(",");
                            stringBuffer.append(kuaiDaXiaZhuAdapter.getDatas().get(i).getId());
                        } else {
                            stringBuffer.append(kuaiDaXiaZhuAdapter.getDatas().get(i).getId());
                        }
                    }
                }

                Log.e("KuaiDaFragment", stringBuffer.toString());

                break;
            default:
                break;
        }
    }

    /**
     * 退码
     */
    public void tuima(String tuimaid) {
        HashMap<String, String> params = new HashMap<>(2);
        params.put("qishu", String.valueOf(SpUtil.get(context, "qishu", "")));
        params.put("appUid", String.valueOf(SpUtil.get(context, "userid", "")));
        params.put("uname", String.valueOf(SpUtil.get(context, "username", "")));
        params.put("tuimaid", tuimaid);
        VolleyRequest.RequestPost(context, UrlUtils.URL + "tuima", "tuima", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                Log.e("tuima", result);
                try {


                    result = null;
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(context, Abnormalserver, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onMyError(VolleyError error) {
                error.printStackTrace();
                Toast.makeText(context, Abnormalserver, Toast.LENGTH_SHORT).show();
            }
        });
    }


    /**
     * 下注
     */
    public void xiazhu() {
        HashMap<String, String> params = new HashMap<>(2);
        params.put("moneys", etMoney.getText().toString());
        params.put("number", etHaoma.getText().toString());
        params.put("qishu", String.valueOf(SpUtil.get(context, "qishu", "")));
        params.put("appUid", String.valueOf(SpUtil.get(context, "userid", "")));
        params.put("uname", String.valueOf(SpUtil.get(context, "username", "")));
        if (cbSizixian.isChecked()) {
            params.put("types", "1");
        }
        if (cbQuanzhuan.isChecked()) {
            params.put("types", "2");
        }
        VolleyRequest.RequestPost(context, UrlUtils.URL + "xiazhu", "xiazhu", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                Log.e("RegisterActivity", result);
                try {
                    XiaZhuBean xiaZhuBean = new Gson().fromJson(result, XiaZhuBean.class);
                    if (xiaZhuBean.isCode()) {
                        etMoney.setText("");
                        etHaoma.setText("");
                        kuaidaData();
                    }
                    EasyToast.showShort(context, xiaZhuBean.getTitles()
                    );
                    result = null;
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(context, Abnormalserver, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onMyError(VolleyError error) {
                error.printStackTrace();
                Toast.makeText(context, Abnormalserver, Toast.LENGTH_SHORT).show();
            }
        });
    }


    /**
     * 登录
     */
    public void ajaxOdd() {
        HashMap<String, String> params = new HashMap<>(2);
        params.put("number", etHaoma.getText().toString());
        params.put("qishu", String.valueOf(SpUtil.get(context, "qishu", "")));
        params.put("appUid", String.valueOf(SpUtil.get(context, "userid", "")));
        params.put("uname", String.valueOf(SpUtil.get(context, "username", "")));
        if (cbSizixian.isChecked()) {
            params.put("types", "1");
        }
        if (cbQuanzhuan.isChecked()) {
            params.put("types", "2");
        }
        VolleyRequest.RequestPost(context, UrlUtils.URL + "ajax_odd", "ajax_odd", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                Log.e("RegisterActivity", result);
                try {
                    AjaxOddBean ajaxOddBean = new Gson().fromJson(result, AjaxOddBean.class);
                    if (ajaxOddBean.isCode()) {
                        peilv.setText(ajaxOddBean.getData().get(0));
                        kexia.setText(ajaxOddBean.getData().get(1));
                    } else {
                        EasyToast.showShort(context, "请输入有效号码");
                        etHaoma.setText("");
                        etMoney.setText("");
                    }
                    ajaxOddBean = null;
                    result = null;
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(context, Abnormalserver, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onMyError(VolleyError error) {
                error.printStackTrace();
                Toast.makeText(context, Abnormalserver, Toast.LENGTH_SHORT).show();
            }
        });
    }


}