package com.weixin.openapi.cp.bo.response.oa.apply;

import lombok.Data;
import lombok.EqualsAndHashCode;
import me.chanjar.weixin.cp.bean.oa.WxCpApprovalApplier;

/**
 * 申请人信息 业务响应模型
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxCpApprovalApplierResponseBO extends WxCpOperatorResponseBO {

    /**
     * 申请人所在部门id
     */
    private String partyId;

    public static WxCpApprovalApplierResponseBO build(WxCpApprovalApplier approvalApplier) {
        WxCpApprovalApplierResponseBO responseBO = new WxCpApprovalApplierResponseBO();
        responseBO.setUserId(approvalApplier.getUserId());
        responseBO.setPartyId(approvalApplier.getPartyId());
        return responseBO;
    }
}
