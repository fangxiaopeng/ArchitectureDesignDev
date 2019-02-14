package com.fxp.contact.core.mvvm.viewmodel;

import com.fxp.contact.core.base.BaseLoadListener;
import com.fxp.contact.core.entity.ContactInfo;

import java.util.List;

/**
 * Title:       ContactVM
 * <p>
 * Package:     com.fxp.contact.core.mvvm.viewmodel
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2019/2/2 9:45 PM
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
public class ContactVM implements BaseLoadListener<ContactInfo> {

    public ContactVM(){}

    public void init(){

    }

    @Override
    public void loadSuccess(List<ContactInfo> list) {

    }

    @Override
    public void loadFailure(String message) {

    }

    @Override
    public void loadStart() {

    }

    @Override
    public void loadComplete() {

    }
}
