package com.fxp.mvp.presenter;

import android.app.Activity;

import com.fxp.mvp.base.BasePresenter;
import com.fxp.mvp.entity.DynamicBean;
import com.fxp.mvp.model.DynamicPublishModel;
import com.fxp.mvp.presenter.impl.DynamicPublishPresenterImpl;
import com.fxp.mvp.view.DynamicPublishView;
import com.fxp.mvp.wigdet.listener.MVPListener;

/**
 * Title:       DynamicPublishActivityPresenter
 * <p>
 * Package:     com.fxp.mvp.presenter
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/11/15 6:50 PM
 * <p>
 * Description:
 * <p>
 * <p>
 * Modification History:
 * <p>
 * Date       Author       Version      Description
 * -----------------------------------------------------------------
 * 2018/11/15    fxp       1.0         First Created
 * <p>
 * Github:  https://github.com/fangxiaopeng
 */
public class DynamicPublishPresenter extends BasePresenter<DynamicPublishModel, DynamicPublishView> implements DynamicPublishPresenterImpl{

    public DynamicPublishPresenter(Activity context) {
        super(context);
    }

    @Override
    public void requestData(int pageIndex, int pageSize) {

        final DynamicPublishView mView = getView();

        if (mView == null) return;

        mView.showLoading();

        mModel.requestData(pageIndex, pageSize, new MVPListener<DynamicBean>() {
            @Override
            public void onSuccess(DynamicBean data) {
                mView.hideLoading();
                mView.showDynamic(data);
            }

            @Override
            public void onError() {
                mView.showError();
            }
        });
    }
}
