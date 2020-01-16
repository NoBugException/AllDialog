package com.zyc.alldialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.zyc.dialog.AllDialog;

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
                        .setWidth(250)//对话框宽度，单位为dp，默认是屏幕宽度的五分之四
                        .addView(view)
                        .show();

//                AllDialog.with(this)
//                        .buildDialog("标题", "文本展示！文本展示！文本展示！文本展示！文本展示！文本展示！")
//                        .setNegativeButton("取消", null)
//                        .setPositiveButton("确定",null)
//                        .setNeutralButton("评价", null)
//                        .setCancelable(false)
//                        .create()
//                        .show();

                break;

            case R.id.button_2:
//                final String[] items_2 =new String[]{"鸭血粉丝","大煮干丝","西红柿鸡蛋汤","王八汤"};
//                AllDialog.with(this)
//                        .buildDialog("请问您要点什么", "")
//                        .setNegativeButton("取消", null)
//                        .setCancelable(false)
//                        .setSingleChoiceItems(items_2, 1, null)
//                        .create()
//                        .show();
//
//                break;

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
