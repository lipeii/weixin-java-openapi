package com.weixin.openapi.cp.bo.response.oa.apply;

import com.weixin.openapi.enums.cp.WxCpApproverAttrEnum;
import com.weixin.openapi.enums.cp.WxCpRecordSpStatusEnum;
import lombok.Data;
import me.chanjar.weixin.cp.bean.oa.WxCpApprovalRecord;
import org.apache.commons.lang3.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 审批流程信息 业务响应模型
 */
@Data
public class WxCpApprovalRecordResponseBO {

    private WxCpRecordSpStatusEnum status;

    private WxCpApproverAttrEnum approverAttr;

    private List<WxCpApprovalRecordDetailResponseBO> details;

    public static List<WxCpApprovalRecordResponseBO> build(WxCpApprovalRecord[] recordList){
        if(ObjectUtils.isEmpty(recordList)){
            return null;
        }
        List<WxCpApprovalRecordResponseBO> list = new ArrayList<>();
        for (WxCpApprovalRecord record:recordList){
            list.add(build(record));
        }
        return list;
    }

    public static WxCpApprovalRecordResponseBO build(WxCpApprovalRecord record){
        if(ObjectUtils.isEmpty(record)){
            return null;
        }
        WxCpApprovalRecordResponseBO responseBO = new WxCpApprovalRecordResponseBO();
        responseBO.setApproverAttr(WxCpApproverAttrEnum.getByName(record.getApproverAttr().name()));
        responseBO.setStatus(WxCpRecordSpStatusEnum.getByName(record.getStatus().name()));
        responseBO.setDetails(WxCpApprovalRecordDetailResponseBO.build(record.getDetails()));

        return responseBO;
    }
}
