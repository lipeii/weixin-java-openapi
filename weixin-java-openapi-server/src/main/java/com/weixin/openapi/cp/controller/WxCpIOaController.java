package com.weixin.openapi.cp.controller;

import com.weixin.openapi.cp.api.IWxCpOaDao;
import com.weixin.openapi.cp.api.WxCpIOaClient;
import com.weixin.openapi.cp.bo.request.oa.apply.WxCpApprovalDetailQueryRequestBO;
import com.weixin.openapi.cp.bo.request.oa.apply.WxCpApprovalInfoQueryRequestBO;
import com.weixin.openapi.cp.bo.response.oa.apply.WxCpApprovalDetailResponseBO;
import com.weixin.openapi.cp.bo.response.oa.apply.WxCpApprovalInfoResponseBO;
import com.weixin.openapi.cp.model.request.oa.apply.WxCpApprovalDetailQueryRequest;
import com.weixin.openapi.cp.model.request.oa.apply.WxCpApprovalInfoQueryRequest;
import com.weixin.openapi.cp.model.response.oa.apply.WxCpApprovalDetailResponse;
import com.weixin.openapi.cp.model.response.oa.apply.WxCpApprovalInfoResponse;
import com.weixin.openapi.result.BaseResponse;
import com.weixin.openapi.utils.$;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 企业微信oa 前端控制器
 */
@RequestMapping("/wx/cp/oa")
@RestController
public class WxCpIOaController implements WxCpIOaClient {

    @Resource
    private IWxCpOaDao wxCpOaDao;

    /**
     * 企业微信批量获取审批单号
     * @param request 入参
     * @return 结果
     */
    @Override
    public BaseResponse<WxCpApprovalInfoResponse> getApprovalInfo(@RequestBody WxCpApprovalInfoQueryRequest request) {
        WxCpApprovalInfoResponseBO responseBO = wxCpOaDao.getApprovalInfo($.copy(request, WxCpApprovalInfoQueryRequestBO.class));
        return BaseResponse.success(responseBO,WxCpApprovalInfoResponse.class);
    }

    /**
     * 企业微信获取审批申请详情
     * @param request 入参
     * @return 结果
     */
    @Override
    public BaseResponse<WxCpApprovalDetailResponse> getApprovalDetail(@RequestBody WxCpApprovalDetailQueryRequest request) {
        WxCpApprovalDetailResponseBO responseBO = wxCpOaDao.getApprovalDetail($.copy(request, WxCpApprovalDetailQueryRequestBO.class));
        return BaseResponse.success(responseBO,WxCpApprovalDetailResponse.class);
    }

}
