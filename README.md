# v1.0.1

引用：


    allprojects {
        repositories {
            maven { url 'https://www.jitpack.io' }
        }
    }
    
    dependencies {
        implementation 'com.github.NoBugException:AllDialog:1.0.1'
    }
    

提交内容：AlertDialog基本封装：


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

![image_1.png](https://github.com/NoBugException/AllDialog/blob/master/image/image_1.png)

# v1.1.1

引用：


    allprojects {
        repositories {
            maven { url 'https://www.jitpack.io' }
        }
    }
    
    dependencies {
        implementation 'com.github.NoBugException:AllDialog:1.1.1'
    }
    


修改内容：

    （1）新增黑色半透明背景的转圈对话框
    （2）基本封装下新增设置高度；


代码示例：

                LoadingBean loadingBean = new LoadingBean();
                loadingBean.setRadii(6);
                loadingBean.setText("请稍等...");
                loadingBean.setTextColor(Color.parseColor("#FFFFFF"));

                AllDialog.with(this)
                        .buildLoadingDialog(loadingBean, null, null)
                        .setWidth(100)//对话框宽度，单位为dp，默认是屏幕宽度的五分之四
                        .setHeight(100)//对话框高度，单位为dp
                        .show();
效果如下：

![image_2.png](https://github.com/NoBugException/AllDialog/blob/master/image/image_2.png)

