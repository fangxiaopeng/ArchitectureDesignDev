package com.fxp.contact.core.base;

import java.util.List;

/**
 * Title:       BaseLoadListener
 * <p>
 * Package:     com.fxp.contact.core.base
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2019/1/26 11:19 AM
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
public interface BaseLoadListener<T> {

    /**
     * 加载数据成功
     *
     * @param list
     */
    void loadSuccess(List<T> list);

    /**
     * 加载失败
     *
     * @param message
     */
    void loadFailure(String message);

    /**
     * 开始加载
     */
    void loadStart();

    /**
     * 加载结束
     */
    void loadComplete();

}
