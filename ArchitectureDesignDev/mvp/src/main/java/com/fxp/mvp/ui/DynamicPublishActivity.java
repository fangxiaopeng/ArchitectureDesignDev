package com.fxp.mvp.ui;

import com.fxp.mvp.R;
import com.fxp.mvp.base.BaseActivity;
import com.fxp.mvp.entity.DynamicBean;
import com.fxp.mvp.model.DynamicPublishModel;
import com.fxp.mvp.presenter.DynamicPublishPresenter;
import com.fxp.mvp.view.DynamicPublishView;

/**
 * Title:       DynamicPublishActivity
 * <p>
 * Package:     com.fxp.mvp.ui
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/11/15 6:46 PM
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
public class DynamicPublishActivity extends BaseActivity<DynamicPublishPresenter, DynamicPublishModel> implements DynamicPublishView{

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_dynamic_publish;
    }

    @Override
    public void showDynamic(DynamicBean dynamicBean) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError() {

    }
}
