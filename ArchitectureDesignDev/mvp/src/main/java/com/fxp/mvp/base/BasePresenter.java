package com.fxp.mvp.base;

import android.app.Activity;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Title:       BasePresenter
 * <p>
 * Package:     com.fxp.mvp.base
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/11/7 8:27 PM
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
public abstract class BasePresenter<M, V> {

    public Activity mContext;

    public M mModel;

    private V mView;

    /**
     * 避免内存泄露
     */
    public WeakReference<V> mViewRef;

    /**
     * 将所有正在处理的Subscription都添加到CompositeSubscription中。统一退出的时候注销观察
     */
    private CompositeDisposable mCompositeDisposable;

    public BasePresenter(Activity context) {
        mContext = context;
    }

    public void attachModelView(M pModel, V pView) {

        mViewRef = new WeakReference<V>(pView);

        this.mModel = pModel;
    }

    public V getView() {
        if (isAttach()) {
            return mViewRef.get();
        } else {
            return null;
        }
    }

    public boolean isAttach() {
        return null != mViewRef && null != mViewRef.get();
    }


    public void onDettach() {
        if (null != mViewRef) {
            mViewRef.clear();
            mViewRef = null;
        }
    }

    public void addDisposable(Disposable subscription) {
        // csb 如果解绑了的话添加 sb 需要新的实例否则绑定时无效的
        if (mCompositeDisposable == null || mCompositeDisposable.isDisposed()) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(subscription);
    }

    /**
     * 在界面退出等需要解绑观察者的情况下调用此方法统一解绑，防止Rx造成的内存泄漏
     */
    public void unDisposable() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.dispose();
        }
    }

}
