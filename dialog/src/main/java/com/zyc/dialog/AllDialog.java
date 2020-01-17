package com.zyc.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.zyc.dialog.bean.LoadingBean;

public class AllDialog{

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
     * 建一个进度条对话框
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

        //设置对话框背景灰暗程度
        alertDialog.getWindow().setDimAmount(0);

        if(rootView == null){
            throw new RuntimeException("rootView is null!");
        }

//        rootView.getLayoutParams().

        //设置根容器为透明
        rootView.setBackgroundColor(Color.parseColor("#00ffffff"));
        View view =  LayoutInflater.from(mContext).inflate(R.layout.alldialog_loading1_view, null);
        LinearLayout loading1_rootview = view.findViewById(R.id.ll_alldialog_loading1);
        GradientDrawable gradientDrawable = (GradientDrawable) loading1_rootview.getBackground();
        gradientDrawable.setColor(loadingBean.getBgColor() == 0 ? Color.parseColor("#99000000") : loadingBean.getBgColor());
        gradientDrawable.setCornerRadius(loadingBean.getRadii());
        ImageView imageView = view.findViewById(R.id.iv_loading);
        AnimationDrawable animationDrawable = (AnimationDrawable)imageView.getDrawable();
        //播放动画
        animationDrawable.start();
        TextView textView = view.findViewById(R.id.loading_msg);
        if(TextUtils.isEmpty(loadingBean.getText())){
            textView.setVisibility(View.GONE);
        }else{
            textView.setText(loadingBean.getText());
            textView.setTextColor(loadingBean.getTextColor() == 0 ? Color.parseColor("#FFFFFF") : loadingBean.getTextColor());
        }
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

}
