package com.fxp.mvp.base;

import android.app.Activity;
import android.os.Bundle;

import com.fxp.mvp.utils.CreateUtil;

/**
 * Title:       BaseActivity
 * <p>
 * Package:     com.fxp.mvp.base
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/11/7 7:41 PM
 * <p>
 * Description:
 * <p>
 * <p>
 * Modification History:
 * <p>
 * Date       Author       Version      Description
 * -----------------------------------------------------------------
 * 2018/11/7    fxp       1.0         First Created
 * <p>
 * Github:  https://github.com/fangxiaopeng
 */
public abstract class BaseActivity<T extends BasePresenter, M extends BaseModel> extends Activity {

    public T mPresenter;

    public M mModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutResId());

        //内部获取第一个类型参数的真实类型  ，反射new出对象
        mPresenter = CreateUtil.getT(this, 0);

        //内部获取第二个类型参数的真实类型  ，反射new出对象
        mModel = CreateUtil.getT(this, 1);

        //使得P层绑定M层和V层，持有M和V的引用
        mPresenter.attachModelView(mModel, this);

        initData();

        initView();

        initListener();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract void initListener();

    public abstract int getLayoutResId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onDettach();
            mPresenter.unDisposable();
        }
    }
}
