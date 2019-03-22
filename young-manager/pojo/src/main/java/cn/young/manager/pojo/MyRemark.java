package cn.young.manager.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class MyRemark {
    private Long cid;
    private String courseCode;
    private String courseName;
    private String schName;
    private Integer mark;   //评分
    private String content; //文字评价
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date content_date; //评价日期

    public MyRemark() {
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getSchName() {
        return schName;
    }

    public void setSchName(String schName) {
        this.schName = schName;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public Date getContent_date() {
        return content_date;
    }

    public void setContent_date(Date content_date) {
        this.content_date = content_date;
    }
}
