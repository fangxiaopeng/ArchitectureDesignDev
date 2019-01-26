package com.fxp.contact.core.base;

import android.content.Intent;

/**
 * Title:       IBaseNavigator
 * <p>
 * Package:     com.fxp.contact.core.base
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2019/1/26 11:10 AM
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
public interface IBaseNavigator {

    /**
     * toast提醒
     * @param msg
     */
    void showToast(String msg);

    /**
     * 返回
     * @param intent
     */
    void back(Intent intent);
}
