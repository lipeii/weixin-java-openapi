package com.weixin.openapi.cp.config;

import com.google.common.collect.Maps;
import com.weixin.openapi.cp.config.properties.WxCpProperties;
import com.weixin.openapi.exception.BusinessException;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import me.chanjar.weixin.cp.api.WxCpService;
import me.chanjar.weixin.cp.api.impl.WxCpServiceImpl;
import me.chanjar.weixin.cp.config.impl.WxCpDefaultConfigImpl;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Configuration
@EnableConfigurationProperties(WxCpProperties.class)
public class WxCpConfig {

    private static Map<String, WxCpService> cpServiceMap = Maps.newHashMap();

    @Resource
    private WxCpProperties wxCpProperties;

    public WxCpService getCpService(String corpId, Integer agentId){
        WxCpService service = cpServiceMap.get(corpId + agentId);
        return Optional.ofNullable(service).orElseThrow(() -> new BusinessException("未获取到企业配置"));
    }

    @PostConstruct
    public void initServices(){
        cpServiceMap = wxCpProperties.getAppConfigs().stream().map(item -> {
            WxCpDefaultConfigImpl config = new WxCpDefaultConfigImpl();
            config.setCorpId(item.getCorpId());
            config.setCorpSecret(item.getSecret());
            config.setAgentId(item.getAgentId());
            config.setToken(item.getToken());
            config.setAesKey(item.getAesKey());

            WxCpService wxCpService = new WxCpServiceImpl();
            wxCpService.setWxCpConfigStorage(config);
            return wxCpService;
        }).collect(Collectors.toMap(item -> item.getWxCpConfigStorage().getCorpId() + item.getWxCpConfigStorage().getAgentId(), Function.identity()));
    }
}
