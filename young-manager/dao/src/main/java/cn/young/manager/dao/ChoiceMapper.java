package cn.young.manager.dao;

import cn.young.manager.pojo.Choice;
import cn.young.manager.pojo.ChoiceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChoiceMapper {
    long countByExample(ChoiceExample example);

    int deleteByExample(ChoiceExample example);

    int insert(Choice record);

    int insertSelective(Choice record);

    List<Choice> selectByExampleWithBLOBs(ChoiceExample example);

    List<Choice> selectByExample(ChoiceExample example);

    int updateByExampleSelective(@Param("record") Choice record, @Param("example") ChoiceExample example);

    int updateByExampleWithBLOBs(@Param("record") Choice record, @Param("example") ChoiceExample example);

    int updateByExample(@Param("record") Choice record, @Param("example") ChoiceExample example);
}