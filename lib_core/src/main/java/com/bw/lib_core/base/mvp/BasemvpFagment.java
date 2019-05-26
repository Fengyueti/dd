package com.bw.lib_core.base.mvp;

import com.bw.lib_core.base.BaseFragment;

public abstract class BasemvpFagment<M extends IBaseModel,P extends BasePresenter> extends BaseFragment implements IBaseView{
    public M model;
    public P presenter;

    @Override
    public void lazyLoad() {
        presenter= (P) initPresenter();
        if(presenter!=null){
            model = (M) presenter.getModel();
            if(model!=null){
                presenter.attach(model,this);
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(presenter!=null){
            presenter.dettach();
        }
    }
}
