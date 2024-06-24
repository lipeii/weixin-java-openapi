package com.weixin.openapi.cp.model.response.oa.apply;

import lombok.Data;
import java.util.List;

/**
 * 审批申请备注信息
 */
@Data
public class WxCpApprovalCommentResponse {

  /**
   * 备注人信息
   */
  private WxCpOperatorResponse commentUserInfo;

  /**
   * 备注提交时间戳，Unix时间戳
   */
  private Long commentTime;

  /**
   * 备注id
   */
  private String commentId;

  /**
   * 备注文本内容
   */
  private String commentContent;

  /**
   * 备注附件id，可能有多个
   */
  private List<String> mediaIds;

}
