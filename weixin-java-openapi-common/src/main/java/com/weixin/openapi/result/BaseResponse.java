package com.weixin.openapi.result;


import com.alibaba.fastjson2.JSONObject;
import com.weixin.openapi.enums.StatusCodeEnum;
import com.weixin.openapi.exception.BusinessException;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;


/**
 * 封装结果
 *
 * @author liwenchao
 */
@Data
public class BaseResponse<T> {

    /**
     * 服务名称
     */
    private String serverName;

    /**
     * 跟踪id
     */
    private String traceId;

    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 结果代码
     */
    private Integer code;

    /**
     * 结果说明
     */
    private String message;

    /**
     * 返回参数信息(分页请求的话分页参数放进data)
     */
    private T data;

    /**
     * 此构造方法应用于data为null的场景
     */
    public BaseResponse() {
    }

    public void init(){
        this.code = StatusCodeEnum.SUCCESS.getCode();
        this.message = StatusCodeEnum.SUCCESS.getName();
        this.success = true;
    }

    /**
     * 有具体业务数据返回时,使用此构造方法
     */
    public BaseResponse(T data) {
        init();
        this.data = data;
    }

    /**
     * 出现异常以后要调用此方法封装异常信息
     *
     * @param t 异常类
     */
    public BaseResponse(Throwable t) {
        if (t instanceof BusinessException) {
            BusinessException businessException = (BusinessException) t;
            this.code = businessException.getCode().get();
            this.message = businessException.getMsg().get();
        } else {
            this.code = StatusCodeEnum.UNKNOWN_ERR.getCode();
            this.message = StatusCodeEnum.UNKNOWN_ERR.getName();
        }
        this.success = false;
    }

    public static <T> BaseResponse<T> restResult(T data, Integer code, String msg, String serverName, String traceId, boolean success) {
        BaseResponse<T> apiResult = new BaseResponse<>();
        apiResult.setSuccess(success);
        apiResult.setData(data);
        apiResult.setServerName(serverName);

        if(code != null){
            apiResult.setCode(code);
        }
        if(StringUtils.isNotBlank(msg)){
            apiResult.setMessage(msg);
        }
        if(StringUtils.isNotBlank(traceId)){
            apiResult.setTraceId(traceId);
        }
        return apiResult;
    }

    public static <T> BaseResponse<T> restResult(T data, Integer code, String msg, String serverName, boolean success) {
        return restResult(data,code,msg,serverName,null,success);
    }

    public static <T> BaseResponse<T> restResult(T data, Integer code, String msg, boolean success) {
        return restResult(data,code,msg,null,null,success);
    }

    public static <T> BaseResponse<T> success() {
        return restResult(null,StatusCodeEnum.SUCCESS.getCode(), null,null,null,true);
    }

    public static <T> BaseResponse<T> success(T data) {
        return restResult(data,StatusCodeEnum.SUCCESS.getCode(), null,null,null,true);
    }

    public static <T> BaseResponse<T> success(String msg) {
        return restResult(null,StatusCodeEnum.SUCCESS.getCode(), msg,null,null,true);
    }

    public static <T> BaseResponse<T> successData(String data) {
        return (BaseResponse<T>) restResult(data,StatusCodeEnum.SUCCESS.getCode(), null,null,null,true);
    }

    public static <T> BaseResponse<T> success(String msg,T data) {
        return restResult(data,StatusCodeEnum.SUCCESS.getCode(), msg,null,null,true);
    }

    public static <T> BaseResponse<T> error() {
        return restResult(null,StatusCodeEnum.UNKNOWN_ERR.getCode(), StatusCodeEnum.UNKNOWN_ERR.getName(),null,null,false);
    }

    public static <T> BaseResponse<T> error(T data) {
        return restResult(data,StatusCodeEnum.ERROR.getCode(), null,null,null,false);
    }

    public static <T> BaseResponse<T> error(String msg) {
        return restResult(null,StatusCodeEnum.ERROR.getCode(), msg,null,null,false);
    }

    public static <T> BaseResponse<T> error(String msg,T data) {
        return restResult(data,StatusCodeEnum.ERROR.getCode(), msg,null,null,false);
    }

    public static <T> BaseResponse<T> error(int code,String msg) {
        return restResult(null,code,msg,null,null,false);
    }

    public static <T> BaseResponse<T> error(String msg,T data,int code) {
        return restResult(data,code,msg,null,null,false);
    }


    public static <T> BaseResponse<T> buildByResponseBody(String responseBody) {
        if(StringUtils.isEmpty(responseBody)){
            return BaseResponse.error();
        }
        JSONObject json = JSONObject.parseObject(responseBody);
        return restResult((T) json.get("data"),json.getInteger("code"),json.getString("msg"),null,null,false);
    }

}




