package com.sakuraprint2.Adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
public class KuaiDaDaYinAdapter extends RecyclerView.Adapter<KuaiDaDaYinAdapter.ViewHolder> {

    private Activity mContext;
    private ArrayList<KuaiDaBean.Data2Bean> datas = new ArrayList();

    public ArrayList<KuaiDaBean.Data2Bean> getDatas() {
        return datas;
    }

    public KuaiDaDaYinAdapter(Activity context, List<KuaiDaBean.Data2Bean> msgBeanList) {
        this.mContext = context;
        this.datas.addAll(msgBeanList);
    }

    public void setDatas(List<KuaiDaBean.Data2Bean> datas) {
        this.datas.addAll(datas);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_dayin_layout, parent, false);
        ViewHolder vp = new ViewHolder(view);
        return vp;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
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

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
