package com.fxp.contact.core.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.fxp.contact.core.greendao.gen.DaoMaster;

import org.greenrobot.greendao.database.Database;

/**
 * Title:       DBHelper
 * <p>
 * Package:     com.fxp.contact.core.db
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2019/1/28 3:13 PM
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
public class DBHelper  extends DaoMaster.DevOpenHelper{

    private static final String TAG = DBHelper.class.getSimpleName();

    public DBHelper(Context context, String name) {
        super(context, name);
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onCreate(Database db) {
        super.onCreate(db);

    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        Log.e(TAG, "greenDAO onUpgrade schema from version " + oldVersion + " to " + newVersion + " by dropping all tables");

    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.e(TAG, "greenDAO onDowngrade schema from version " + oldVersion + " to " + newVersion + " by dropping all tables");

    }
}
