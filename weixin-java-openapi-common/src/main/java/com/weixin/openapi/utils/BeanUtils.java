package com.weixin.openapi.utils;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.BeanCopier;
import cn.hutool.core.bean.copier.CopyOptions;

import java.util.Map;

public class BeanUtils extends BeanUtil {

    public static <T> T copy(Object source, T target, Map<String, String> mapping) {
        return BeanCopier.create(source, target, CopyOptions.create().setFieldMapping(mapping)).copy();
    }

}
