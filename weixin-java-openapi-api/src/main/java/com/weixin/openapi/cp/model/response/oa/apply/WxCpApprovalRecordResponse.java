package com.weixin.openapi.cp.model.response.oa.apply;

import com.weixin.openapi.enums.cp.WxCpApproverAttrEnum;
import com.weixin.openapi.enums.cp.WxCpRecordSpStatusEnum;
import lombok.Data;
import java.util.List;

/**
 * 审批流程信息 业务响应模型
 */
@Data
public class WxCpApprovalRecordResponse {

    private WxCpRecordSpStatusEnum status;

    private WxCpApproverAttrEnum approverAttr;

    private List<WxCpApprovalRecordDetailResponse> details;
}
