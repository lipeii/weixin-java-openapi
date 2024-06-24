package com.weixin.openapi.cp.bo.request.oa.apply;

import com.weixin.openapi.cp.bo.request.BaseRequestBO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

/**
 * 企业微信获取审批申请详情 业务请求模型
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxCpApprovalDetailQueryRequestBO extends BaseRequestBO {

    /**
     * 审批单提交的时间范围，开始时间
     */
    @NonNull
    private String spNo;

}
