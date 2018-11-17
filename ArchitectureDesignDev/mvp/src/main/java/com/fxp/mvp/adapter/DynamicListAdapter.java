package com.fxp.mvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.fxp.mvp.R;
import com.fxp.mvp.adapter.holder.BasicViewHolder;
import com.fxp.mvp.adapter.holder.DynamicBlogViewHolder;
import com.fxp.mvp.adapter.holder.DynamicStateViewHolder;
import com.fxp.mvp.entity.DynamicBean;
import com.fxp.mvp.utils.Constants;
import com.fxp.mvp.view.DynamicPublishView;

/**
 * Title:       DynamicListAdapter
 * <p>
 * Package:     com.fxp.mvp.adapter
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/11/16 3:13 PM
 * <p>
 * Description:
 * <p>
 * <p>
 * Modification History:
 * <p>
 * Date       Author       Version      Description
 * -----------------------------------------------------------------
 * 2018/11/16    fxp       1.0         First Created
 * <p>
 * Github:  https://github.com/fangxiaopeng
 */
public class DynamicListAdapter<T> extends RecyclerView.Adapter<BasicViewHolder<T>> implements DynamicPublishView {

    private Context context;

    private LayoutInflater layoutInflater;

    public DynamicListAdapter(Context context, DynamicPublishView view){
        this.context = context;

        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public BasicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == Constants.TYPE_STATE){
            return new DynamicStateViewHolder(context, layoutInflater.inflate(R.layout.item_dynamic_state, parent, false));
        }else {
            return new DynamicBlogViewHolder(context, layoutInflater.inflate(R.layout.item_dynamic_blog, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(BasicViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public void showDynamic(DynamicBean dynamicBean) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError() {

    }
}
