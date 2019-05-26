package com.bw.lib_core.base.mvp;

public interface IBaseView {
    BasePresenter initPresenter();//初始化presenter方法
    void failure(String msg);//请求失败
}
