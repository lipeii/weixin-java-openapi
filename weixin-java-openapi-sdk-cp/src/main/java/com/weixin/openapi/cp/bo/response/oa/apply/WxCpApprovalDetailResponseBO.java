package com.weixin.openapi.cp.bo.response.oa.apply;

import com.weixin.openapi.cp.bo.response.BaseResponseBO;
import com.weixin.openapi.enums.cp.WxCpSpStatusEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import me.chanjar.weixin.cp.bean.oa.WxCpApprovalDetailResult;
import org.apache.commons.lang3.ObjectUtils;

import java.util.List;

/**
 * 审批申请详情 业务响应模型
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxCpApprovalDetailResponseBO extends BaseResponseBO {

    /**
     * 审批编号
     */
    private String spNo;

    /**
     * 审批申请类型名称（审批模板名称）
     */
    private String spName;

    /**
     * 申请单状态：1-审批中；2-已通过；3-已驳回；4-已撤销；6-通过后撤销；7-已删除；10-已支付
     */
    private WxCpSpStatusEnum spStatus;

    /**
     * 审批模板id。可在“获取审批申请详情”、“审批状态变化回调通知”中获得，也可在审批模板的模板编辑页面链接中获得。
     */
    private String templateId;

    /**
     * 审批申请提交时间,Unix时间戳
     */
    private Long applyTime;

    /**
     * 申请人信息
     */
    private WxCpApprovalApplierResponseBO applier;

    /**
     * 审批流程信息，可能有多个审批节点
     */
    private List<WxCpApprovalRecordResponseBO> spRecords;

    /**
     * 抄送信息，可能有多个抄送节点
     */
    private List<WxCpOperatorResponseBO> notifiers;

    /**
     * 审批申请数据
     */
    private WxCpApprovalApplyDataResponseBO applyData;

    /**
     * 审批申请备注信息，可能有多个备注节点
     */
    private List<WxCpApprovalCommentResponseBO> comments;

    public static WxCpApprovalDetailResponseBO build(WxCpApprovalDetailResult result){
        if(ObjectUtils.isEmpty(result) || ObjectUtils.isEmpty(result.getInfo())){
            return null;
        }
        WxCpApprovalDetailResponseBO responseBO = new WxCpApprovalDetailResponseBO();
        responseBO.setSpNo(result.getInfo().getSpNo());
        responseBO.setSpName(result.getInfo().getSpName());
        responseBO.setSpStatus(WxCpSpStatusEnum.getByName(result.getInfo().getSpStatus().name()));
        responseBO.setTemplateId(result.getInfo().getTemplateId());
        responseBO.setApplyTime(result.getInfo().getApplyTime());
        responseBO.setApplier(WxCpApprovalApplierResponseBO.build(result.getInfo().getApplier()));
        responseBO.setSpRecords(WxCpApprovalRecordResponseBO.build(result.getInfo().getSpRecords()));
        responseBO.setNotifiers(WxCpOperatorResponseBO.build(result.getInfo().getNotifiers()));
        responseBO.setApplyData(WxCpApprovalApplyDataResponseBO.build(result.getInfo().getApplyData()));
        responseBO.setComments(WxCpApprovalCommentResponseBO.build(result.getInfo().getComments()));
        return responseBO;
    }
}
