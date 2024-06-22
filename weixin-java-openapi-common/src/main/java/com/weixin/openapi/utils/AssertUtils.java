package com.weixin.openapi.utils;

import cn.hutool.core.util.ObjectUtil;
import com.weixin.openapi.enums.StatusCodeEnum;
import com.weixin.openapi.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.Collection;

public class AssertUtils {

    public static void isTrue(boolean expression, StatusCodeEnum resultCode) {
        if (!expression) {
            throw new BusinessException(resultCode);
        }
    }

    public static void isTrue(boolean expression, Integer code, String msg) {
        if (!expression) {
            throw new BusinessException(msg,code);
        }
    }

    public static void notNull(Object object, StatusCodeEnum resultCode) {
        if (ObjectUtil.isEmpty(object)) {
            throw new BusinessException(resultCode);
        }
    }

    public static void notNull(Object object, Integer code, String msg) {
        if (ObjectUtil.isEmpty(object)) {
            throw new BusinessException(msg,code);
        }
    }

    public static void notEmpty(String str, StatusCodeEnum resultCode) {
        if (StringUtils.isEmpty(str)) {
            throw new BusinessException(resultCode);
        }
    }

    public static void notEmpty(Collection<?> collection, StatusCodeEnum resultCode) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new BusinessException(resultCode);
        }
    }

}
