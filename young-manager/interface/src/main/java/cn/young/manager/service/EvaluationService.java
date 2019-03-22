package cn.young.manager.service;

import cn.young.common.pojo.EasyUIDataGrid;
import cn.young.manager.pojo.Evaluation;

public interface EvaluationService {

    EasyUIDataGrid getEvaluation(int page ,int rows);

    /**
     * 根据课程编码，获取他的全部课程评价信息
     * @param course_code
     * @return com.harson.entities.Evaluation
     */
    Evaluation getEvaluationByCourse_code(String course_code);

    /**
     * 插入新的课程评价
     * @param evaluation
     * @return
     */
    int insertEvaluation(Evaluation evaluation);

    int updateEvaluation(Evaluation evaluation);
}
