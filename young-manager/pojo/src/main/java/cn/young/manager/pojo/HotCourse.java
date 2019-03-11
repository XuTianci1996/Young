package cn.young.manager.pojo;

public class HotCourse {
    private int cid;
    private String courseName;
    private String courseImage;
    private String schName;
    private int  courseSelectnum;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(String courseImage) {
        this.courseImage = courseImage;
    }

    public String getSchName() {
        return schName;
    }

    public void setSchName(String schName) {
        this.schName = schName;
    }

    public int getCourseSelectnum() {
        return courseSelectnum;
    }

    public void setCourseSelectnum(int courseSelectnum) {
        this.courseSelectnum = courseSelectnum;
    }

    public HotCourse(int cid, String courseName, String courseImage, String schName, int courseSelectnum) {
        this.cid = cid;
        this.courseName = courseName;
        this.courseImage = courseImage;
        this.schName = schName;
        this.courseSelectnum = courseSelectnum;
    }

    public HotCourse() {
        super();
    }
}
