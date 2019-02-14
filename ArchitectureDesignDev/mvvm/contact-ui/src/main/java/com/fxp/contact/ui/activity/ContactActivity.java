package com.fxp.contact.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.fxp.contact.core.mvvm.view.IContactNavigator;
import com.fxp.contact.core.mvvm.viewmodel.ContactVM;
import com.fxp.contact.ui.R;
import com.fxp.contact.ui.databinding.ActivityContactBinding;

/**
 * Title:       ContactActivity
 * <p>
 * Package:     com.fxp.contact.ui.activity
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2019/1/24 8:23 PM
 * <p>
 * Description:
 * <p>
 * <p>
 * Modification History:
 * <p>
 * Date       Author       Version      Description
 * -----------------------------------------------------------------
 * 2019/1/24    fxp       1.0         First Created
 * <p>
 * Github:  https://github.com/fangxiaopeng
 */
public class ContactActivity extends BaseActivity<ContactVM, ActivityContactBinding> implements IContactNavigator {

    @Override
    int getLayoutId() {
        return R.layout.activity_contact;
    }

    @Override
    ContactVM setViewModel() {
        return new ContactVM();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBindView.setViewModel(mViewModel);
    }

    @Override
    public void loadStart(int loadType) {

    }

    @Override
    public void loadComplete() {

    }

    @Override
    public void loadFailure(String message) {

    }
}
