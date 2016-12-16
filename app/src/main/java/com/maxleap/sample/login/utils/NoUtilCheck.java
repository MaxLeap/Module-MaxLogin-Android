/**
 * Copyright (c) 2015-present, MaxLeapMobile.
 * All rights reserved.
 * ----
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.maxleap.sample.login.utils;

import android.telephony.PhoneNumberUtils;

import java.util.regex.Pattern;

public class NoUtilCheck {

    private static Pattern mobilePattern;
    private static Pattern numericPattern;
    private static Pattern characterPattern;
    private static Pattern characterNumericPattern;

    /**
     * 移动：134(0-8)、135、136、137、138、139、147、150、151、152、157、158、159、178、182、183、184、187、188
     * 联通：130、131、132、145、155、156、175、176、185、186
     * 电信：133、153、173、177、180、181、189
     * 全球星：1349
     * 虚拟运营商：170
     *
     * @param mobileNo
     * @return
     */
    public static boolean isMobileNo(String mobileNo) {
        return PhoneNumberUtils.isGlobalPhoneNumber(mobileNo);
    }

    public static boolean isNumeric(String str) {
        if (numericPattern == null) {
            numericPattern = Pattern.compile("[0-9]*");
        }
        return numericPattern.matcher(str).matches();
    }

    public static boolean isCharacter(String str) {
        if (characterPattern == null) {
            characterPattern = Pattern.compile("[a-zA-Z]*");
        }
        return characterPattern.matcher(str).matches();
    }

    public static boolean isReasonable(String str) {
        if (characterNumericPattern == null) {
            characterNumericPattern = Pattern.compile("[a-zA-Z0-9]*");
        }
        return characterNumericPattern.matcher(str).matches();
    }

}
