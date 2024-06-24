package com.weixin.openapi.cp.api;

import com.weixin.openapi.cp.bo.request.oa.apply.WxCpApprovalDetailQueryRequestBO;
import com.weixin.openapi.cp.bo.request.oa.apply.WxCpApprovalInfoQueryRequestBO;
import com.weixin.openapi.cp.bo.response.oa.apply.WxCpApprovalDetailResponseBO;
import com.weixin.openapi.cp.bo.response.oa.apply.WxCpApprovalInfoResponseBO;

public interface IWxCpOaDao {
    /**
     * 企业微信批量获取审批单号
     * @param bo 入参
     * @return 结果
     */
    WxCpApprovalInfoResponseBO getApprovalInfo(WxCpApprovalInfoQueryRequestBO bo);

    /**
     * 企业微信获取审批申请详情
     * @param bo 入参
     * @return 结果
     */
    WxCpApprovalDetailResponseBO getApprovalDetail(WxCpApprovalDetailQueryRequestBO bo);
}
