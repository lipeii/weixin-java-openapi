package com.weixin.openapi.cp.model.response.oa.apply;

import lombok.Data;

import java.util.List;

/**
 * 审批申请数据 业务响应模型
 */
@Data
public class WxCpApprovalApplyDataResponse {

    private List<ApplyDataContentResponse> contents;
}
