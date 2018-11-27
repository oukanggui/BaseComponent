package com.okg.basecomponent.activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.baymax.base.activity.BaseTabBarActivity;
import com.okg.basecomponent.fragment.LazyLoadTestFragment;

import java.util.ArrayList;
import java.util.List;

public class TabBarActivity extends BaseTabBarActivity {

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        setTitle("TabBarActivity");
        showBackView(true);
        showRightView(false);
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected List<Fragment> createFragments() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new LazyLoadTestFragment());
        fragments.add(new LazyLoadTestFragment());
        fragments.add(new LazyLoadTestFragment());
        return fragments;
    }

    @Override
    protected List<String> createPagerTitles() {
        List<String> pagerTitles = new ArrayList<>();
        pagerTitles.add("tab1");
        pagerTitles.add("tab2");
        pagerTitles.add("tab3");
        return pagerTitles;
    }
}
