package com.weixin.openapi.cp.bo.response.oa.apply;

import com.google.common.collect.Lists;
import com.weixin.openapi.enums.cp.WxCpRecordSpStatusEnum;
import lombok.Data;
import me.chanjar.weixin.cp.bean.oa.WxCpApprovalRecordDetail;
import org.apache.commons.lang3.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 审批节点详情 业务响应模型
 */
@Data
public class WxCpApprovalRecordDetailResponseBO {

    /**
     * 分支审批人
     */
    private WxCpOperatorResponseBO approver;

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

    public static List<WxCpApprovalRecordDetailResponseBO> build(List<WxCpApprovalRecordDetail> list){
        if(ObjectUtils.isEmpty(list)){
            return null;
        }
        List<WxCpApprovalRecordDetailResponseBO> responseBOList = new ArrayList<>();
        for(WxCpApprovalRecordDetail detail:list){
            responseBOList.add(build(detail));
        }
        return responseBOList;
    }

    public static WxCpApprovalRecordDetailResponseBO build(WxCpApprovalRecordDetail detail){
        if(ObjectUtils.isEmpty(detail)){
            return null;
        }
        WxCpApprovalRecordDetailResponseBO responseBO = new WxCpApprovalRecordDetailResponseBO();
        responseBO.setApprover(WxCpOperatorResponseBO.build(detail.getApprover()));
        responseBO.setSpeech(detail.getSpeech());
        responseBO.setSpStatus(WxCpRecordSpStatusEnum.getByName(detail.getSpStatus().name()));
        responseBO.setSpTime(detail.getSpTime());
        responseBO.setMediaIds(Lists.newArrayList(detail.getMediaIds()));
        return responseBO;
    }
}
