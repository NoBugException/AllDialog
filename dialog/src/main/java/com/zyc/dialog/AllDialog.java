package com.zyc.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.zyc.dialog.bean.LoadingBean;
import com.zyc.dialog.bean.NormalBean;
import com.zyc.dialog.listener.ButtonListener;

public class AllDialog{

    public static class DialogType{
        public static final byte DIALOG_TYPE_0 = 0;
        public static final byte DIALOG_TYPE_1 = 1;
    }

    private static Context mContext;
    private AlertDialog alertDialog;
    private AlertDialog.Builder builder;
    //对话框根布局
    private LinearLayout rootView;

    private AllDialog(){}

    static class AllDialogHolder{
        public static AllDialog instance = new AllDialog();
    }

    //单例
    public static AllDialog with(Context context){
        mContext = context;
        return AllDialogHolder.instance;
    }

    /**
     * 建一个对话框
     * @param cancelable 在外围是否点击关闭对话框
     */
    public AllDialog buildDialog(boolean cancelable, DialogInterface.OnDismissListener onDismissListener, DialogInterface.OnCancelListener onCancelListener){

        builder = createBuilder(R.style.style_all_dialog);
        builder.setCancelable(cancelable);

        builder.setOnCancelListener(onCancelListener);
        builder.setOnDismissListener(onDismissListener);

        alertDialog = createDialog(builder);
        return AllDialogHolder.instance;
    }

    /**
     * 建一个对话框
     * @param styleResId 样式
     * @param cancelable 在外围是否点击关闭对话框
     */
    public AllDialog buildDialog(boolean cancelable, int styleResId, DialogInterface.OnDismissListener onDismissListener, DialogInterface.OnCancelListener onCancelListener){
        builder = createBuilder(styleResId);
        builder.setCancelable(cancelable);

        builder.setOnCancelListener(onCancelListener);
        builder.setOnDismissListener(onDismissListener);

        alertDialog = createDialog(builder);
        return AllDialogHolder.instance;
    }

    /**
     * 进度条对话框(黑色透明背景，旋转动画)
     */
    public AllDialog buildLoadingDialog(LoadingBean loadingBean, DialogInterface.OnDismissListener onDismissListener, DialogInterface.OnCancelListener onCancelListener){
        builder = createBuilder(R.style.style_all_dialog);
        builder.setCancelable(true);

        builder.setOnCancelListener(onCancelListener);
        builder.setOnDismissListener(onDismissListener);

        alertDialog = createDialog(builder);

        if(alertDialog == null){
            throw new RuntimeException("dialog is not create!");
        }

        if(rootView == null){
            throw new RuntimeException("rootView is null!");
        }

        //设置根容器为透明
        rootView.setBackgroundColor(Color.parseColor("#00ffffff"));

        View view = null;

        switch (loadingBean.getType()){
            case DialogType.DIALOG_TYPE_0:

                //设置对话框背景灰暗程度
                alertDialog.getWindow().setDimAmount(0);

                view =  LayoutInflater.from(mContext).inflate(R.layout.alldialog_loading1_view, null);
                LinearLayout loading1_rootview = view.findViewById(R.id.ll_alldialog_loading1);
                GradientDrawable gradientDrawable1 = (GradientDrawable) loading1_rootview.getBackground();
                gradientDrawable1.setColor(loadingBean.getBgColor() == 0 ? Color.parseColor("#99000000") : loadingBean.getBgColor());
                gradientDrawable1.setCornerRadius(loadingBean.getRadii());
                ImageView imageView1 = view.findViewById(R.id.iv_loading);
                AnimationDrawable animationDrawable = (AnimationDrawable)imageView1.getDrawable();
                //播放动画
                animationDrawable.start();
                TextView textView1 = view.findViewById(R.id.loading_msg);
                if(TextUtils.isEmpty(loadingBean.getText())){
                    textView1.setVisibility(View.GONE);
                }else{
                    textView1.setText(loadingBean.getText());
                    textView1.setTextColor(loadingBean.getTextColor() == 0 ? Color.parseColor("#FFFFFF") : loadingBean.getTextColor());
                }
                break;
            case DialogType.DIALOG_TYPE_1:

                //设置对话框背景灰暗程度
                alertDialog.getWindow().setDimAmount(0.5f);

                view =  LayoutInflater.from(mContext).inflate(R.layout.alldialog_loading2_view, null);
                LinearLayout loading2_rootview = view.findViewById(R.id.ll_alldialog_loading2);
                GradientDrawable gradientDrawable2 = (GradientDrawable) loading2_rootview.getBackground();
                gradientDrawable2.setColor(loadingBean.getBgColor() == 0 ? Color.parseColor("#FFFFFF") : loadingBean.getBgColor());
                gradientDrawable2.setCornerRadius(loadingBean.getRadii());
                TextView textView2 = view.findViewById(R.id.loading_msg);
                if(TextUtils.isEmpty(loadingBean.getText())){
                    textView2.setVisibility(View.GONE);
                }else{
                    textView2.setText(loadingBean.getText());
                    textView2.setTextColor(loadingBean.getTextColor() == 0 ? Color.parseColor("#7700CE") : loadingBean.getTextColor());
                }

                break;
        }

        rootView.addView(view);

        return AllDialogHolder.instance;
    }

