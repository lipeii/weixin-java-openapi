package com.weixin.openapi.utils;

import cn.hutool.core.bean.copier.BeanCopier;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.json.JSONUtil;
import com.weixin.openapi.enums.StatusCodeEnum;
import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@UtilityClass
public class $ {

    /**
     * 为空抛异常
     *
     * @param obj
     * @param <T>
     * @return
     */
    public <T> T required(T obj, StatusCodeEnum code) {
        AssertUtils.notNull(obj, code);
        return obj;
    }

    public <T> T required(T obj, Integer code, String msg) {
        AssertUtils.notNull(obj, code, msg);
        return obj;
    }

    public void required(Boolean obj, Integer code, String msg) {
        AssertUtils.isTrue(obj, code, msg);
    }

    public void required(Boolean obj, StatusCodeEnum code) {
        AssertUtils.isTrue(obj, code);
    }

    public <T> boolean isEmpty(T obj) {
        return ObjectUtil.isEmpty(obj);
    }

    public <T> boolean isNotEmpty(T obj) {
        return ObjectUtil.isNotEmpty(obj);
    }

    public static List<Integer> toIntList(String str) {
        return Arrays.asList(BigNumberUtils.toIntArray(str));
    }

    public <T> String toJson(T model) {
        return JSONUtil.toJsonStr(model);
    }

    public <T> T toBean(String json, Class<T> tClass) {
        return JSONUtil.toBean(json, tClass);
    }

    /**
     * 轻量级的拷贝
     *
     * @param source
     * @param dest
     * @param <T>
     * @return
     */
    public static <T> T copy(Object source, T dest) {
        return BeanUtils.copy(source, dest, null);
    }

    public static <S, T> List<T> copyList(List<S> sourceList, Class<T> dest) {
        if(ObjectUtil.isEmpty(sourceList)){
            return ListUtil.empty();
        }
        return sourceList.stream().map(s -> copy(s, dest)).collect(Collectors.toList());
    }

    public static <T> T copy(Object source, Class<T> dest) {
        return BeanUtils.copy(source, ReflectUtil.newInstance(dest), null);
    }

    public static <T> T copy(Object source, T dest, Map<String, String> mapping) {
        return BeanUtils.copy(source, dest, mapping);
    }

    public static <T> T copyIgnoreNull(Object source, T dest, Map<String, String> mapping) {
        return BeanCopier.create(source, dest, CopyOptions.create().setFieldMapping(mapping).setIgnoreNullValue(true)).copy();
    }

    public static String md5(String param, String salt) {
        return SecureUtil.md5(param.concat(salt));
    }

    public static Boolean md5Verify(String param, String salt, String sign) {
        return sign.equalsIgnoreCase(SecureUtil.md5(param.concat(salt)));
    }
}
