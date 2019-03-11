package cn.young.manager.service.Impl;


import cn.young.common.pojo.EasyUIDataGrid;
import cn.young.manager.pojo.CourseSelected;
import cn.young.manager.pojo.CourseSelectedExample;
import cn.young.manager.service.CourseSelectedService;
import cn.young.mapper.CourseSelectedMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseSelectedServiceImpl implements CourseSelectedService {

    @Autowired
    CourseSelectedMapper courseSelectedMapper;

    @Override
    public EasyUIDataGrid getCourseSelectedList(int page, int rows) {
        PageHelper.startPage(page,rows);
        //执行查询
        CourseSelectedExample courseExample = new CourseSelectedExample();
        List<CourseSelected> courseList = courseSelectedMapper.selectByExampleWithBLOBs(courseExample);
        for (CourseSelected selected: courseList) {
            String contentDate= selected.getContentDate().toString();
        }
        PageInfo<CourseSelected> pageInfo = new PageInfo(courseList);
        //创建一个返回值对象
        EasyUIDataGrid result = new EasyUIDataGrid();
        result.setRows(courseList);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

}
