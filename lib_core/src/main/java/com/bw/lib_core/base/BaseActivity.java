package com.bw.lib_core.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //EventBus.getDefault().register(this);
//        unbinder = ButterKnife.bind(this);
        setContentView(bindLayoutId());
        initView();
        initData();
    }
    protected abstract void initData();
    protected abstract void initView();
    /*
    * 绑定根布局
    * */
    protected abstract int bindLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        if(unbinder!=null){
//            unbinder.unbind();//解绑butterknife
//        }
        //eventbus销毁
       // EventBus.getDefault().unregister(this);
    }
}
