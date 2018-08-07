package com.sakuraprint2.Adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.sakuraprint2.Bean.KuaiDaBean;
import com.sakuraprint2.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * com.sakuraprint2.Adapter
 *
 * @author 赵磊
 * @date 2018/8/6
 * 功能描述：
 */
public class KuaiDaXiaZhuAdapter extends RecyclerView.Adapter<KuaiDaXiaZhuAdapter.ViewHolder> {

    private Activity mContext;
    private ArrayList<KuaiDaBean.Data3Bean> datas = new ArrayList();

    public ArrayList<KuaiDaBean.Data3Bean> getDatas() {
        return datas;
    }

    public KuaiDaXiaZhuAdapter(Activity context, List<KuaiDaBean.Data3Bean> msgBeanList) {
        this.mContext = context;
        this.datas.addAll(msgBeanList);
    }

    public void setDatas(List<KuaiDaBean.Data3Bean> datas) {
        this.datas.addAll(datas);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_xiazhu_layout, parent, false);
        ViewHolder vp = new ViewHolder(view);
        return vp;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        if (datas.get(position).getT_status() == 1) {
            holder.tvTui.setVisibility(View.GONE);
            holder.cbTui.setVisibility(View.VISIBLE);
        } else {
            holder.cbTui.setVisibility(View.GONE);
            holder.tvTui.setVisibility(View.VISIBLE);
        }

        holder.tvMoney.setText(datas.get(position).getMoney());
        holder.tvNum.setText(datas.get(position).getMingxi_2());
        holder.tvPeilv.setText(datas.get(position).getOdds());

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_num)
        TextView tvNum;
        @BindView(R.id.tv_peilv)
        TextView tvPeilv;
        @BindView(R.id.tv_money)
        TextView tvMoney;
        @BindView(R.id.tv_tui)
        TextView tvTui;
        @BindView(R.id.cb_tui)
        CheckBox cbTui;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
