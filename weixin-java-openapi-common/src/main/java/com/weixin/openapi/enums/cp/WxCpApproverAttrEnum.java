package com.weixin.openapi.enums.cp;

import lombok.Getter;

/**
 * 审批方式
 *
 */
@Getter
public enum WxCpApproverAttrEnum {

    /**
     * 或签
     */
    ONE_SIGN(1),
    /**
     * 会签
     */
    ALL_SIGN(2);

    private final Integer attr;

    WxCpApproverAttrEnum(Integer attr) {
        this.attr = attr;
    }

    public static WxCpApproverAttrEnum getByName(String name){
        for(WxCpApproverAttrEnum item:WxCpApproverAttrEnum.values()){
            if(item.name().equals(name)){
                return item;
            }
        }
        return null;
    }
}
