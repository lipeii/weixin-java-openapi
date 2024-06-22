package com.weixin.openapi.utils;

/**
 * 字符串操作工具类
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils{

    /**
     * 截取字符串中的数字
     * @param str 要截取的字符串
     * @return 结果
     */
    public static Integer getInteger(String str){
        String number = getNumber(str);
        if(StringUtils.isNotBlank(number)){
            return Integer.parseInt(number);
        }
        return 0;
    }

    /**
     * 截取字符串中的数字
     * @param str 要截取的字符串
     * @return 结果
     */
    public static String getNumber(String str){
        try {
            if(str == null){
                return null;
            }
            String regEx = "[^0-9]";

            String number = str.replaceAll(regEx, "");
            if(StringUtils.isNotBlank(number)){
                return number;
            }
        }catch (Exception e){
            return null;
        }
        return null;
    }

    /**
     * 使用正则表达式去除所有标点符号
     * @param inputString 字符串
     * @return 结果
     */
    public static String removeSymbols(String inputString) {
        // 使用正则表达式去除所有标点符号
        return inputString.replaceAll("[\\p{Punct}]", "");
    }

    /**
     * 校验是否包含base64编码
     * @param str 字符串
     * @return 结果
     */
    public static boolean isValidBase64(String str){
        if(org.apache.commons.lang3.StringUtils.isBlank(str) || str.length() % 4 != 0){
            return false;
        }

        return str.matches("^[a-zA-Z0-9+/]*={0,2}$");
    }
}
