package com.weixin.openapi.cp.bo.response.oa.apply;

import lombok.Data;
import me.chanjar.weixin.cp.bean.oa.applydata.ContentTitle;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Content title.
 *
 * @author element
 */
@Data
public class ContentTitleResponseBO {


  private String text;
  private String lang;

  public static List<ContentTitleResponseBO> build(List<ContentTitle> list){
    List<ContentTitleResponseBO> responseBOList = new ArrayList<>();
    for(ContentTitle item:list){
      responseBOList.add(build(item));
    }
    return responseBOList;
  }

  public static ContentTitleResponseBO build(ContentTitle title){
    ContentTitleResponseBO responseBO = new ContentTitleResponseBO();
    responseBO.setLang(title.getLang());
    responseBO.setText(title.getText());
    return responseBO;
  }

}
