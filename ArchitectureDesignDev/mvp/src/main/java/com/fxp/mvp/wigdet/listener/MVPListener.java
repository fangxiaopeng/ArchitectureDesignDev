package com.fxp.mvp.wigdet.listener;

/**
 * Title:       MVPListener
 * <p>
 * Package:     com.fxp.mvp.wigdet.listener
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/11/16 10:25 AM
 * <p>
 * Description:
 * <p>
 * <p>
 * Modification History:
 * <p>
 * Date       Author       Version      Description
 * -----------------------------------------------------------------
 * 2018/11/16    fxp       1.0         First Created
 * <p>
 * Github:  https://github.com/fangxiaopeng
 */
public interface MVPListener<E> {

    void  onSuccess(E data);

    void  onError();
}
