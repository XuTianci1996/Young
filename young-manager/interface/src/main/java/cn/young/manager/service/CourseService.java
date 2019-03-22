package cn.young.manager.service;


import cn.young.common.pojo.EasyUIDataGrid;
import cn.young.manager.pojo.Course;
import cn.young.manager.pojo.Page;
import cn.young.manager.pojo.PagingData;

import java.util.List;

public interface CourseService {

    Course getCourseinfoById(long id);

    //获取所有的用户
    EasyUIDataGrid getCourseList(int page, int rows);

    List<Course> selectAllCourseBySchoolName(String sname);

    EasyUIDataGrid selectAllCourseBySchool(String sname);

    public List<Course> findCourseBySid(Page page);
    /**
     * 条件查询
     * @param keywords
     * @return
     */
    public List<Course> findCourseByLike(String keywords);


    /**
     * 通过课程id获取课程信息
     * @param cid
     * @return
     */
    Course getCourseByCid(int cid);

    /**
     * 根据用户uid，获取他的选课信息，分页！！
     * @param uid
     * @param page
     * @param limit
     * @return
     */
    PagingData<Course> getMyCourseByUid(int uid, int page, int limit);
}
