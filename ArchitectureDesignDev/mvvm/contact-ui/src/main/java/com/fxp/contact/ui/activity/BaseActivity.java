package com.fxp.contact.ui.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.fxp.contact.core.base.IBaseNavigator;

/**
 * Title:       BaseActivity
 * <p>
 * Package:     com.fxp.contact.ui.activity
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2019/2/13 5:50 PM
 * <p>
 * Description:
 * <p>
 * <p>
 * Modification History:
 * <p>
 * Date       Author       Version      Description
 * -----------------------------------------------------------------
 * 2019/2/13    fxp       1.0         First Created
 * <p>
 * Github:  https://github.com/fangxiaopeng
 */
public abstract class BaseActivity<VM, T extends ViewDataBinding> extends AppCompatActivity implements IBaseNavigator {

    protected T mBindView;

    protected VM mViewModel;

    abstract int getLayoutId();

    abstract VM setViewModel();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(com.fxp.contact.core.R.color.skin));
        }
        mBindView = DataBindingUtil.setContentView(this, getLayoutId());
        mViewModel = setViewModel() ;
    }

    /**
     * 左上角返回的功能设置
     * @param view
     * @param titleRes
     */
    protected void setLeftText(TextView view, int titleRes){
        view.setVisibility(View.VISIBLE);
        view.setText(titleRes);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back(null);
            }
        });
    }

    protected void setRightText(TextView view, int titleRes){
        view.setVisibility(View.VISIBLE);
        view.setText(titleRes);
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void back(Intent intent) {
        if (intent != null) setResult(RESULT_OK, intent);
        finish();
    }
}
