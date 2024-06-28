package com.weixin.openapi.interceptor;

import com.weixin.openapi.utils.MDCTraceUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 自定义日志拦截器
 */
public class LogInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 客户端可以传入链路ID，需要唯一性
        String traceId = request.getHeader(MDCTraceUtils.TRACE_ID_HEADER);
        if (StringUtils.isNotEmpty(traceId)) {
            MDCTraceUtils.putTrace(request.getHeader(MDCTraceUtils.TRACE_ID_HEADER));
        } else {
            MDCTraceUtils.addTrace();
        }
        return true;
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        MDCTraceUtils.removeTrace();
    }
}
