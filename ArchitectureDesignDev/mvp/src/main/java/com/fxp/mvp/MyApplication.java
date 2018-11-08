package com.fxp.mvp;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

/**
 * Title:       MyApplication
 * <p>
 * Package:     com.fxp.mvp
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/11/7 7:42 PM
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
public class MyApplication extends MultiDexApplication {

    public static MyApplication mInstance;

    public static MyApplication getmInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

    }

    /**
     * 处理 android 方法总数超过 65536
     *
     * @param base
     */
    @Override
    public void attachBaseContext(Context base) {
        MultiDex.install(base);
        super.attachBaseContext(base);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

}
