package com.weixin.openapi.cp.api.impl;

import com.alibaba.fastjson2.JSON;
import com.weixin.openapi.cp.api.IWxCpOaDao;
import com.weixin.openapi.cp.bo.request.oa.apply.WxCpApprovalDetailQueryRequestBO;
import com.weixin.openapi.cp.bo.request.oa.apply.WxCpApprovalInfoQueryRequestBO;
import com.weixin.openapi.cp.bo.response.oa.apply.WxCpApprovalDetailResponseBO;
import com.weixin.openapi.cp.bo.response.oa.apply.WxCpApprovalInfoResponseBO;
import com.weixin.openapi.cp.config.WxCpConfig;
import com.weixin.openapi.exception.BusinessException;
import jakarta.annotation.Resource;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.cp.api.WxCpOaService;
import me.chanjar.weixin.cp.bean.oa.WxCpApprovalDetailResult;
import me.chanjar.weixin.cp.bean.oa.WxCpApprovalInfo;
import org.springframework.stereotype.Service;

/**
 * 企业微信oa 业务
 */
@Slf4j
@Service
public class WxCpOaDaoImpl implements IWxCpOaDao {

    @Resource
    private WxCpConfig wxCpConfig;

    /**
     * 企业微信批量获取审批单号
     * @param bo 入参
     * @return 结果
     */
    @Override
    public WxCpApprovalInfoResponseBO getApprovalInfo(@NonNull WxCpApprovalInfoQueryRequestBO bo) {
        try {
            WxCpOaService wxCpOaService = wxCpConfig.getCpService(bo.getCorpId(),bo.getAgentId()).getOaService();
            WxCpApprovalInfo info = wxCpOaService.getApprovalInfo(bo.getStartTime(),bo.getEndTime(),bo.getNewCursor(),bo.getSize(),bo.getFilters());
            return WxCpApprovalInfoResponseBO.build(info);
        }catch (Exception e){
            log.error("[cp-oa]企业微信批量获取审批单号:{},request:{}",e.getMessage(), JSON.toJSONString(bo),e);
            throw new BusinessException(e.getMessage());
        }
    }

    /**
     * 企业微信获取审批申请详情
     * @param bo 入参
     * @return 结果
     */
    @Override
    public WxCpApprovalDetailResponseBO getApprovalDetail(@NonNull WxCpApprovalDetailQueryRequestBO bo) {
        try {
            WxCpOaService wxCpOaService = wxCpConfig.getCpService(bo.getCorpId(),bo.getAgentId()).getOaService();
            WxCpApprovalDetailResult result = wxCpOaService.getApprovalDetail(bo.getSpNo());
            return WxCpApprovalDetailResponseBO.build(result);
        }catch (Exception e){
            log.error("[cp-oa]企业微信获取审批申请详情:{},request:{}",e.getMessage(), JSON.toJSONString(bo),e);
            throw new BusinessException(e.getMessage());
        }
    }
}
