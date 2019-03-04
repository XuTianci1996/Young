package cn.young.manager.dao;

import cn.young.manager.pojo.Evalution;
import cn.young.manager.pojo.EvalutionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EvalutionMapper {
    long countByExample(EvalutionExample example);

    int deleteByExample(EvalutionExample example);

    int deleteByPrimaryKey(Long eid);

    int insert(Evalution record);

    int insertSelective(Evalution record);

    List<Evalution> selectByExample(EvalutionExample example);

    Evalution selectByPrimaryKey(Long eid);

    int updateByExampleSelective(@Param("record") Evalution record, @Param("example") EvalutionExample example);

    int updateByExample(@Param("record") Evalution record, @Param("example") EvalutionExample example);

    int updateByPrimaryKeySelective(Evalution record);

    int updateByPrimaryKey(Evalution record);
}