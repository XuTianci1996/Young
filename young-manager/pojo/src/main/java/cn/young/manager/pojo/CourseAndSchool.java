package cn.young.manager.pojo;

import java.io.Serializable;

public class CourseAndSchool implements Serializable {
    private Long cid;

    private String schName;

    private String courseCode;

    private String courseName;

    private String courseInfo;

    private Integer courseSelectnum;

    private Integer courseTotalnum;

    private String courseRemark;

    private String courseDes;

    private String courseImage;

    private Long sid;

    private String schImage;

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getSchName() {
        return schName;
    }

    public void setSchName(String schName) {
        this.schName = schName;
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

    public String getCourseInfo() {
        return courseInfo;
    }

    public void setCourseInfo(String courseInfo) {
        this.courseInfo = courseInfo;
    }

    public Integer getCourseSelectnum() {
        return courseSelectnum;
    }

    public void setCourseSelectnum(Integer courseSelectnum) {
        this.courseSelectnum = courseSelectnum;
    }

    public Integer getCourseTotalnum() {
        return courseTotalnum;
    }

    public void setCourseTotalnum(Integer courseTotalnum) {
        this.courseTotalnum = courseTotalnum;
    }

    public String getCourseRemark() {
        return courseRemark;
    }

    public void setCourseRemark(String courseRemark) {
        this.courseRemark = courseRemark;
    }

    public String getCourseDes() {
        return courseDes;
    }

    public void setCourseDes(String courseDes) {
        this.courseDes = courseDes;
    }

    public String getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(String courseImage) {
        this.courseImage = courseImage;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getSchImage() {
        return schImage;
    }

    public void setSchImage(String schImage) {
        this.schImage = schImage;
    }

    public String getSchDes() {
        return schDes;
    }

    public void setSchDes(String schDes) {
        this.schDes = schDes;
    }

    private String schDes;
}
