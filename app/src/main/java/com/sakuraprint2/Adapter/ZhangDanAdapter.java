package com.sakuraprint2.Adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sakuraprint2.Bean.ZhangDanBean;
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
public class ZhangDanAdapter extends RecyclerView.Adapter<ZhangDanAdapter.ViewHolder> {

    private Activity mContext;
    private ArrayList<ZhangDanBean.DataBeanX> datas = new ArrayList();

    public ArrayList<ZhangDanBean.DataBeanX> getDatas() {
        return datas;
    }

    public ZhangDanAdapter(Activity context, List<ZhangDanBean.DataBeanX> msgBeanList) {
        this.mContext = context;
        this.datas.addAll(msgBeanList);
    }

    public void setDatas(List<ZhangDanBean.DataBeanX> datas) {
        this.datas.addAll(datas);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_zhangdan_layout, parent, false);
        ViewHolder vp = new ViewHolder(view);
        return vp;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.tvHuishui.setText("" + datas.get(position).getHuishui());
        holder.tvMoney.setText("" + datas.get(position).getData().get(0).getMoney());
        holder.tvQihao.setText("" + datas.get(position).getData().get(0).getQishu());
        holder.tvYingkui.setText("" + datas.get(position).getData().get(0).getYingkui());
        holder.tvZhongjiang.setText("" + datas.get(position).getData().get(0).getWin());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_qihao)
        TextView tvQihao;
        @BindView(R.id.tv_money)
        TextView tvMoney;
        @BindView(R.id.tv_huishui)
        TextView tvHuishui;
        @BindView(R.id.tv_zhongjiang)
        TextView tvZhongjiang;
        @BindView(R.id.tv_yingkui)
        TextView tvYingkui;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
