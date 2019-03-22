package cn.young.manager.service.Impl;


import cn.young.common.pojo.EasyUIDataGrid;
import cn.young.common.pojo.YoungResult;
import cn.young.manager.pojo.Course;
import cn.young.manager.pojo.CourseSelected;
import cn.young.manager.pojo.CourseSelectedExample;
import cn.young.manager.service.CourseSelectedService;
import cn.young.mapper.CourseMapper;
import cn.young.mapper.CourseSelectedMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseSelectedServiceImpl implements CourseSelectedService {

    @Autowired
    CourseSelectedMapper courseSelectedMapper;

    @Autowired
    CourseMapper courseMapper;


    @Override
    public EasyUIDataGrid getCourseSelectedList(int page, int rows) {
        PageHelper.startPage(page,rows);
        //执行查询
        CourseSelectedExample courseExample = new CourseSelectedExample();
        List<CourseSelected> courseList = courseSelectedMapper.selectByExampleWithBLOBs(courseExample);
        PageInfo<CourseSelected> pageInfo = new PageInfo(courseList);
        //创建一个返回值对象
        EasyUIDataGrid result = new EasyUIDataGrid();
        result.setRows(courseList);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public YoungResult clearEvaluation(long uid, long cid ) {
        courseSelectedMapper.clearEvaluation(uid, cid);
        return YoungResult.ok();
    }


    /**
     * 根据课程编号，查询所有用户评分，评价日期，文字评价
     *
     * @param course_code
     * @return
     */
    @Override
    public List<CourseSelected> getAllRemarkByCourse_code(String course_code) {
        return courseSelectedMapper.getAllRemarkByCourse_code(course_code);
    }

    /**
     * 选择课程的核心逻辑
     *
     * @param cid
     * @param uid
     * @param course_code
     * @return
     */
    @Transactional
    @Override
    public String chooseCourse(int cid, int uid, String course_code) {
        //先查询选课人数满了没，满了返回FULL
        long cidLong = cid;
        Course course = courseMapper.selectByPrimaryKey(cidLong);
        if (course.getCourseSelectnum() >= course.getCourseTotalnum()) {
            return "FULL";
        }
        //直接update，返回值为1，则OK
        int res = courseSelectedMapper.updateCourseSelectedToChoose(cid, uid);
        //res == 0 表中不存在这条选课信息
        if (res == 0) {
            //根据cid, uid, course_code，插入新行，返回值为1，则OK
            res = courseSelectedMapper.insertCourseSelected(cid, uid, course_code);
        }
//        int i = 1/0;
        if (res == 1) {
            //更新course表，选课人数加一
            courseMapper.addSelectNum(cid);
            return "OK";
        }

        //返回FAIL
        return "FAIL";
    }

    /**
     * 退出课程的核心逻辑
     * @param cid
     * @param uid
     * @return
     */
    @Transactional
    @Override
    public String quitCourse(int cid, int uid) {
        //直接update，返回值为1，则OK
        int res = courseSelectedMapper.updateCourseSelectedToQuit(cid, uid);
//        int i = 1/0;
        if (res == 1) {
            //更新course表，选课人数加一
            courseMapper.subSelectNum(cid);
            return "OK";
        }
        return "FAIL";
    }

    /**
     * 是否已经选课，1已选，0没选
     *
     * @param cid
     * @param uid
     * @return
     */
    @Override
    public int hasChoosed(int cid, int uid) {
        if(courseSelectedMapper.hasChoosed(cid, uid) == null){
            return 0;
        }
        return courseSelectedMapper.hasChoosed(cid, uid);
    }

}
