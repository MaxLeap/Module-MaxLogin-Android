package com.maxleap.sample.login.activity;

import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.widget.Button;

import com.maxleap.MLUser;
import com.maxleap.MLUserManager;
import com.maxleap.sample.login.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by xupanpan on 12/16/16.
 */
public class MainActivity extends BaseActivity {

    @BindView(R.id.tv_name)
    AppCompatTextView tvName;
    @BindView(R.id.btn_logout)
    Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        MLUser currentUser = MLUser.getCurrentUser();

        tvName.setText(currentUser.getUserName());

    }

    @OnClick(R.id.btn_logout)
    public void onClick() {

        MLUser.logOut();

        goNext(getString(R.string.action_sign_in),LoginActivity.class);

        finish();

    }
}
