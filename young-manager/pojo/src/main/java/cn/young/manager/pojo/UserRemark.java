package cn.young.manager.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 课程详情页的用户评价专区
 */
public class UserRemark {
    private String uname;   //用户名
    private String uimage;  //用户头像
    private Integer mark;   //用户评分
    private String content; //用户评价
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date content_date;  //评价日期

    public UserRemark() {
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUimage() {
        return uimage;
    }

    public void setUimage(String uimage) {
        this.uimage = uimage;
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
