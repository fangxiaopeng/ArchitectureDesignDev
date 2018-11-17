package com.fxp.mvp.wigdet;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.fxp.mvp.R;

/**
 * Title:       LoadingDialog
 * <p>
 * Package:     com.fxp.mvp.wigdet
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/11/16 2:51 PM
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
public class LoadingDialog {

    private Context context;

    private PopupWindow popupDialog;

    private RelativeLayout rlDialogBg;

    private View dialogProgressBar;

    private RotateAnimation rotateAnim;

    private AlphaAnimation alphaAnimIn, alphaAnimOut;

    public LoadingDialog(Context context) {
        this.context = context;
    }

    private void initAnim() {
        rotateAnim = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnim.setDuration(2000);
        rotateAnim.setRepeatMode(Animation.RESTART);
        rotateAnim.setRepeatCount(-1);
        rotateAnim.setInterpolator(new LinearInterpolator());

        alphaAnimIn = new AlphaAnimation(0f, 1f);
        alphaAnimIn.setFillAfter(true);
        alphaAnimIn.setDuration(200);
        alphaAnimIn.setInterpolator(new LinearInterpolator());

        alphaAnimOut = new AlphaAnimation(1f, 0f);
        alphaAnimOut.setFillAfter(true);
        alphaAnimOut.setDuration(100);
        alphaAnimOut.setInterpolator(new LinearInterpolator());
        alphaAnimOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation arg0) {
            }
            @Override
            public void onAnimationRepeat(Animation arg0) {
            }
            @Override
            public void onAnimationEnd(Animation arg0) {
                dismiss();
            }
        });
    }

    /**
     * 判断是否显示
     * @return
     */
    public boolean isShowing() {
        if (popupDialog != null && popupDialog.isShowing()) {
            return true;
        }
        return false;
    }

    /**
     * 显示
     */
    public void show() {

        dismiss();

        initAnim();

        RelativeLayout view = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.view_loading_dialog, null);
        dialogProgressBar = view.findViewById(R.id.dialog_progress_bar);
        rlDialogBg = view.findViewById(R.id.rl_dialog_bg);

        popupDialog = new PopupWindow(view, RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.FILL_PARENT);
        View parentView = ((Activity) context).getWindow().findViewById(Window.ID_ANDROID_CONTENT);
        popupDialog.showAtLocation(parentView, Gravity.CENTER, 0, 0);

        rlDialogBg.startAnimation(alphaAnimIn);
        dialogProgressBar.startAnimation(rotateAnim);
    }

    /**
     * 隐藏
     */
    public void dismiss() {
        if (popupDialog != null && popupDialog.isShowing()) {
            rlDialogBg.clearAnimation();
            dialogProgressBar.clearAnimation();
            popupDialog.dismiss();
        }
    }
}
