package com.weixin.openapi.cp.bo.response.oa.apply;

import lombok.Data;
import me.chanjar.weixin.cp.bean.oa.WxCpApprovalApplyData;

import java.util.List;

/**
 * 审批申请数据 业务响应模型
 */
@Data
public class WxCpApprovalApplyDataResponseBO {

    private List<ApplyDataContentResponseBO> contents;

    public static WxCpApprovalApplyDataResponseBO build(WxCpApprovalApplyData applyData){
        WxCpApprovalApplyDataResponseBO responseBO = new WxCpApprovalApplyDataResponseBO();
        responseBO.setContents(ApplyDataContentResponseBO.build(applyData.getContents()));
        return responseBO;
    }
}
