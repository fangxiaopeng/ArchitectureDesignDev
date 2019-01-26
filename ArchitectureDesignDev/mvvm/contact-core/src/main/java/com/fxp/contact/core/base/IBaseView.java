package com.fxp.contact.core.base;

/**
 * Title:       IBaseView
 * <p>
 * Package:     com.fxp.contact.core.base
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2019/1/26 11:20 AM
 * <p>
 * Description:
 * <p>
 * <p>
 * Modification History:
 * <p>
 * Date       Author       Version      Description
 * -----------------------------------------------------------------
 * 2019/1/26    fxp       1.0         First Created
 * <p>
 * Github:  https://github.com/fangxiaopeng
 */
public interface IBaseView {

    /**
     * 开始加载
     *
     * @param loadType 加载的类型 0：第一次记载 1：下拉刷新 2：上拉加载更多
     */
    void loadStart(int loadType);

    /**
     * 加载完成
     */
    void loadComplete();

    /**
     * 加载失败
     *
     * @param message
     */
    void loadFailure(String message);

}
