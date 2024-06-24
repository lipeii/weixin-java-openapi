package com.weixin.openapi.cp.model.response.oa.apply;

import com.weixin.openapi.enums.cp.WxCpRecordSpStatusEnum;
import lombok.Data;
import java.util.List;

/**
 * 审批节点详情 业务响应模型
 */
@Data
public class WxCpApprovalRecordDetailResponse {

    /**
     * 分支审批人
     */
    private WxCpOperatorResponse approver;

    /**
     * 审批意见
     */
    private String speech;

    /**
     * 分支审批人审批状态
     */
    private WxCpRecordSpStatusEnum spStatus;

    /**
     * 节点分支审批人审批操作时间戳，0表示未操作
     */
    private Long spTime;

    /**
     * 节点分支审批人审批意见附件
     */
    private List<String> mediaIds;
}
