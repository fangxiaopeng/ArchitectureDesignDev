package com.fxp.mvp.view;

import com.fxp.mvp.base.BaseView;
import com.fxp.mvp.entity.DynamicBean;

/**
 * Title:       DynamicPublishView
 * <p>
 * Package:     com.fxp.mvp.view
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/11/15 6:57 PM
 * <p>
 * Description:
 * <p>
 * <p>
 * Modification History:
 * <p>
 * Date       Author       Version      Description
 * -----------------------------------------------------------------
 * 2018/11/15    fxp       1.0         First Created
 * <p>
 * Github:  https://github.com/fangxiaopeng
 */
public interface DynamicPublishView extends BaseView{
    void showDynamic(DynamicBean dynamicBean);
}
