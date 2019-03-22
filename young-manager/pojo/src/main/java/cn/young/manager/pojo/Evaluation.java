package cn.young.manager.pojo;

import java.io.Serializable;

public class Evaluation implements Serializable {
    private Long eid;

    private String course_code;


    //包装类改为原始类型了。。。
    private double average_mark;
    private int total;

    private int rate_five;
    private int rate_four;
    private int rate_three;
    private int rate_two;
    private int rate_one;


    /**
     * 新增构造函数1
     * @param course_code
     */
    public Evaluation(String course_code){
        this.course_code = course_code;
    }

    /**
     * 空参构造
     */
    public Evaluation(){
    }

    /**
     * 原先字段的全参构造
     * @return
     */
    public Evaluation(Long eid, String course_code, Double average_mark, Integer total) {
        this.eid = eid;
        this.course_code = course_code;
        this.average_mark = average_mark;
        this.total = total;
    }


    /**
     * 新增字段后的全参构造
     * @return
     */
    public Evaluation(Long eid, String course_code, Double average_mark, Integer total,
                      int rate_five, int rate_four, int rate_three, int rate_two, int rate_one) {
        this.eid = eid;
        this.course_code = course_code;
        this.average_mark = average_mark;
        this.total = total;
        this.rate_five = rate_five;
        this.rate_four = rate_four;
        this.rate_three = rate_three;
        this.rate_two = rate_two;
        this.rate_one = rate_one;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public Double getAverage_mark() {
        return average_mark;
    }

    public void setAverage_mark(Double average_mark) {
        this.average_mark = average_mark;
    }

    public Long getEid() {
        return eid;
    }

    public void setEid(Long eid) {
        this.eid = eid;
    }

    public String getCourseCode() {
        return course_code;
    }

    public void setCourseCode(String course_code) {
        this.course_code = course_code == null ? null : course_code.trim();
    }

    public Double getAverageMark() {
        return average_mark;
    }

    public void setAverageMark(Double average_mark) {
        this.average_mark = average_mark;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

//    新字段的getter与setter

    public int getRate_five() {
        return rate_five;
    }

    public void setRate_five(int rate_five) {
        this.rate_five = rate_five;
    }

    public int getRate_four() {
        return rate_four;
    }

    public void setRate_four(int rate_four) {
        this.rate_four = rate_four;
    }

    public int getRate_three() {
        return rate_three;
    }

    public void setRate_three(int rate_three) {
        this.rate_three = rate_three;
    }

    public int getRate_two() {
        return rate_two;
    }

    public void setRate_two(int rate_two) {
        this.rate_two = rate_two;
    }

    public int getRate_one() {
        return rate_one;
    }

    public void setRate_one(int rate_one) {
        this.rate_one = rate_one;
    }
}