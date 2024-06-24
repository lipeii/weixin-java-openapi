package com.weixin.openapi.enums.cp;

import lombok.Getter;

/**
 * 审批记录(节点)分支审批状态
 * 1-审批中；2-已同意；3-已驳回；4-已转审；11-已退回
 */
@Getter
public enum WxCpRecordSpStatusEnum {

    /**
     * 审批中
     */
    AUDITING(1),
    /**
     * 已同意
     */
    PASSED(2),
    /**
     * 已驳回
     */
    REJECTED(3),
    /**
     * 已转审
     */
    TURNED(4),
    /**
     * 已退回
     */
    WITHDRAWN(11),
    /**
     * 12-已加签
     */
    SIGNED(12),
    /**
     * 13-已同意并加签
     */
    PASSEDANDSIGNED(13);

    private final Integer status;

    WxCpRecordSpStatusEnum(Integer status) {
        this.status = status;
    }

    public static WxCpRecordSpStatusEnum getByName(String name){
        for(WxCpRecordSpStatusEnum item:WxCpRecordSpStatusEnum.values()){
            if(item.name().equals(name)){
                return item;
            }
        }
        return null;
    }
}
