package com.weixin.openapi.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "wechat.cp")
public class WxCpProperties {

    private List<AppConfig> appConfigs;


    @Data
    public static class AppConfig{

        /**
         * 微信企业号corpId
         */
        private String corpId;

        /**
         * 微信企业号app corpSecret
         */
        private String secret;

        /**
         * 企业微信应用ID
         */
        private Integer agentId;

        /**
         * 企业微信应用token
         */
        private String token;

        /**
         * 企业微信应用EncodingAESKey
         */
        private String aesKey;
    }
}
