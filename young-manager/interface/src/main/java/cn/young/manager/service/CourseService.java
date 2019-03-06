package cn.young.manager.service;


import cn.young.common.pojo.EasyUIDataGrid;
import cn.young.manager.pojo.Course;

public interface CourseService {

    Course getCourseinfoById(long id);

    //获取所有的用户
    EasyUIDataGrid getUserList(int page, int rows);
}
