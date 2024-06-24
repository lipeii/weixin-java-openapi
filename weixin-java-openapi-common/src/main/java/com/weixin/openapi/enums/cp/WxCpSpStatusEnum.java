package com.weixin.openapi.enums.cp;


import lombok.Getter;

@Getter
public enum WxCpSpStatusEnum {
    /**
     * 审批中
     */
    AUDITING(1),
    /**
     * 已通过
     */
    PASSED(2),
    /**
     * 已驳回
     */
    REJECTED(3),
    /**
     * 已撤销
     */
    UNDONE(4),
    /**
     * 通过后撤销
     */
    PASS_UNDONE(6),
    /**
     * 已删除
     */
    DELETED(7),
    /**
     * 已支付
     */
    ALREADY_PAY(10);

    private final Integer status;

    WxCpSpStatusEnum(Integer status) {
        this.status = status;
    }

    public static WxCpSpStatusEnum getByName(String name){
        for(WxCpSpStatusEnum item:WxCpSpStatusEnum.values()){
            if(item.name().equals(name)){
                return item;
            }
        }
        return null;
    }
}
