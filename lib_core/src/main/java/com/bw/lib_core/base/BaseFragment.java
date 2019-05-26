package com.bw.lib_core.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseFragment extends Fragment {
    private boolean isInitView=false;
    private boolean isVisible=false;
    private Unbinder unbinder;
    private View contentview;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(setLayoutResourceID(), container, false);
        /*isInitView=true;
        isCanLoadData();*/
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        setUpView(view);
        lazyLoad();
        initData();
    }

    /*
     * 一些View的相关操作
     * */
    public abstract void setUpView(View view);

/*    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        //isVisibleToUser这个boolean值表示:该Fragment的UI 用户是否可见，获取该标志记录下来
        if (isVisibleToUser) {
            isVisible = true;
            isCanLoadData();
        } else {
            isVisible = false;
        }
    }*/

    public abstract int setLayoutResourceID();
    public abstract void initData();
    /*
    *
    * 加载要显示的数据*/
    public abstract void lazyLoad();
 /*   private void isCanLoadData(){
        //所以条件是view初始化完成并且对用户可见
        if(isInitView && isVisible){
            lazyLoad();
        }
        //防止重复加载数据
        isInitView=false;
        isVisible=false;
    }*/
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
