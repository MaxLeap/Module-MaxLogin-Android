package com.maxleap.sample.login;

import android.app.Application;

import com.maxleap.MaxLeap;

/**
 * Created by xupanpan on 12/16/16.
 */
public class MyApplication extends Application {

    public static final String APP_ID = "58536be0d63c0800074d3334";
    public static final String API_KEY = "N3FqcmRWMVllVTFwcHdoR3Z3TnFQdw";

    @Override
    public void onCreate() {
        super.onCreate();
        MaxLeap.Options options = new MaxLeap.Options();
        options.appId = APP_ID;
        options.clientKey = API_KEY;
        options.enableAnonymousUser = false;
        options.serverRegion = MaxLeap.REGION_CN;
        MaxLeap.setLogLevel(MaxLeap.LOG_LEVEL_VERBOSE);//设置log输出的等级
        MaxLeap.initialize(this, options);
    }


}
