package com.weixin.openapi.cp.model.response.oa.apply;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * The type Content value.
 *
 */
@Data
public class ContentValueResponse {

  private String text;

  private String newNumber;

  private String newMoney;

  private Date date;

  private Selector selector;

  private List<Member> members;

  private List<Department> departments;

  private List<File> files;

  private List<Child> children;

  private List<RelatedApproval> relatedApproval;

  private Attendance attendance;

  private Vacation vacation;

  private Attendance.DataRange dateRange;

  private PunchCorrection punchCorrection;

  private Location location;

  private Formula formula;

  /**
   * The type Date.
   */
  @Data
  public static class Date {

    private String type;

    private String timestamp;
  }

  /**
   * The type Selector.
   */
  @Data
  public static class Selector {

    private String type;

    private List<Option> options;

    /**
     * The type Option.
     */
    @Data
    public static class Option {

      private String key;

      private List<ContentValueResponse> values;
    }

  }

  /**
   * The type Member.
   */
  @Data
  public static class Member {

    private String userId;

    private String name;
  }

  /**
   * The type Department.
   */
  @Data
  public static class Department {

    private String openApiId;

    private String name;
  }

  /**
   * The type File.
   */
  @Data
  public static class File{

    private String fileId;
  }

  /**
   * The type Child.
   */
  @Data
  public static class Child{
    private List<ApplyDataContentResponse> list;
  }

  /**
   * The type Attendance.
   */
  @Data
  public static class Attendance{
    private DataRange dateRange;
    private Integer type;

    /**
     * The type Data range.
     */
    @Data
    public static class DataRange{

      private String type;

      private Long begin;

      private Long end;

      private Long duration;
    }
  }

  /**
   * The type Vacation.
   */
  @Data
  public static class Vacation{

    private Selector selector;

    private Attendance attendance;
  }

  /**
   * 关联审批单控件
   */
  @Data
  public static class RelatedApproval {
    /**
     * 关联审批单的模板名
     */
    private List<TemplateName> templateNames;
    /**
     * 关联审批单的状态
     */
    private Integer spStatus;
    /**
     * 关联审批单的提单者
     */
    private String name;
    /**
     * 关联审批单的提单时间
     */
    private Long createTime;
    /**
     * 关联审批单的审批单号
     */
    private String spNo;
  }

  /**
   * The type Template name.
   */
  @Data
  public static class TemplateName {

    private String text;

    private String lang;
  }

  /**
   * The type Punch correction.
   */
  @Data
  public static class PunchCorrection {

    private String state;

    private Long time;

    private Integer version;

    private Long dayMonthYear;
  }

  /**
   * The type Location
   */
  @Data
  public static class Location {
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String title;
    private String address;
    private Long time;
  }

  /**
   * The type Formula
   */
  @Data
  public static class Formula {
    private String value;
  }

}
