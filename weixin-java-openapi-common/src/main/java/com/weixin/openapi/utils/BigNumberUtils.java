package com.weixin.openapi.utils;


import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * BigDecimal 工具类
 * @author LP
 */
public class BigNumberUtils {

    public static BigDecimal multiply(BigDecimal b1,BigDecimal b2){
        if(isZero(b1) || isZero(b2)){
            return BigDecimal.ZERO;
        }
        return b1.multiply(b2);
    }

    public static BigDecimal multiply(BigDecimal b1,BigDecimal b2,int newScale, RoundingMode roundingMode){
        if(isZero(b1) || isZero(b2)){
            return BigDecimal.ZERO;
        }
        return b1.multiply(b2).setScale(newScale,roundingMode);
    }

    public static BigDecimal divide(BigDecimal b1,BigDecimal b2,int newScale, RoundingMode roundingMode){
        if(isZero(b1) || isZero(b2)){
            return BigDecimal.ZERO;
        }
        return b1.divide(b2,newScale,roundingMode);
    }

    /**
     * 如果为空，设置值为0
     * @param b1 入参
     * @return 结果
     */
    public static BigDecimal nullToZero(BigDecimal b1){
        if(b1 == null){
            return BigDecimal.ZERO;
        }
        return b1;
    }

    private static boolean isZero(BigDecimal b1){
        return b1 == null || BigDecimal.ZERO.equals(b1) || BigDecimal.ZERO.compareTo(b1) == 0;
    }

    public static Integer[] toIntArray(String str) {
        if (StringUtils.isEmpty(str)) {
            return new Integer[0];
        } else {
            String[] arr = str.split(",");
            Integer[] ints = new Integer[arr.length];

            for (int i = 0; i < arr.length; ++i) {
                Integer v = toInt(arr[i], 0);
                ints[i] = v;
            }

            return ints;
        }
    }

    public static int toInt(final String str, final int defaultValue) {
        if (str == null) {
            return defaultValue;
        } else {
            try {
                return Integer.valueOf(str);
            } catch (NumberFormatException var3) {
                return defaultValue;
            }
        }
    }
}
