package cn.young.manager.pojo;

import java.io.Serializable;

public class Course implements Serializable {
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
        this.schName = schName == null ? null : schName.trim();
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode == null ? null : courseCode.trim();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public String getCourseInfo() {
        return courseInfo;
    }

    public void setCourseInfo(String courseInfo) {
        this.courseInfo = courseInfo == null ? null : courseInfo.trim();
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
        this.courseRemark = courseRemark == null ? null : courseRemark.trim();
    }

    public String getCourseDes() {
        return courseDes;
    }

    public void setCourseDes(String courseDes) {
        this.courseDes = courseDes == null ? null : courseDes.trim();
    }

    public String getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(String courseImage) {
        this.courseImage = courseImage == null ? null : courseImage.trim();
    }
}