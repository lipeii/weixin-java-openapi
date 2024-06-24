package com.weixin.openapi.cp.model.request.oa.apply;

import com.weixin.openapi.cp.model.request.ApiBaseRequest;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 企业微信获取审批申请详情 业务请求模型
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxCpApprovalDetailQueryRequest extends ApiBaseRequest {

    /**
     * 审批单号
     */
    @NotNull(message = "审批单号不能为空")
    private String spNo;

}
