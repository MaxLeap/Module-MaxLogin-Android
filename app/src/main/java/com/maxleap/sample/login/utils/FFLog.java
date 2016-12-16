/**
 * Copyright (c) 2015-present, MaxLeapMobile.
 * All rights reserved.
 * ----
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.maxleap.sample.login.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class FFLog {
    private static Toast toast;
    private static boolean debug;

    public static void i(String log) {
        if (debug) {
            Log.i("FFLog", "======== " + log);
        }
    }

    public static void d(String log) {
        if (debug) {
            Log.d("FFLog", "======== " + log);
        }
    }

    public static void toast(Context context, int resId) {
        if (toast == null) {
            toast = Toast.makeText(context, resId, Toast.LENGTH_SHORT);
        }
        toast.setText(resId);
        toast.show();
    }

    public static void toast(Context context, String content) {
        if (toast == null) {
            toast = Toast.makeText(context, content, Toast.LENGTH_SHORT);
        }
        toast.setText(content);
        toast.show();
    }

    public static boolean isDebug() {
        return debug;
    }

    public static void setDebug(boolean debug) {
        FFLog.debug = debug;
    }
}
