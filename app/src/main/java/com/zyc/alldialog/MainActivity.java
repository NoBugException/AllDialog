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

                LoadingBean loadingBean3 = new LoadingBean();
                loadingBean3.setRadii(6);
                loadingBean3.setText("请稍等...");
                loadingBean3.setTextColor(Color.parseColor("#7700CE"));
                loadingBean3.setType((byte) 1);

                AllDialog.with(this)
                        .buildLoadingDialog(loadingBean3, null, null)
                        //.setWidth(150)//对话框宽度，单位为dp，默认是屏幕宽度的五分之四
                        //.setHeight(150)//对话框高度，单位为dp
                        .show();

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
