package com.sakuraprint2.Activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;
import com.sakuraprint2.Fragment.KuaiDaFragment;
import com.sakuraprint2.Fragment.KuaiXuanFragment;
import com.sakuraprint2.Fragment.MingXiFragment;
import com.sakuraprint2.Fragment.RiZhiFragment;
import com.sakuraprint2.Fragment.ZhangDanFragment;
import com.sakuraprint2.Fragment.ZiLiaoFragment;
import com.sakuraprint2.R;

public class MainActivity extends AppCompatActivity {

    private SmartTabLayout viewpagertab;
    private ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add(R.string.a1, MingXiFragment.class)
                .add(R.string.a3, KuaiDaFragment.class)
                .add(R.string.a4, KuaiXuanFragment.class)
                .add(R.string.a5, ZiLiaoFragment.class)
                .add(R.string.a6, ZhangDanFragment.class)
                .add(R.string.a7, RiZhiFragment.class)
                .create());
        viewpager.setAdapter(adapter);
        viewpagertab.setViewPager(viewpager);
    }

    private void initView() {
        viewpagertab = (SmartTabLayout) findViewById(R.id.viewpagertab);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
    }

}
