package cn.young.manager.service;

import cn.young.common.pojo.EasyUIDataGrid;
import cn.young.common.pojo.YoungResult;
import cn.young.manager.pojo.CourseSelected;

import java.util.List;

public interface CourseSelectedService {

    EasyUIDataGrid getCourseSelectedList(int page,int rows);

    YoungResult clearEvaluation(long uid,long cid);


    /**
     * 根据课程编号，查询所有用户评分，评价日期，文字评价
     * @param course_code
     * @return
     */
    List<CourseSelected> getAllRemarkByCourse_code(String course_code);

    /**
     * 选择课程的核心逻辑
     * @param cid
     * @param uid
     * @param course_code
     * @return
     */
    String chooseCourse(int cid, int uid, String course_code);

    /**
     * 退出课程的核心逻辑
     * @param cid
     * @param uid
     * @return
     */
    String quitCourse(int cid, int uid);

    /**
     * 是否已经选课
     * @param cid
     * @param uid
     * @return
     */
    int hasChoosed(int cid, int uid);
}