    /**
     * 建立一个普通对话框
     * @param normalBean
     */
    public AllDialog buildNormalDialog(NormalBean normalBean, final ButtonListener listener, DialogInterface.OnDismissListener onDismissListener, DialogInterface.OnCancelListener onCancelListener){
        builder = createBuilder(R.style.style_all_dialog);
        builder.setCancelable(true);

        builder.setOnCancelListener(onCancelListener);
        builder.setOnDismissListener(onDismissListener);

        alertDialog = createDialog(builder);

        if(alertDialog == null){
            throw new RuntimeException("dialog is not create!");
        }

        if(rootView == null){
            throw new RuntimeException("rootView is null!");
        }

        if(mContext == null){
            throw new RuntimeException("context is null!");
        }

        //设置根容器为透明
        rootView.setBackgroundColor(Color.parseColor("#00ffffff"));

        View view =  LayoutInflater.from(mContext).inflate(R.layout.alldialog_normal1_view, null);
        TextView titleView = view.findViewById(R.id.tv_title);
        titleView.setText(normalBean.getTitle());
        titleView.setTextColor(normalBean.getTitleColor() == 0 ? Color.BLACK : normalBean.getTitleColor());
        titleView.setTextSize(normalBean.getTitleTextSize() == 0 ? 17 : normalBean.getTitleTextSize());
        TextView messageView = view.findViewById(R.id.tv_msg);
        messageView.setText(normalBean.getMessage());
        messageView.setTextColor(normalBean.getMessageColor() == 0 ? Color.BLACK : normalBean.getMessageColor());
        messageView.setTextSize(normalBean.getMessageTextSize() == 0 ? 14 : normalBean.getMessageTextSize());
        Button alldialog_normal_ok_btn = view.findViewById(R.id.alldialog_normal_ok_btn);
        alldialog_normal_ok_btn.setTextSize(normalBean.getButtonTextSize() == 0 ? 14 : normalBean.getButtonTextSize());
        alldialog_normal_ok_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.confirm();
            }
        });
        Button alldialog_normal_cancel_btn = view.findViewById(R.id.alldialog_normal_cancel_btn);
        alldialog_normal_cancel_btn.setTextSize(normalBean.getButtonTextSize() == 0 ? 14 : normalBean.getButtonTextSize());
        alldialog_normal_cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.cancel();
            }
        });


        rootView.addView(view);

        return AllDialogHolder.instance;
    }

    /**
     * 建立一个从底部弹出的对话框
     * @param normalBean
     */
    public AllDialog buildBottomDialog(NormalBean normalBean, final ButtonListener listener, DialogInterface.OnDismissListener onDismissListener, DialogInterface.OnCancelListener onCancelListener){
        builder = createBuilder(R.style.style_all_dialog);
        builder.setCancelable(true);

        builder.setOnCancelListener(onCancelListener);
        builder.setOnDismissListener(onDismissListener);

        alertDialog = createDialog(builder);

        if(alertDialog == null){
            throw new RuntimeException("dialog is not create!");
        }

        if(rootView == null){
            throw new RuntimeException("rootView is null!");
        }

        if(mContext == null){
            throw new RuntimeException("context is null!");
        }

        //设置根容器为透明
        rootView.setBackgroundColor(Color.parseColor("#00ffffff"));

        View view =  LayoutInflater.from(mContext).inflate(R.layout.alldialog_bottom_view, null);

        WindowManager.LayoutParams params = alertDialog.getWindow().getAttributes();
        //方位
        params.gravity = Gravity.BOTTOM;
        alertDialog.getWindow().setAttributes(params);
        //添加动画
        alertDialog.getWindow().setWindowAnimations(R.style.alldialog_bottom_animation);
        rootView.addView(view);

        return AllDialogHolder.instance;
    }

    private AlertDialog.Builder createBuilder(int styleResId){

        if(mContext == null){
            throw new RuntimeException("context is null!");
        }

        return new AlertDialog.Builder(mContext, styleResId);
    }

    private AlertDialog createDialog(AlertDialog.Builder builder){

        if(mContext == null){
            throw new RuntimeException("context is null!");
        }

        View view =  LayoutInflater.from(mContext).inflate(R.layout.alldialog_default_dialog_view, null);
        rootView = view.findViewById(R.id.ll_alldialog);

        DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
        rootView.getLayoutParams().width = displayMetrics.widthPixels * 4 / 5;
        builder.setView(view);
        return builder.create();
    }

    //当对话框被取消时的监听
    public AllDialog setOnCancelListener(DialogInterface.OnCancelListener onCancelListener){
        if(builder == null){
            throw new RuntimeException("builder is null!");
        }
        builder.setOnCancelListener(onCancelListener);
        return AllDialogHolder.instance;
    }

    //当对话框消失时的监听
    public AllDialog setOnDismissListener(DialogInterface.OnDismissListener onDismissListener){
        if(builder == null){
            throw new RuntimeException("builder is null!");
        }
        builder.setOnDismissListener(onDismissListener);
        return AllDialogHolder.instance;
    }

    //显示对话框
    public void show(){
        if(alertDialog != null && !alertDialog.isShowing()){
            alertDialog.show();
        }
    }

    //取消对话框
    public void cancel(){
        if(alertDialog != null && alertDialog.isShowing()){
            alertDialog.cancel();
        }
    }

    //关闭对话框
    public void dismiss(){
        if(alertDialog != null && alertDialog.isShowing()){
            alertDialog.dismiss();
        }
    }

    //添加view
    public AllDialog addView(View view){
        rootView.addView(view);
        return AllDialogHolder.instance;
    }

    //添加view
    public AllDialog addView(int layoutResId){
        if(mContext == null){
            throw new RuntimeException("context is null!");
        }
        View view =  LayoutInflater.from(mContext).inflate(layoutResId, null);
        rootView.addView(view);
        return AllDialogHolder.instance;
    }

    //设置宽度
    public AllDialog setWidth(int dialogWidth){

        if(mContext == null){
            throw new RuntimeException("context is null!");
        }

        if(alertDialog == null){
            throw new RuntimeException("dialog is not create!");
        }

        if(rootView == null){
            throw new RuntimeException("rootView is null!");
        }

        if(rootView.getChildCount() == 0){
            //如果没有根布局，则抛出异常
            throw new RuntimeException("rootView has no child!");
        }

        DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
        int width = (int) (displayMetrics.density * dialogWidth + 0.5);
        //设置根目录的第一个子View的宽
        if(rootView.getChildCount() > 0 && rootView.getChildAt(0).getLayoutParams() != null){
            rootView.getChildAt(0).getLayoutParams().width = width;
        }
        rootView.getLayoutParams().width = width;
        return AllDialogHolder.instance;
    }

    //设置高度
    public AllDialog setHeight(int dialogHeight){

        if(mContext == null){
            throw new RuntimeException("context is null!");
        }

        if(alertDialog == null){
            throw new RuntimeException("dialog is not create!");
        }

        if(rootView == null){
            throw new RuntimeException("rootView is null!");
        }

        if(rootView.getChildCount() == 0){
            //如果没有根布局，则抛出异常
            throw new RuntimeException("rootView has no child，please add a view!");
        }

        DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
        int height = (int) (displayMetrics.density * dialogHeight + 0.5);
        //设置根目录的第一个子View的高
        if(rootView.getChildCount() > 0 && rootView.getChildAt(0).getLayoutParams() != null){
            rootView.getChildAt(0).getLayoutParams().height = height;
        }
        rootView.getLayoutParams().height = height;
        return AllDialogHolder.instance;
    }

    /**
     * 设置对话框背景灰暗程度
     * @param amount 取值范围是[0,1]，0：不灰暗  1：完全灰暗
     * @return
     */
    public AllDialog setDimAmount(float amount){

        if(alertDialog == null){
            throw new RuntimeException("dialog is not create!");
        }

        //设置对话框背景灰暗程度
        alertDialog.getWindow().setDimAmount(amount);
        return AllDialogHolder.instance;
    }

    /**
     * 设置方位
     * @param gravity 方位
     * @param xOffset x轴方向的偏移量
     * @param yOffset y轴方向的便宜量
     * @return
     */
    public AllDialog gravity(int gravity, int xOffset, int yOffset){

        if(alertDialog == null){
            throw new RuntimeException("dialog is not create!");
        }

        WindowManager.LayoutParams params = alertDialog.getWindow().getAttributes();
        //方位
        params.gravity = gravity;
        //x轴方向的偏移量
        params.x = xOffset;
        //y轴方向的便宜量
        params.y = yOffset;
        alertDialog.getWindow().setAttributes(params);

        return AllDialogHolder.instance;
    }



}
