package com.xfzj.getbook.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.xfzj.getbook.BaseApplication;
import com.xfzj.getbook.MainActivity;
import com.xfzj.getbook.R;
import com.xfzj.getbook.common.User;


/**
 * Created by zj on 2016/2/27.
 */
public class FlashActivity extends AppActivity {
    public static final String FROM = "FlashActivity.class";

    private BaseApplication baseApplication;
    private User user;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            jump2Login();
        }
    };

    @Override
    protected void onSetContentView() {
        setContentView(R.layout.flash);

    }

    @Override
    public void onCreateView(Bundle savedInstanceState) {
        baseApplication = (BaseApplication) getApplication();
        user = baseApplication.user;
        if (null != user) {
            jump2MainAty();
        } else {
            handler.sendEmptyMessageDelayed(0, 3000);
        }

    }


    private void jump2Login() {

        Intent i = new Intent(this, LoginAty.class);
        startActivity(i);
        finish();
    }


    private void jump2MainAty() {
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra(MainActivity.FROM, FROM);
        startActivity(i);
        finish();
    }
}
