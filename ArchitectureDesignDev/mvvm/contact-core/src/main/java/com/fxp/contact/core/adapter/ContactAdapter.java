package com.fxp.contact.core.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.ViewGroup;

import com.fxp.contact.core.adapter.holder.ContactViewHolder;
import com.fxp.contact.core.base.BaseAdapter;
import com.fxp.contact.core.entity.ContactInfo;

/**
 * Title:       ContactAdapter
 * <p>
 * Package:     com.fxp.contact.core.adapter
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2019/2/14 4:28 PM
 * <p>
 * Description:
 * <p>
 * <p>
 * Modification History:
 * <p>
 * Date       Author       Version      Description
 * -----------------------------------------------------------------
 * 2019/2/14    fxp       1.0         First Created
 * <p>
 * Github:  https://github.com/fangxiaopeng
 */
public class ContactAdapter extends BaseAdapter<ContactInfo, ContactViewHolder>{

    private int layoutId;

    public ContactAdapter(Context context, int layoutId) {
        super(context);
        this.layoutId = layoutId;
    }

    @Override
    public ContactViewHolder onCreateVH(ViewGroup parent, int viewType) {
        ViewDataBinding dataBinding = DataBindingUtil.inflate(inflater, layoutId, parent, false);

        return new ContactViewHolder(dataBinding);
    }

    @Override
    public void onBindVH(ContactViewHolder contactViewHolder, int position) {

    }
}
