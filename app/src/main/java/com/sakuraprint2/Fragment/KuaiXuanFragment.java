package com.sakuraprint2.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.sakuraprint2.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * com.sakuraprint2
 *
 * @author 赵磊
 * @date 2018/7/21
 * 功能描述：
 */
public class KuaiXuanFragment extends Fragment implements View.OnClickListener {

    @BindView(R.id.tv_erding)
    TextView tvErding;
    @BindView(R.id.tv_sanding)
    TextView tvSanding;
    @BindView(R.id.tv_siding)
    TextView tvSiding;
    @BindView(R.id.tv_erxian)
    TextView tvErxian;
    @BindView(R.id.tv_sanxian)
    TextView tvSanxian;
    @BindView(R.id.tv_sixian)
    TextView tvSixian;
    @BindView(R.id.fl_content)
    FrameLayout flContent;
    Unbinder unbinder;
    private ErDingFragment fragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kuaixuan, container, false);
        unbinder = ButterKnife.bind(this, view);

        tvErding.setOnClickListener(this);
        tvSanding.setOnClickListener(this);
        tvSiding.setOnClickListener(this);

        tvErxian.setOnClickListener(this);
        tvSanxian.setOnClickListener(this);
        tvSixian.setOnClickListener(this);

        ErDingFragment fragmentErDing = new ErDingFragment();
        fragmentManager = getFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fl_content, fragmentErDing);
        transaction.commit();
        tvErding.setBackgroundColor(getResources().getColor(R.color.bgtitle));
        tvErding.setTextColor(getResources().getColor(R.color.bgfff));

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_erding:
                ErDingFragment fragmentErDing = new ErDingFragment();
                fragmentManager = getFragmentManager();
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fl_content, fragmentErDing);
                transaction.commit();

                tvErding.setBackgroundColor(getResources().getColor(R.color.bgtitle));
                tvErding.setTextColor(getResources().getColor(R.color.bgfff));

                tvSanding.setBackgroundColor(getResources().getColor(R.color.bgfff));
                tvSanding.setTextColor(getResources().getColor(R.color.text333));
                tvSiding.setBackgroundColor(getResources().getColor(R.color.bgfff));
                tvSiding.setTextColor(getResources().getColor(R.color.text333));
                tvErxian.setBackgroundColor(getResources().getColor(R.color.bgfff));
                tvErxian.setTextColor(getResources().getColor(R.color.text333));
                tvSanxian.setBackgroundColor(getResources().getColor(R.color.bgfff));
                tvSanxian.setTextColor(getResources().getColor(R.color.text333));
                tvSixian.setBackgroundColor(getResources().getColor(R.color.bgfff));
                tvSixian.setTextColor(getResources().getColor(R.color.text333));

                break;
            case R.id.tv_sanding:
                SanDingFragment fragmentSanDing = new SanDingFragment();
                fragmentManager = getFragmentManager();
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fl_content, fragmentSanDing);
                transaction.commit();

                tvSanding.setBackgroundColor(getResources().getColor(R.color.bgtitle));
                tvSanding.setTextColor(getResources().getColor(R.color.bgfff));

                tvErding.setBackgroundColor(getResources().getColor(R.color.bgfff));
                tvErding.setTextColor(getResources().getColor(R.color.text333));
                tvSiding.setBackgroundColor(getResources().getColor(R.color.bgfff));
                tvSiding.setTextColor(getResources().getColor(R.color.text333));
                tvErxian.setBackgroundColor(getResources().getColor(R.color.bgfff));
                tvErxian.setTextColor(getResources().getColor(R.color.text333));
                tvSanxian.setBackgroundColor(getResources().getColor(R.color.bgfff));
                tvSanxian.setTextColor(getResources().getColor(R.color.text333));
                tvSixian.setBackgroundColor(getResources().getColor(R.color.bgfff));
                tvSixian.setTextColor(getResources().getColor(R.color.text333));

                break;
            case R.id.tv_siding:
                SiDingFragment fragmentSiDing = new SiDingFragment();
                fragmentManager = getFragmentManager();
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fl_content, fragmentSiDing);
                transaction.commit();

                tvSiding.setBackgroundColor(getResources().getColor(R.color.bgtitle));
                tvSiding.setTextColor(getResources().getColor(R.color.bgfff));

                tvErding.setBackgroundColor(getResources().getColor(R.color.bgfff));
                tvErding.setTextColor(getResources().getColor(R.color.text333));
                tvSanding.setBackgroundColor(getResources().getColor(R.color.bgfff));
                tvSanding.setTextColor(getResources().getColor(R.color.text333));
                tvErxian.setBackgroundColor(getResources().getColor(R.color.bgfff));
                tvErxian.setTextColor(getResources().getColor(R.color.text333));
                tvSanxian.setBackgroundColor(getResources().getColor(R.color.bgfff));
                tvSanxian.setTextColor(getResources().getColor(R.color.text333));
                tvSixian.setBackgroundColor(getResources().getColor(R.color.bgfff));
                tvSixian.setTextColor(getResources().getColor(R.color.text333));
                break;
            case R.id.tv_erxian:
                ErXianFragment fragmentErXian = new ErXianFragment();
                fragmentManager = getFragmentManager();
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fl_content, fragmentErXian);
                transaction.commit();

                tvErxian.setBackgroundColor(getResources().getColor(R.color.bgtitle));
                tvErxian.setTextColor(getResources().getColor(R.color.bgfff));

                tvErding.setBackgroundColor(getResources().getColor(R.color.bgfff));
                tvErding.setTextColor(getResources().getColor(R.color.text333));
                tvSanding.setBackgroundColor(getResources().getColor(R.color.bgfff));
                tvSanding.setTextColor(getResources().getColor(R.color.text333));
                tvSiding.setBackgroundColor(getResources().getColor(R.color.bgfff));
                tvSiding.setTextColor(getResources().getColor(R.color.text333));
                tvSanxian.setBackgroundColor(getResources().getColor(R.color.bgfff));
                tvSanxian.setTextColor(getResources().getColor(R.color.text333));
                tvSixian.setBackgroundColor(getResources().getColor(R.color.bgfff));
                tvSixian.setTextColor(getResources().getColor(R.color.text333));
                break;
            case R.id.tv_sanxian:
                SanXianFragment fragmentSanXian = new SanXianFragment();
                fragmentManager = getFragmentManager();
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fl_content, fragmentSanXian);
                transaction.commit();

                tvSanxian.setBackgroundColor(getResources().getColor(R.color.bgtitle));
                tvSanxian.setTextColor(getResources().getColor(R.color.bgfff));

                tvErding.setBackgroundColor(getResources().getColor(R.color.bgfff));
                tvErding.setTextColor(getResources().getColor(R.color.text333));
                tvSanding.setBackgroundColor(getResources().getColor(R.color.bgfff));
                tvSanding.setTextColor(getResources().getColor(R.color.text333));
                tvSiding.setBackgroundColor(getResources().getColor(R.color.bgfff));
                tvSiding.setTextColor(getResources().getColor(R.color.text333));
                tvErxian.setBackgroundColor(getResources().getColor(R.color.bgfff));
                tvErxian.setTextColor(getResources().getColor(R.color.text333));
                tvSixian.setBackgroundColor(getResources().getColor(R.color.bgfff));
                tvSixian.setTextColor(getResources().getColor(R.color.text333));
                break;
            case R.id.tv_sixian:
                SiXianFragment fragmentSiXian = new SiXianFragment();
                fragmentManager = getFragmentManager();
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fl_content, fragmentSiXian);
                transaction.commit();

                tvSixian.setBackgroundColor(getResources().getColor(R.color.bgtitle));
                tvSixian.setTextColor(getResources().getColor(R.color.bgfff));

                tvErding.setBackgroundColor(getResources().getColor(R.color.bgfff));
                tvErding.setTextColor(getResources().getColor(R.color.text333));
                tvSanding.setBackgroundColor(getResources().getColor(R.color.bgfff));
                tvSanding.setTextColor(getResources().getColor(R.color.text333));
                tvSiding.setBackgroundColor(getResources().getColor(R.color.bgfff));
                tvSiding.setTextColor(getResources().getColor(R.color.text333));
                tvErxian.setBackgroundColor(getResources().getColor(R.color.bgfff));
                tvErxian.setTextColor(getResources().getColor(R.color.text333));
                tvSanxian.setBackgroundColor(getResources().getColor(R.color.bgfff));
                tvSanxian.setTextColor(getResources().getColor(R.color.text333));
                break;
            default:
                break;

        }
    }
}