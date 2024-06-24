package com.weixin.openapi.cp.bo.response.oa.apply;

import com.google.common.collect.Lists;
import lombok.Data;
import me.chanjar.weixin.cp.bean.oa.WxCpApprovalComment;

import java.util.ArrayList;
import java.util.List;

/**
 * 审批申请备注信息
 */
@Data
public class WxCpApprovalCommentResponseBO {

  /**
   * 备注人信息
   */
  private WxCpOperatorResponseBO commentUserInfo;

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

  public static List<WxCpApprovalCommentResponseBO> build(List<WxCpApprovalComment> list){
    List<WxCpApprovalCommentResponseBO> responseBOList = new ArrayList<>();
    for (WxCpApprovalComment comment:list){
      responseBOList.add(build(comment));
    }
    return responseBOList;
  }

  public static WxCpApprovalCommentResponseBO build(WxCpApprovalComment comment){
    WxCpApprovalCommentResponseBO responseBO = new WxCpApprovalCommentResponseBO();
    responseBO.setCommentUserInfo(WxCpOperatorResponseBO.build(comment.getCommentUserInfo()));
    responseBO.setCommentTime(comment.getCommentTime());
    responseBO.setCommentId(comment.getCommentId());
    responseBO.setCommentContent(comment.getCommentContent());
    responseBO.setMediaIds(Lists.newArrayList(comment.getMediaIds()));
    return responseBO;
  }

}
