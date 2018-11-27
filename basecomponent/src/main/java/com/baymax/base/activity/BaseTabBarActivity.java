package com.baymax.base.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;

import com.baymax.basecomponent.R;

import java.util.List;

/**
 * @author oukanggui
 * @date 2018/11/19
 * 描述 导航栏TabBarActivity
 */

public abstract class BaseTabBarActivity extends BaseTitleBarActivity {
    protected ViewPager mViewPager;
    protected TabLayout mTabLayout;
    protected FragmentPagerAdapter mPagerAdapter;

    @Override
    protected void initView(Bundle savedInstanceState) {
        mViewPager = findViewById(R.id.base_viewpager);
        mTabLayout = findViewById(R.id.base_tablayout);
    }

    @Override
    protected void initData() {
        mPagerAdapter = new CommonFragmentPagerAdapter(getSupportFragmentManager(),createFragments(),createPagerTitles());
        mViewPager.setAdapter(mPagerAdapter);
        if (createFragments() != null) {
            mViewPager.setOffscreenPageLimit(createFragments().size());
        }
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_base_tabbar;
    }

    /**
     * 供子类重写创建显示的Fragment
     *
     * */
    protected abstract List<Fragment> createFragments();

    /**
     * 供子类重写创建显示的Title
     *
     * */
    protected abstract List<String> createPagerTitles();

    private class CommonFragmentPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> fragments;
        private List<String> titles;

        public CommonFragmentPagerAdapter(FragmentManager fm, List<Fragment> fragments, List<String> titles) {
            super(fm);
            this.fragments = fragments;
            this.titles = titles;
        }

        @Override
        public int getCount() {
            return titles.size();
        }

        @Override
        public Fragment getItem(int position) {
            return fragments == null ? null : fragments.get(position);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            return super.instantiateItem(container, position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            super.destroyItem(container, position, object);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles == null ? null : titles.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

    }
}
