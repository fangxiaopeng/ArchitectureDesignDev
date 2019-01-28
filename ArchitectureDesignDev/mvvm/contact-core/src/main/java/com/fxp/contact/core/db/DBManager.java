package com.fxp.contact.core.db;

import android.content.Context;

import com.fxp.contact.core.greendao.gen.DaoMaster;
import com.fxp.contact.core.greendao.gen.DaoSession;

import org.greenrobot.greendao.database.Database;

/**
 * Title:       DBManager
 * <p>
 * Package:     com.fxp.contact.core.db
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2019/1/28 3:08 PM
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
public class DBManager {

    private static final String DB_NAME = "contact.db";

    public static DaoSession daoSession;

    public static void initDB(Context context){
        initGreenDAO(context);
    }

    private static void initGreenDAO(Context context){
        DaoMaster.DevOpenHelper openHelper = new DBHelper(context, DB_NAME, null);
        Database database = openHelper.getWritableDb();
        DaoMaster daoMaster = new DaoMaster(database);

        daoSession = daoMaster.newSession();
    }

    public static DaoSession getDaoSession(){
        return daoSession;
    }
}
