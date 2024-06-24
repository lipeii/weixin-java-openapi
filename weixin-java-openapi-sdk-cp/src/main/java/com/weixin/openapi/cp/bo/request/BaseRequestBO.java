package com.weixin.openapi.cp.bo.request;

import lombok.Data;

/**
 * 企业微信基础 业务请求模型
 */
@Data
public class BaseRequestBO {

    /**
     * 企业ID
     */
    private String corpId;

    /**
     * 企业微信应用ID
     */
    private Integer agentId;
}
