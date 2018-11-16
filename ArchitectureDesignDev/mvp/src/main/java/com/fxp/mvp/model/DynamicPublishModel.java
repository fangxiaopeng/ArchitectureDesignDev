package com.fxp.mvp.model;

import com.fxp.mvp.base.BaseModel;
import com.fxp.mvp.model.impl.DynamicPublishModelImpl;
import com.fxp.mvp.wigdet.listener.MVPListener;

/**
 * Title:       DynamicPublishModel
 * <p>
 * Package:     com.fxp.mvp.model
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/11/15 6:53 PM
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
public interface DynamicPublishModel extends BaseModel, DynamicPublishModelImpl{

    void requestData(int pageIndex, int pageSize, MVPListener listener);

}
