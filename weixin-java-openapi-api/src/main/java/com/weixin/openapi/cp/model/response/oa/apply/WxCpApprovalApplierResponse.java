package com.weixin.openapi.cp.model.response.oa.apply;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 申请人信息 业务响应模型
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxCpApprovalApplierResponse extends WxCpOperatorResponse {

    /**
     * 申请人所在部门id
     */
    private String partyId;
}
