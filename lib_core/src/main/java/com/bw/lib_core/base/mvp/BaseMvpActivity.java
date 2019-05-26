package com.bw.lib_core.base.mvp;

import com.bw.lib_core.base.BaseActivity;

public abstract class BaseMvpActivity<M extends IBaseModel,P extends BasePresenter> extends BaseActivity implements IBaseView {
    public P presenter;
    public M model;

    @Override
    protected void initData() {
        presenter= (P) initPresenter();
        if(presenter!=null){
            model = (M) presenter.getModel();
            if(model!=null){
                presenter.attach(model,this);
            }
        }
        inidatas();
    }

    protected abstract void inidatas();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(presenter!=null){
            presenter.dettach();
        }
    }
}
