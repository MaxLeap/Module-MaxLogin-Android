package com.maxleap.sample.login.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.maxleap.MLUser;
import com.maxleap.MLUserManager;
import com.maxleap.SaveCallback;
import com.maxleap.exception.MLException;
import com.maxleap.sample.login.LoginUser;
import com.maxleap.sample.login.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by xupanpan on 12/16/16.
 */
public class MainActivity extends BaseActivity {

    @BindView(R.id.iv_head)
    ImageView ivHead;
    @BindView(R.id.tv_nickname)
    TextView tvNickname;
    @BindView(R.id.tv_comment)
    TextView tvComment;
    @BindView(R.id.tv_sex)
    TextView tvSex;
    @BindView(R.id.tv_age)
    TextView tvAge;
    @BindView(R.id.tv_logout)
    AppCompatTextView tvLogout;

    LoginUser currentUser;
    @BindView(R.id.rl_sex)
    RelativeLayout rlSex;
    @BindView(R.id.rl_age)
    RelativeLayout rlAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        currentUser = (LoginUser) MLUser.getCurrentUser(LoginUser.class);
        initViewData();
    }


    private void initViewData() {

        String keyNickName = currentUser.getKeyNickName();

        String keyComment = currentUser.getKeyComment();
        int keyAge = currentUser.getKeyAge();

        String keySex = currentUser.getKeySex();

        tvNickname.setText(TextUtils.isEmpty(keyNickName) ? "点击设置昵称" : keyNickName);

        tvComment.setText(TextUtils.isEmpty(keyComment) ? "点击设置签名" : keyComment);

        tvAge.setText(keyAge == 0 ? "18" : keyAge + "");

        tvSex.setText(TextUtils.isEmpty(keySex) ? "男" : keySex);

    }


    private void updateUserInfo(MLUser currentUser) {

        MLUserManager.saveInBackground(currentUser, new SaveCallback() {
            @Override
            public void done(MLException e) {
                if (e == null) {
                    showToast("更新成功");
                    initViewData();
                } else {
                    showToast("更新失败");
                }
            }
        });

    }

    @OnClick({R.id.iv_head, R.id.tv_nickname, R.id.tv_comment, R.id.rl_sex, R.id.rl_age, R.id.tv_logout})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_head:




                break;
            case R.id.tv_nickname:
                showDialog("设置昵称", tvNickname.getText().toString(), new OnValueChangeListener() {
                    @Override
                    public void onChangedValue(String value) {
                        currentUser.setKeyNickname(value);
                        updateUserInfo(currentUser);
                    }
                });

                break;
            case R.id.tv_comment:
                showDialog("设置签名", tvComment.getText().toString(), new OnValueChangeListener() {
                    @Override
                    public void onChangedValue(String value) {
                        currentUser.setKeyComment(value);
                        updateUserInfo(currentUser);
                    }
                });
                break;
            case R.id.rl_sex:

                showDialog("设置性别", tvSex.getText().toString(), new OnValueChangeListener() {
                    @Override
                    public void onChangedValue(String value) {
                        currentUser.setKeySex(value);
                        updateUserInfo(currentUser);
                    }
                });

                break;
            case R.id.rl_age:


                break;
            case R.id.tv_logout:
                MLUser.logOut();
                goNext(getString(R.string.action_sign_in), LoginActivity.class);
                finish();
                break;
        }
    }


    private void showDialog(String title, final String value, final OnValueChangeListener listener) {

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        final EditText et = new EditText(this);
        et.setText(TextUtils.isEmpty(value) ? "" : value);
        et.setSelection(TextUtils.isEmpty(value) ? 0 : value.length());
        dialog.setTitle(title);
        dialog.setView(et);
        dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String s = et.getText().toString();
                if (!TextUtils.equals(s, value) && listener != null) {
                    listener.onChangedValue(s);
                }
                dialogInterface.dismiss();
            }
        });

        dialog.show();

    }

    interface OnValueChangeListener {
        void onChangedValue(String value);
    }

}
