package com.fxp.mvp.utils;

import java.lang.reflect.ParameterizedType;

/**
 * Title:       CreateUtil
 * <p>
 * Package:     com.fxp.mvp.utils
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/11/7 8:45 PM
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
public class CreateUtil {

    public static <T> T getT(Object o, int i) {
        try {

            return ((Class<T>) ((ParameterizedType) (o.getClass().getGenericSuperclass())).getActualTypeArguments()[i]).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
