package com.weixin.openapi.cp.bo.request.oa.apply;

import com.weixin.openapi.cp.bo.request.BaseRequestBO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import me.chanjar.weixin.cp.bean.oa.WxCpApprovalInfoQueryFilter;

import java.util.Date;
import java.util.List;

/**
 * 企业微信批量获取审批单号 业务请求模型
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxCpApprovalInfoQueryRequestBO extends BaseRequestBO {

    /**
     * 审批单提交的时间范围，开始时间
     */
    @NonNull
    private Date startTime;

    /**
     * 审批单提交的时间范围，结束时间
     */
    @NonNull
    private Date endTime;

    /**
     * 分页查询游标，默认为空串，后续使用返回的new_next_cursor进行分页拉取
     */
    private String newCursor;

    /**
     * 一次请求拉取审批单数量，默认值为100，上限值为100。若accesstoken为自建应用，仅允许获取在应用可见范围内申请人提交的表单，返回的sp_no_list个数可能和size不一致，开发者需用next_cursor判断表单记录是否拉取完
     */
    private Integer size;

    /**
     * 筛选条件，可对批量拉取的审批申请设置约束条件，支持设置多个条件
     * - key: 筛选类型，包括：
     *      template_id - 模板类型/模板id；
     *      creator - 申请人；
     *      department - 审批单提单者所在部门；
     *      sp_status - 审批状态;
     *      record_type - 审批单类型属性，1-请假；2-打卡补卡；3-出差；4-外出；5-加班； 6- 调班；7-会议室预定；8-退款审批；9-红包报销审批
     *      注意:
     *      1、仅“部门”支持同时配置多个筛选条件。
     *      2、不同类型的筛选条件之间为“与”的关系，同类型筛选条件之间为“或”的关系
     *      3、record_type筛选类型仅支持2021/05/31以后新提交的审批单，历史单不支持表单类型属性过滤
     * - value: 筛选值，对应为：template_id-模板id；creator-申请人userid ；department-所在部门id；sp_status-审批单状态（1-审批中；2-已通过；3-已驳回；4-已撤销；6-通过后撤销；7-已删除；10-已支付）
     */
    private List<WxCpApprovalInfoQueryFilter> filters;

}
