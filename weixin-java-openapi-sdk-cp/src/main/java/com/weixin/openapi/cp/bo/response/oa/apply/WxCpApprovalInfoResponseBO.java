package com.weixin.openapi.cp.bo.response.oa.apply;

import com.weixin.openapi.cp.bo.response.BaseResponseBO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import me.chanjar.weixin.cp.bean.oa.WxCpApprovalInfo;
import org.apache.commons.lang3.ObjectUtils;

import java.util.List;

/**
 * 企业微信批量获取审批单号 业务响应模型
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WxCpApprovalInfoResponseBO extends BaseResponseBO {

    /**
     * 审批单号列表，包含满足条件的审批申请
     */
    private List<String> spNoList;

    /**
     * 后续请求查询的游标，当返回结果没有该字段时表示审批单已经拉取完
     */
    private String newNextCursor;

    private Integer nextCursor;

    public static WxCpApprovalInfoResponseBO build(WxCpApprovalInfo info){
        if(ObjectUtils.isEmpty(info)){
            return null;
        }
        WxCpApprovalInfoResponseBO responseBO = new WxCpApprovalInfoResponseBO();
        responseBO.setSpNoList(info.getSpNoList());
        responseBO.setNextCursor(info.getNextCursor());
        responseBO.setNewNextCursor(info.getNewNextCursor());
        return responseBO;
    }
}
