package com.maxleap.sample.login;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.login_tel)
    TextInputLayout loginTel;
    @BindView(R.id.login_password)
    TextInputLayout loginPassword;
    @BindView(R.id.login_password_visible)
    ImageView loginPasswordVisible;
    @BindView(R.id.login_confirm)
    Button loginConfirm;
    @BindView(R.id.login_to_register)
    TextView loginToRegister;
    @BindView(R.id.login_forget_password)
    TextView loginForgetPassword;
    @BindView(R.id.login_qq)
    ImageButton loginQq;
    @BindView(R.id.login_weibo)
    ImageButton loginWeibo;
    @BindView(R.id.login_wechat)
    ImageButton loginWechat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);






    }


    @OnClick({R.id.login_password_visible, R.id.login_confirm, R.id.login_to_register, R.id.login_forget_password, R.id.login_qq, R.id.login_weibo, R.id.login_wechat})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_password_visible:
                break;
            case R.id.login_confirm:
                break;
            case R.id.login_to_register:
                break;
            case R.id.login_forget_password:
                break;
            case R.id.login_qq:
                break;
            case R.id.login_weibo:
                break;
            case R.id.login_wechat:
                break;
        }
    }
}

