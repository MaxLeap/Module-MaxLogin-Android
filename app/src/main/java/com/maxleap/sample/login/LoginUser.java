package com.maxleap.sample.login;

import com.maxleap.MLUser;

/**
 * Created by xupanpan on 12/16/16.
 */
public class LoginUser extends MLUser {

    private static final String KEY_SEX = "sex";
    private static final String KEY_AGE = "age";
    private static final String KEY_NICKNAME = "nickName";
    private static final String KEY_COMMENT = "comment";
    private static final String KEY_HEADIMAGE = "headImage";

    public String getKeySex() {
        return getString(KEY_SEX);
    }

    public void setKeySex(String value) {
        put(KEY_SEX, value);
    }

    public int getKeyAge() {
        return getInt(KEY_AGE);
    }

    public void setKeyAge(int value) {
        put(KEY_AGE, value);
    }

    public void setKeyNickname(String value) {
        put(KEY_NICKNAME, value);
    }

    public void setKeyComment(String value) {
        put(KEY_COMMENT, value);
    }

    public void setKeyHeadImage(String value) {
        put(KEY_HEADIMAGE, value);
    }

    public String getKeyNickName() {
        return getString(KEY_NICKNAME);
    }

    public String getKeyComment() {
        return getString(KEY_COMMENT);
    }

    public String getKeyHeadImage() {
        return getString(KEY_HEADIMAGE);
    }

}
