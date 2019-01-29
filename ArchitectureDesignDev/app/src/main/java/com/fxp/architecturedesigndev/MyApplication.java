package com.fxp.architecturedesigndev;

import android.app.Application;

import com.fxp.contact.core.db.DBManager;

/**
 * Title:       MyApplication
 * <p>
 * Package:     com.fxp.architecturedesigndev
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2019/1/28 3:55 PM
 * <p>
 * Description:
 * <p>
 * <p>
 * Modification History:
 * <p>
 * Date       Author       Version      Description
 * -----------------------------------------------------------------
 * 2019/1/28    fxp       1.0         First Created
 * <p>
 * Github:  https://github.com/fangxiaopeng
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        DBManager.initDB(this);
    }

}
