package com.weixin.openapi.cp.api;

import com.weixin.openapi.cp.model.request.oa.apply.WxCpApprovalDetailQueryRequest;
import com.weixin.openapi.cp.model.request.oa.apply.WxCpApprovalInfoQueryRequest;
import com.weixin.openapi.cp.model.response.oa.apply.WxCpApprovalDetailResponse;
import com.weixin.openapi.cp.model.response.oa.apply.WxCpApprovalInfoResponse;
import com.weixin.openapi.result.BaseResponse;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 企业微信oa 接口
 */
@FeignClient(value = "weixin-java-openapi",contextId = "wx-cp-oa", url = "${weixin.openapi.endpoint}",path = "/wx-cp-oa")
public interface WxCpIOaClient {

    /**
     * 企业微信批量获取审批单号
     * @param request 入参
     * @return 结果
     */
    @PostMapping("/getApprovalInfo")
    BaseResponse<WxCpApprovalInfoResponse> getApprovalInfo(@Valid @RequestBody WxCpApprovalInfoQueryRequest request);

    /**
     * 企业微信获取审批申请详情
     * @param request 入参
     * @return 结果
     */
    @PostMapping("/getApprovalDetail")
    BaseResponse<WxCpApprovalDetailResponse> getApprovalDetail(@RequestBody WxCpApprovalDetailQueryRequest request);
}
