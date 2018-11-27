package com.baymax.base.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.baymax.basecomponent.R;
import com.github.nukc.stateview.StateView;

/**
 * @author oukanggui
 * @date 2018/11/11
 * 描述 BaseActivity基类,主要功能如下：
 * 1、支持显示以及设置加载中、数据为空、加载出错重试等布局
 * 2、View以及数据初始化方法回调：
 * @see #initView(Bundle)
 * @see #initData()
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected static final String TAG = BaseActivity.class.getSimpleName();
    public StateView mStateView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //StateView绑定注入到Activity中--默认注入到这个页面中
        mStateView = StateView.inject(this);
        setContentView(getLayoutResId());
        mStateView.setLoadingResource(R.layout.base_loading);
        mStateView.setEmptyResource(R.layout.base_empty);
        mStateView.setRetryResource(R.layout.base_retry);
        initView(savedInstanceState);
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * 子Activity重写该方法初始化布局View
     */
    protected abstract void initView(Bundle savedInstanceState);

    /**
     * 子Activity重写该方法初始化数据
     */
    protected abstract void initData();

    /**
     * 子Activity重写该方法提供布局
     */
    protected abstract int getLayoutResId();

}
