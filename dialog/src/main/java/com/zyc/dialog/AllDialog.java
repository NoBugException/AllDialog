package com.zyc.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AlertDialog;

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

        View view =  LayoutInflater.from(mContext).inflate(R.layout.default_dialog_view, null);
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
        DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
        rootView.getLayoutParams().width = (int) (displayMetrics.density * dialogWidth + 0.5);
        return AllDialogHolder.instance;
    }

}
