package com.weixin.openapi.cp.bo.response.oa.apply;

import lombok.Data;
import me.chanjar.weixin.cp.bean.oa.WxCpOperator;
import org.apache.commons.lang3.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 企业微信操作人 业务响应模型
 */
@Data
public class WxCpOperatorResponseBO {

    /**
     * 企业微信userid
     */
    private String userId;

    public static List<WxCpOperatorResponseBO> build(WxCpOperator[] list){
        if(ObjectUtils.isEmpty(list)){
            return null;
        }
        List<WxCpOperatorResponseBO> responseBOList = new ArrayList<>();
        for(WxCpOperator cpOperator:list){
            responseBOList.add(build(cpOperator));
        }
        return responseBOList;
    }


    public static WxCpOperatorResponseBO build(WxCpOperator operator){
        if(ObjectUtils.isEmpty(operator)){
            return null;
        }
        WxCpOperatorResponseBO responseBO = new WxCpOperatorResponseBO();
        responseBO.setUserId(operator.getUserId());
        return responseBO;
    }
}
