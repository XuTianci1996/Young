package cn.young.manager.service.Impl;

import cn.young.common.pojo.EasyUIDataGrid;
import cn.young.manager.pojo.Course;
import cn.young.manager.pojo.CourseExample;
import cn.young.manager.pojo.User;
import cn.young.manager.pojo.UserExample;
import cn.young.manager.service.CourseService;
import cn.young.mapper.CourseMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Course getCourseinfoById(long id) {
        return courseMapper.selectByPrimaryKey(id);
    }

    /**
     *
     * @param page
     * @param rows
     * @return
     */
    @Override
    public EasyUIDataGrid getUserList(int page, int rows) {
        PageHelper.startPage(page,rows);
        //执行查询
        CourseExample courseExample = new CourseExample();
        courseExample.setOrderByClause("course_selectnum");
        List<Course> courseList = courseMapper.selectByExample(courseExample);
        PageInfo<Course> pageInfo = new PageInfo(courseList);
        System.out.println();
        //创建一个返回值对象
        EasyUIDataGrid result = new EasyUIDataGrid();
        result.setRows(courseList);
        result.setTotal(pageInfo.getTotal());
        return result;
    }
}
