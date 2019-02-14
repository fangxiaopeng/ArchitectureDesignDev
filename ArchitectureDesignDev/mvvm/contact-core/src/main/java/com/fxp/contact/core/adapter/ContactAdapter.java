package com.fxp.contact.core.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.fxp.contact.core.base.BaseAdapter;
import com.fxp.contact.core.base.BaseViewHolder;
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
public class ContactAdapter extends BaseAdapter<ContactInfo, BaseViewHolder>{

    public ContactAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder onCreateVH(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindVH(BaseViewHolder baseViewHolder, int position) {

    }
}
