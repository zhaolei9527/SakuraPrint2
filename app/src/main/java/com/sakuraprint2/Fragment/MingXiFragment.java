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
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.sakuraprint2.Adapter.MingXiAdapter;
import com.sakuraprint2.Bean.MingXiBean;
import com.sakuraprint2.R;
import com.sakuraprint2.Utils.EasyToast;
import com.sakuraprint2.Utils.SpUtil;
import com.sakuraprint2.Utils.UrlUtils;
import com.sakuraprint2.View.ProgressView;
import com.sakuraprint2.View.SakuraLinearLayoutManager;
import com.sakuraprint2.View.WenguoyiRecycleView;
import com.sakuraprint2.Volley.VolleyInterface;
import com.sakuraprint2.Volley.VolleyRequest;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.fangx.haorefresh.LoadMoreListener;

import static com.sakuraprint2.App.context;
import static com.sakuraprint2.R.string.Abnormalserver;


/**
 * com.sakuraprint2
 *
 * @author 赵磊
 * @date 2018/7/21
 * 功能描述：
 */
public class MingXiFragment extends Fragment implements View.OnClickListener {

    @BindView(R.id.rv_mingxi_list)
    WenguoyiRecycleView rvOrderList;
    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.LL_empty)
    RelativeLayout LLEmpty;
    Unbinder unbinder;
    @BindView(R.id.btn_search)
    Button btnSearch;
    @BindView(R.id.btn_zhongjiang)
    Button btnZhongjiang;
    @BindView(R.id.btn_tuima)
    Button btnTuima;
    @BindView(R.id.cb_checkall)
    CheckBox cbCheckall;
    private SakuraLinearLayoutManager line;
    private int p = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mingxi, container, false);
        unbinder = ButterKnife.bind(this, view);
        line = new SakuraLinearLayoutManager(context);
        line.setOrientation(LinearLayoutManager.VERTICAL);
        rvOrderList.setLayoutManager(line);
        rvOrderList.setItemAnimator(new DefaultItemAnimator());
        ProgressView progressView = new ProgressView(context);
        progressView.setIndicatorId(ProgressView.BallRotate);
        progressView.setIndicatorColor(getResources().getColor(R.color.colorAccent));
        rvOrderList.setFootLoadingView(progressView);
        rvOrderList.setLoadMoreListener(new LoadMoreListener() {
            @Override
            public void onLoadMore() {
                p = p + 1;
                datas();
            }
        });

        btnSearch.setOnClickListener(this);
        btnTuima.setOnClickListener(this);
        btnZhongjiang.setOnClickListener(this);
        cbCheckall.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                for (int i = 0; i < mingxiListAdapter.getDatas().size(); i++) {
                    if (mingxiListAdapter.getDatas().get(i).getT_status() == 1) {
                        mingxiListAdapter.getDatas().get(i).setIscheck(b);
                    }
                }
                mingxiListAdapter.notifyDataSetChanged();

            }
        });

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        datas();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private MingXiAdapter mingxiListAdapter;

    /**
     * 获取明细数据
     */
    public void datas() {
        HashMap<String, String> params = new HashMap<>(2);
        params.put("qishu", String.valueOf(SpUtil.get(context, "qishu", "")));
        params.put("appUid", String.valueOf(SpUtil.get(context, "userid", "")));
        params.put("uname", String.valueOf(SpUtil.get(context, "username", "")));
        params.put("p", String.valueOf(p));
        VolleyRequest.RequestPost(context, UrlUtils.URL + "datas", "datas", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                Log.e("MingXiFragment", result);
                try {
                    MingXiBean mingXiBean = new Gson().fromJson(result, MingXiBean.class);
                    rvOrderList.loadMoreComplete();
                    if (mingXiBean.isCode()) {
                        LLEmpty.setVisibility(View.GONE);
                        if (1 == p) {
                            mingxiListAdapter = new MingXiAdapter(getActivity(), mingXiBean.getData());
                            rvOrderList.setAdapter(mingxiListAdapter);
                        } else {
                            mingxiListAdapter.setDatas(mingXiBean.getData());
                        }
                        rvOrderList.setCanloadMore(true);
                    } else {
                        rvOrderList.loadMoreEnd();
                        rvOrderList.setCanloadMore(false);
                        if (1 == p) {
                            LLEmpty.setVisibility(View.VISIBLE);
                        } else {
                            EasyToast.showShort(context, R.string.notmore);
                        }
                    }

                    result = null;
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(context, Abnormalserver, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onMyError(VolleyError error) {
                if (p > 1) {
                    p = p - 1;
                }
                error.printStackTrace();
                Toast.makeText(context, Abnormalserver, Toast.LENGTH_SHORT).show();
            }
        });
    }


    /**
     * 获取明细数据
     */
    public void zhongJiangDatas() {
        HashMap<String, String> params = new HashMap<>(2);
        params.put("qishu", String.valueOf(SpUtil.get(context, "qishu", "")));
        params.put("appUid", String.valueOf(SpUtil.get(context, "userid", "")));
        params.put("uname", String.valueOf(SpUtil.get(context, "username", "")));
        params.put("p", String.valueOf(p));
        params.put("js", String.valueOf("1"));
        VolleyRequest.RequestPost(context, UrlUtils.URL + "datas", "datas", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                Log.e("MingXiFragment", result);
                try {
                    MingXiBean mingXiBean = new Gson().fromJson(result, MingXiBean.class);
                    rvOrderList.loadMoreComplete();
                    if (mingXiBean.isCode()) {
                        LLEmpty.setVisibility(View.GONE);
                        if (1 == p) {
                            mingxiListAdapter = new MingXiAdapter(getActivity(), mingXiBean.getData());
                            rvOrderList.setAdapter(mingxiListAdapter);
                        } else {
                            mingxiListAdapter.setDatas(mingXiBean.getData());
                        }
                        rvOrderList.setCanloadMore(true);
                    } else {
                        rvOrderList.loadMoreEnd();
                        rvOrderList.setCanloadMore(false);
                        if (1 == p) {
                            LLEmpty.setVisibility(View.VISIBLE);
                        } else {
                            EasyToast.showShort(context, R.string.notmore);
                        }
                    }

                    result = null;
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(context, Abnormalserver, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onMyError(VolleyError error) {
                if (p > 1) {
                    p = p - 1;
                }
                error.printStackTrace();
                Toast.makeText(context, Abnormalserver, Toast.LENGTH_SHORT).show();
            }
        });
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


    private boolean iszhongjiang = false;

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_search:
                break;
            case R.id.btn_tuima:
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < mingxiListAdapter.getDatas().size(); i++) {
                    if (mingxiListAdapter.getDatas().get(i).ischeck()) {
                        if (i == 0) {
                            stringBuilder.append(mingxiListAdapter.getDatas().get(i).getId());
                        } else {
                            stringBuilder.append("," + mingxiListAdapter.getDatas().get(i).getId());
                        }
                    }
                }
                tuima(stringBuilder.toString());
                break;
            case R.id.btn_zhongjiang:
                p = 1;
                iszhongjiang = !iszhongjiang;
                if (iszhongjiang) {
                    zhongJiangDatas();
                    btnZhongjiang.setText("全部");
                } else {
                    datas();
                    btnZhongjiang.setText("中奖");
                }
                break;
            default:
                break;
        }
    }
}