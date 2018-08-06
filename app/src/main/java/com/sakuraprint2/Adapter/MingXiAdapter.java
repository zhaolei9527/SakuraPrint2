package com.sakuraprint2.Adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.sakuraprint2.Bean.MingXiBean;
import com.sakuraprint2.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.sakuraprint2.R.id.cb_check;
import static com.sakuraprint2.R.id.tv_money;
import static com.sakuraprint2.R.id.tv_type;
import static com.sakuraprint2.R.id.tv_zhongjiang;

/**
 * com.sakuraprint2.Adapter
 *
 * @author 赵磊
 * @date 2018/8/6
 * 功能描述：
 */
public class MingXiAdapter extends RecyclerView.Adapter<MingXiAdapter.ViewHolder> {

    private Activity mContext;
    private ArrayList<MingXiBean.DataBean> datas = new ArrayList();

    public ArrayList<MingXiBean.DataBean> getDatas() {
        return datas;
    }

    public MingXiAdapter(Activity context, List<MingXiBean.DataBean> msgBeanList) {
        this.mContext = context;
        this.datas.addAll(msgBeanList);
    }

    public void setDatas(List<MingXiBean.DataBean> datas) {
        this.datas.addAll(datas);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_mingxi_layout, parent, false);
        ViewHolder vp = new ViewHolder(view);
        return vp;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {


        holder.tvNum.setText(datas.get(position).getMingxi_2());
        holder.tvMoney.setText(datas.get(position).getMoney());
        holder.tvPeilv.setText(datas.get(position).getOdds());

        if (0 == datas.get(position).getZj()) {
            holder.tvZhongjiang.setText("--");
        } else {
            holder.tvZhongjiang.setText(String.valueOf(datas.get(position).getZj()));
        }

        if ("0".equals(datas.get(position).getJs())) {
            holder.tvType.setText("成功");
        } else if ("1".equals(datas.get(position).getJs())) {
            holder.tvType.setText("中奖");
        } else if ("2".equals(datas.get(position).getJs())) {
            holder.tvType.setText("退码");
        } else {
            holder.tvType.setText("--");
        }

        if (1 == datas.get(position).getT_status()) {
            holder.cbCheck.setVisibility(View.VISIBLE);
        } else {
            holder.cbCheck.setVisibility(View.INVISIBLE);
        }

        holder.cbCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                datas.get(position).setIscheck(b);
            }
        });

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        @BindView(R.id.tv_num)
        TextView tvNum;
        @BindView(tv_money)
        TextView tvMoney;
        @BindView(R.id.tv_peilv)
        TextView tvPeilv;
        @BindView(tv_zhongjiang)
        TextView tvZhongjiang;
        @BindView(tv_type)
        TextView tvType;
        @BindView(cb_check)
        CheckBox cbCheck;

        public ViewHolder(View view) {
            super(view);
            this.rootView = view;
            ButterKnife.bind(this, view);
        }
    }
}
