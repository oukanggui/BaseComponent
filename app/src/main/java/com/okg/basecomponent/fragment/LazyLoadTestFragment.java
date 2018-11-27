package com.okg.basecomponent.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.baymax.base.fragment.BaseFragment;
import com.github.nukc.stateview.StateView;
import com.okg.basecomponent.R;

/**
 * @author oukanggui
 * @date 2018/11/26
 * 描述
 */

public class LazyLoadTestFragment extends BaseFragment implements View.OnClickListener{

    private Button btnLoading, btnEmpty, btnRetry;

    @Override
    public int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    public void loadData() {
        //模拟请求数据
        //请求数据前先show Loading
        mStateView.showLoading();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //数据请求完成后，做相应的处理
                mStateView.showContent();
            }
        }, 3000);
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {
        btnLoading = view.findViewById(R.id.btn_loading);
        btnEmpty = view.findViewById(R.id.btn_empty);
        btnRetry = view.findViewById(R.id.btn_retry);
        btnLoading.setOnClickListener(this);
        btnEmpty.setOnClickListener(this);
        btnRetry.setOnClickListener(this);
        //点击重试页面监听处理
        mStateView.setOnRetryClickListener(new StateView.OnRetryClickListener() {
            @Override
            public void onRetryClick() {
                loadData();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_loading:
                //mStateView.showContent();
                loadData();
                break;
            case R.id.btn_empty:
                //mStateView.showEmpty();
                loadEmptyData();
                break;
            case R.id.btn_retry:
                //mStateView.showRetry();
                loadRetryData();
                break;
            default:
                break;
        }
    }

    private void loadEmptyData() {
        //模拟请求数据
        //请求数据前先show Loading
        mStateView.showLoading();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //数据请求完成后，做相应的处理
                mStateView.showEmpty();
            }
        }, 1000);
    }

    private void loadRetryData() {
        //模拟请求数据
        //请求数据前先show Loading
        mStateView.showLoading();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //数据请求完成后，做相应的处理
                mStateView.showRetry();
            }
        }, 1000);
    }
}
