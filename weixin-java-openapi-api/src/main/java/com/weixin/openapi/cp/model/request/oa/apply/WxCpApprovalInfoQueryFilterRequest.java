package com.weixin.openapi.cp.model.request.oa.apply;

import lombok.Data;

/**
 * 企业微信批量获取审批单号 请求模型 筛选条件，可对批量拉取的审批申请设置约束条件，支持设置多个条件
 */
@Data
public class WxCpApprovalInfoQueryFilterRequest {

    /**
     * - key: 筛选类型，包括：
     *      template_id - 模板类型/模板id；
     *      creator - 申请人；
     *      department - 审批单提单者所在部门；
     *      sp_status - 审批状态;
     *      record_type - 审批单类型属性，1-请假；2-打卡补卡；3-出差；4-外出；5-加班； 6- 调班；7-会议室预定；8-退款审批；9-红包报销审批
     */
    private String key;

    /**
     * value: 筛选值，对应为：template_id-模板id；creator-申请人userid ；department-所在部门id；sp_status-审批单状态（1-审批中；2-已通过；3-已驳回；4-已撤销；6-通过后撤销；7-已删除；10-已支付）
     */
    private Object value;
}
