package com.weixin.openapi.cp.model.response.oa.apply;

import lombok.Data;

import java.util.List;

/**
 * 企业微信批量获取审批单号 响应模型
 */
@Data
public class WxCpApprovalInfoResponse {

    /**
     * 审批单号列表，包含满足条件的审批申请
     */
    private List<String> spNoList;

    /**
     * 后续请求查询的游标，当返回结果没有该字段时表示审批单已经拉取完
     */
    private String newNextCursor;

    private Integer nextCursor;
}
