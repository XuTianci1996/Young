package cn.young.manager.service;

import cn.young.common.pojo.EasyUIDataGrid;
import cn.young.common.pojo.YoungResult;
import cn.young.manager.pojo.CourseSelected;
import cn.young.manager.pojo.MyRemark;
import cn.young.manager.pojo.PagingData;
import cn.young.manager.pojo.UserRemark;

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

    /**
     * 根据用户id，获取他的全部评价信息（course_selected中）和必要的课程信息（course表中）
     * @param uid
     * @param page
     * @param limit
     * @return
     */
    PagingData<MyRemark> getMyRemarkByUid(int uid, int page, int limit);

    /**
     * 选出用户对某门课程的评价
     * @param cid
     * @param uid
     * @return
     */
    CourseSelected getMyRemarkByCidAndUid(int cid, int uid);

    /**
     * 根据cid，uid修改用户对这门课程的评价
     * @param cid
     * @param uid
     * @param content
     * @param mark
     * @return
     */
    int updateRemark(int cid, int uid, String content, int mark);

    /**
     * 从course_selected表中，根据course_code选出当前课程的所有评分
     * @param courseCode
     * @return
     */
    List<Integer> getAllMarkByCourse_code(String courseCode);
}
