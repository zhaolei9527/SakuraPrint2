package com.sakuraprint2.Activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;
import com.sakuraprint2.Fragment.DemoFragment;
import com.sakuraprint2.Fragment.ErZiDingFragment;
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
                .add(R.string.a1, DemoFragment.class)
                .add(R.string.a2, ErZiDingFragment.class)
                .add(R.string.a3, DemoFragment.class)
                .add(R.string.a4, DemoFragment.class)
                .add(R.string.a5, DemoFragment.class)
                .add(R.string.a6, DemoFragment.class)
                .create());

        viewpager.setAdapter(adapter);
        viewpagertab.setViewPager(viewpager);

    }

    private void initView() {
        viewpagertab = (SmartTabLayout) findViewById(R.id.viewpagertab);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
    }

}
