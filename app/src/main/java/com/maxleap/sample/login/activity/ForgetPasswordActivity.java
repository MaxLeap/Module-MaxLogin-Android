/**
 * Copyright (c) 2015-present, MaxLeapMobile.
 * All rights reserved.
 * ----
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.maxleap.sample.login.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

import com.maxleap.sample.login.R;
import com.maxleap.sample.login.utils.NoUtilCheck;

public class ForgetPasswordActivity extends BaseActivity {

    private final static int REQUEST_CODE_RESET_PASSWORD = 44;

    private TextInputLayout forgetPwdTel;
    private View progressbar;
    private Button confirmBtn;
    private String txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maccount_activity_forget_password);
        init();
    }

    private void init() {
        initView();
    }

    private void initView() {

        progressbar = findViewById(R.id.progress_bar_area);
        forgetPwdTel = (TextInputLayout) findViewById(R.id.forget_password_tel);
        confirmBtn = (Button) findViewById(R.id.forget_password_confirm);
        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt = forgetPwdTel.getEditText().getText().toString().trim();
                if (TextUtils.isEmpty(txt)) {
                    forgetPwdTel.setError(getString(R.string.fragment_login_tel_empty_error));
                    forgetPwdTel.requestFocus();
                } else if (!NoUtilCheck.isMobileNo(txt)) {
                    forgetPwdTel.setError(getString(R.string.fragment_login_tel_invalid_error));
                    forgetPwdTel.requestFocus();
                } else {
                    forgetPwdTel.setErrorEnabled(false);
                    forgetPwdTel.setError("");
                    View view = getCurrentFocus();
                    ((InputMethodManager) getSystemService(INPUT_METHOD_SERVICE)).
                            hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                    progressbar.setVisibility(View.VISIBLE);

                    //TODO

                }
            }
        });

        forgetPwdTel.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() < 6) {
                    confirmBtn.setEnabled(false);
                } else {
                    confirmBtn.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        if (forgetPwdTel.getEditText().getText().toString().length() < 6) {
            confirmBtn.setEnabled(false);
        } else {
            confirmBtn.setEnabled(true);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE_RESET_PASSWORD) {
            setResult(RESULT_OK);
            finish();
        }
    }
}
