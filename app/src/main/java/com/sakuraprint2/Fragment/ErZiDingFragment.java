package com.sakuraprint2.Fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.sakuraprint2.R;
import com.sakuraprint2.Utils.EasyToast;
import com.sakuraprint2.Utils.UrlUtils;
import com.sakuraprint2.Utils.Utils;
import com.sakuraprint2.Volley.VolleyInterface;
import com.sakuraprint2.Volley.VolleyRequest;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.sakuraprint2.App.context;

/**
 * com.sakuraprint2
 *
 * @author 赵磊
 * @date 2018/7/21
 * 功能描述：
 */
public class ErZiDingFragment extends Fragment implements View.OnClickListener {

    @BindView(R.id.tv_100)
    TextView tv100;
    @BindView(R.id.tv_102)
    TextView tv102;
    @BindView(R.id.tv_101)
    TextView tv101;
    @BindView(R.id.tv_99)
    TextView tv99;
    @BindView(R.id.tv_98)
    TextView tv98;
    @BindView(R.id.tv_97)
    TextView tv97;
    @BindView(R.id.rv_haoma_list)
    com.sakuraprint2.View.WenguoyiRecycleView rvHaomaList;
    Unbinder unbinder;
    private Dialog dialog;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_erziding, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int position = FragmentPagerItem.getPosition(getArguments());
        tv97.setOnClickListener(this);
        tv98.setOnClickListener(this);
        tv99.setOnClickListener(this);
        tv100.setOnClickListener(this);
        tv101.setOnClickListener(this);
        tv102.setOnClickListener(this);
        dialog = Utils.showLoadingDialog(getActivity());
        getdata("100");
    }

    public void getdata(String type) {
        if (Utils.isConnected(getContext())) {
            dialog.show();
            setlog("102");
        } else {
            EasyToast.showShort(getContext(), "网络连接失败，请检查网络");
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_97:
                dialog.show();
                getdata("97");
                break;
            case R.id.tv_98:
                getdata("98");
                break;
            case R.id.tv_99:
                getdata("99");
                break;
            case R.id.tv_100:
                getdata("100");
                break;
            case R.id.tv_101:
                getdata("101");
                break;
            case R.id.tv_102:
                getdata("102");
                break;
            default:
                break;
        }
    }

    /**
     * getinfo
     */
    private void setlog(String type) {
        HashMap<String, String> params = new HashMap<>(1);
        params.put("type", type);
        Log.e("MainActivity", params.toString());
        VolleyRequest.RequestPost(context, UrlUtils.URL + "findTypes1", "findTypes1", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                dialog.dismiss();
                Log.e("MainActivity", result);

            }

            @Override
            public void onMyError(VolleyError error) {
                dialog.dismiss();
                error.printStackTrace();
            }
        });
    }


}