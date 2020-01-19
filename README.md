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


# v1.2.1

引用：


    allprojects {
        repositories {
            maven { url 'https://www.jitpack.io' }
        }
    }
    
    dependencies {
        implementation 'com.github.NoBugException:AllDialog:1.2.1'
    }
    


修改内容：

    （1）新增白色背景的加载对话框


代码示例：

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
                        
效果如下：

![image_3.png](https://github.com/NoBugException/AllDialog/blob/master/image/image_3.png)


# v1.2.2

引用：


    allprojects {
        repositories {
            maven { url 'https://www.jitpack.io' }
        }
    }
    
    dependencies {
        implementation 'com.github.NoBugException:AllDialog:1.2.2'
    }
    


修改内容：

    （1）新增对话框灰色背景灰暗程度的参数设置；
    （2）新增对话框方位的设置；


代码示例：

                AllDialog.with(this)
                        .buildLoadingDialog(loadingBean3, null, null)
                        //.setWidth(150)//对话框宽度，单位为dp，默认是屏幕宽度的五分之四
                        //.setHeight(150)//对话框高度，单位为dp
                        .setDimAmount(0)//设置对话框背景灰暗程度
                        .gravity(Gravity.BOTTOM, 0, 100)//方位
                        .show();
                        

# v1.3.3

引用：


    allprojects {
        repositories {
            maven { url 'https://www.jitpack.io' }
        }
    }
    
    dependencies {
        implementation 'com.github.NoBugException:AllDialog:1.3.3'
    }
    



新增一个普通对话框

    （1）可以配置标题文本，标题颜色，标题文本大小；
    （2）可以配置正文内容，文本文字颜色，正文文本大小；
    （3）可以配置按钮文本大小；
    （4）按钮监听回调；


代码示例：

                NormalBean normalBean = new NormalBean();
                normalBean.setTitle("中国大陆");
                normalBean.setMessage("西方学者曾多次断言：中国遇到的一个长期问题就是养活不了占世界近20%的人口事实证明新中国成立以来勤劳的中国人");
                normalBean.setTitleColor(Color.parseColor("#1233F0"));
                normalBean.setMessageColor(Color.parseColor("#2C9AA8"));
                normalBean.setTitleTextSize(17);
                normalBean.setMessageTextSize(14);
                normalBean.setButtonTextSize(14);
                AllDialog.with(this)
                        .buildNormalDialog(normalBean, new ButtonListener() {
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


效果如下：

![image_4.png](https://github.com/NoBugException/AllDialog/blob/master/image/image_4.gif)


# v1.4.3

引用：


    allprojects {
        repositories {
            maven { url 'https://www.jitpack.io' }
        }
    }
    
    dependencies {
        implementation 'com.github.NoBugException:AllDialog:1.4.3'
    }
    



新增一个底部弹出的对话框

    该功能就不做过多的参数封装以及优化了，这里直接给出效果给大家参考。



代码示例：

                NormalBean normalBean1 = new NormalBean();
                normalBean1.setTitle("中国大陆");
                normalBean1.setMessage("西方学者曾多次断言：中国遇到的一个长期问题就是养活不了占世界近20%的人口事实证明新中国成立以来勤劳的中国人");
                normalBean1.setTitleColor(Color.parseColor("#1233F0"));
                normalBean1.setMessageColor(Color.parseColor("#2C9AA8"));
                normalBean1.setTitleTextSize(17);
                normalBean1.setMessageTextSize(14);
                normalBean1.setButtonTextSize(14);

                AllDialog.with(this)
                        .buildBottomDialog(normalBean1, new ButtonListener() {
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


效果如下：

![image_5.png](https://github.com/NoBugException/AllDialog/blob/master/image/image_5.gif)



