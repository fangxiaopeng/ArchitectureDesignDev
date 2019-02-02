package com.fxp.contact.core.mvvm.model;

import com.fxp.contact.core.base.BaseLoadListener;
import com.fxp.contact.core.entity.ContactInfo;

/**
 * Title:       IContactModel
 * <p>
 * Package:     com.fxp.contact.core.mvvm.model
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2019/2/2 9:38 PM
 * <p>
 * Description:
 * <p>
 * <p>
 * Modification History:
 * <p>
 * Date       Author       Version      Description
 * -----------------------------------------------------------------
 * 2019/2/2    fxp       1.0         First Created
 * <p>
 * Github:  https://github.com/fangxiaopeng
 */
public interface IContactModel {

    void loadData(int page, BaseLoadListener<ContactInfo> loadListener);
}
