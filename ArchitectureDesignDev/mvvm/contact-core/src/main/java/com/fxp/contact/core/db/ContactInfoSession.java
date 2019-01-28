package com.fxp.contact.core.db;

import android.content.Context;

/**
 * Title:       ContactInfoSession
 * <p>
 * Package:     com.fxp.contact.core.db
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2019/1/28 3:28 PM
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
public class ContactInfoSession {

    private Context context;

    private ContactInfoSession instance;

    private ContactInfoSession(Context context){
        this.context = context.getApplicationContext();
    }

    public ContactInfoSession getInstance(Context context) {
        if (instance == null) {
            synchronized (ContactInfoSession.class) {
                if (instance == null) {
                    instance = new ContactInfoSession(context);
                }
            }
        }
        return instance;
    }

    
}
