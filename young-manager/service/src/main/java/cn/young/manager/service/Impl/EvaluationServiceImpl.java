package cn.young.manager.service.Impl;

import cn.young.common.pojo.EasyUIDataGrid;
import cn.young.manager.pojo.Course;
import cn.young.manager.pojo.CourseExample;
import cn.young.manager.pojo.Evaluation;
import cn.young.manager.pojo.EvaluationExample;
import cn.young.manager.service.EvaluationService;
import cn.young.mapper.EvaluationMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class EvaluationServiceImpl implements EvaluationService {

    @Autowired
    EvaluationMapper evaluationMapper;

    @Override
    public EasyUIDataGrid getEvaluation(int page, int rows) {
        PageHelper.startPage(page,rows);
        //执行查询
        EvaluationExample evaluationExample = new EvaluationExample();
        List<Evaluation> evaluationList = evaluationMapper.selectByExample(evaluationExample);
        PageInfo<Course> pageInfo = new PageInfo(evaluationList);
        //创建一个返回值对象
        EasyUIDataGrid result = new EasyUIDataGrid();
        result.setRows(evaluationList);
        result.setTotal(pageInfo.getTotal());
        return result;
    }
}
