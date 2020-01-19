package com.zyc.alldialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.zyc.dialog.AllDialog;
import com.zyc.dialog.bean.LoadingBean;
import com.zyc.dialog.bean.NormalBean;
import com.zyc.dialog.listener.ButtonListener;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button button_1, button_2, button_3, button_4, button_5, button_6, button_7;

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
        button_5 = findViewById(R.id.button_5);
        button_5.setOnClickListener(this);
        button_6 = findViewById(R.id.button_6);
        button_6.setOnClickListener(this);
        button_7 = findViewById(R.id.button_7);
        button_7.setOnClickListener(this);
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
                        .setDimAmount(0)//设置对话框背景灰暗程度
                        .gravity(Gravity.BOTTOM, 0, 100)//方位
                        .show();

                break;

            case R.id.button_4:

                final int[] progress = {0};
                final ProgressDialog dialog = new ProgressDialog(this);
                dialog.setTitle("加载中...");
                dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                dialog.setIndeterminate(false);
                dialog.show();
                dialog.setProgress(progress[0]);
                final Timer timer = new Timer();
                TimerTask timerTask = new TimerTask() {
                    @Override
                    public void run() {
                        progress[0]++;
                        if(progress[0] > 100){
                            timer.cancel();
                            dialog.dismiss();
                        }else{
                            dialog.setProgress(progress[0]);
                        }
                    }
                };
                timer.schedule(timerTask, 1000, 20);
                break;

            case R.id.button_5:

                NormalBean normalBean1 = new NormalBean();
                normalBean1.setTitle("中国大陆");
                normalBean1.setMessage("西方学者曾多次断言：中国遇到的一个长期问题就是养活不了占世界近20%的人口事实证明新中国成立以来勤劳的中国人");
                normalBean1.setTitleColor(Color.parseColor("#1233F0"));
                normalBean1.setMessageColor(Color.parseColor("#2C9AA8"));
                normalBean1.setTitleTextSize(17);
                normalBean1.setMessageTextSize(14);
                normalBean1.setButtonTextSize(14);
                normalBean1.setType((byte) 1);
                AllDialog.with(this)
                        .buildNormalDialog(normalBean1, new ButtonListener() {
                            @Override
                            public void confirm() {
                                AllDialog.with(MainActivity.this).dismiss();
                            }

                            @Override
                            public void cancel() {
                                AllDialog.with(MainActivity.this).dismiss();
                            }
                        }, null, null)
                        .show();

                break;

            case R.id.button_6:

                AllDialog.with(this)
                        .buildBottomDialog(new ButtonListener() {
                            @Override
                            public void confirm() {
                                AllDialog.with(MainActivity.this).dismiss();
                            }

                            @Override
                            public void cancel() {
                                AllDialog.with(MainActivity.this).dismiss();
                            }
                        }, null, null)
                        .show();

                break;

            case R.id.button_7:

                NormalBean normalBean2 = new NormalBean();
                normalBean2.setType((byte) 2);
                AllDialog.with(this)
                        .buildNormalDialog(normalBean2, null, null, null)
                        .show();

                break;
        }

    }
}
