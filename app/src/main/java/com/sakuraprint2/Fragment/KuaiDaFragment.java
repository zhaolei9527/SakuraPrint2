package com.sakuraprint2.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
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
import com.sakuraprint2.Bean.KuaiDaBean;
import com.sakuraprint2.R;
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
public class KuaiDaFragment extends Fragment {

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

    private SakuraLinearLayoutManager line1;
    private SakuraLinearLayoutManager line2;
    private SakuraLinearLayoutManager line3;


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
                        KuaiDaTingYaAdapter kuaiDaTingYaAdapter = new KuaiDaTingYaAdapter(getActivity(), kuaiDaBean.getData1());
                        rvTingya.setAdapter(kuaiDaTingYaAdapter);
                    }

                    if (kuaiDaBean.isCode2()) {
                        KuaiDaDaYinAdapter kuaiDaDaYinAdapter = new KuaiDaDaYinAdapter(getActivity(), kuaiDaBean.getData2());
                        rvDayin.setAdapter(kuaiDaDaYinAdapter);
                    }

                    if (kuaiDaBean.isCode3()) {
                        KuaiDaXiaZhuAdapter kuaiDaXiaZhuAdapter = new KuaiDaXiaZhuAdapter(getActivity(), kuaiDaBean.getData3());
                        rvDayin.setAdapter(kuaiDaXiaZhuAdapter);
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
}