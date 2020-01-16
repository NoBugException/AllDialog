# v1.0.1

提交内容：AlertDialog基本封装
（1）支持设置AlertDialog的宽度；
（2）添加布局；
（3）设置主题；
（4）设置cancelable值，点击外围是否关闭对话框；
（5）设置OnDismissListener和OnCancelListener监听；

代码示例：

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
                        
效果如下：
