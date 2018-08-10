package com.sakuraprint2.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.sakuraprint2.Bean.ZhangDanBean;
import com.sakuraprint2.R;
import com.sakuraprint2.Utils.SpUtil;
import com.sakuraprint2.Utils.UrlUtils;
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
public class ZhangDanFragment extends Fragment {

    @BindView(R.id.rv_zhangdan_list)
    WenguoyiRecycleView rvZhangdanList;
    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.LL_empty)
    RelativeLayout LLEmpty;
    Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_zhangdan, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        zhangDan();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    /**
     * 获取账单页面数据
     */
    public void zhangDan() {
        HashMap<String, String> params = new HashMap<>(2);
        params.put("qishu", String.valueOf(SpUtil.get(context, "qishu", "")));
        params.put("appUid", String.valueOf(SpUtil.get(context, "userid", "")));
        params.put("uname", String.valueOf(SpUtil.get(context, "username", "")));
        Log.e("zhangDan", params.toString());
        VolleyRequest.RequestPost(context, UrlUtils.URL + "zhangdan", "zhangdan", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                Log.e("zhangDan", result);
                try {
                    ZhangDanBean zhangDanBean = new Gson().fromJson(result, ZhangDanBean.class);





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