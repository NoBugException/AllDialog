package com.zyc.alldialog;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.zyc.dialog.AllDialog;
import com.zyc.dialog.bean.LoadingBean;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button button_1, button_2, button_3, button_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_1 = findViewById(R.id.button_1);
        button_1.setOnClickListener(this);
        button_2 = findViewById(R.id.button_2);
        button_2.setOnClickListener(this);
        button_3 = findViewById(R.id.button_3);
        button_3.setOnClickListener(this);
        button_4 = findViewById(R.id.button_4);
        button_4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_1:

                View view =  LayoutInflater.from(this).inflate(R.layout.my_dialog_view, null);
                ImageView alldialog_close = view.findViewById(R.id.alldialog_close);
                alldialog_close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AllDialog.with(MainActivity.this).dismiss();
                    }
                });
                AllDialog.with(this)
                        .buildDialog(true, R.style.style_all_dialog, null, null)
                        .addView(view)
                        .setWidth(250)//对话框宽度，单位为dp，默认是屏幕宽度的五分之四
                        .show();

                break;

            case R.id.button_2:

                LoadingBean loadingBean = new LoadingBean();
                loadingBean.setRadii(6);
                loadingBean.setText("请稍等...");
                loadingBean.setTextColor(Color.parseColor("#FFFFFF"));

                AllDialog.with(this)
                        .buildLoadingDialog(loadingBean, null, null)
                        .setWidth(100)//对话框宽度，单位为dp，默认是屏幕宽度的五分之四
                        .setHeight(100)//对话框高度，单位为dp
                        .show();

                break;

            case R.id.button_3:

//                final String[] items_3 =new String[]{"鸭血粉丝","大煮干丝","西红柿鸡蛋汤","王八汤"};
//                boolean[] checkedItems = new boolean[]{false,false,false,false};
//                AllDialog.with(this)
//                        .buildDialog("请问您要点什么", "")
//                        .setNegativeButton("取消", null)
//                        .setCancelable(false)
//                        .setMultiChoiceItems(items_3, checkedItems, null)
//                        .create()
//                        .show();

                break;

            case R.id.button_4:

//                AllDialog.with(this)
//                        .buildDialog()
//                        .setCancelable(true)
//                        .setView(R.layout.default_dialog_view)
//                        .create()
//                        .show();
                break;
        }

    }
}
