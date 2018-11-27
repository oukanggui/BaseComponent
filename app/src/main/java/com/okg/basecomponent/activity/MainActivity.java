package com.okg.basecomponent.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.baymax.base.activity.BaseTitleBarActivity;
import com.github.nukc.stateview.StateView;
import com.okg.basecomponent.R;

public class MainActivity extends BaseTitleBarActivity implements View.OnClickListener {

    private Button btnLoading, btnEmpty, btnRetry;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setTitle("BaseComponent");
        showBackView(true);
        showRightView(true);
        btnLoading = findViewById(R.id.btn_loading);
        btnEmpty = findViewById(R.id.btn_empty);
        btnRetry = findViewById(R.id.btn_retry);
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
    protected void initData() {
        //加载据
        loadData();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onRightViewClicked() {
        super.onRightViewClicked();
        Toast.makeText(MainActivity.this, "进入TabBarActivity演示页面", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this,TabBarActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onBackViewClicked() {
        mStateView.showContent();
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

    private void loadData() {
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
