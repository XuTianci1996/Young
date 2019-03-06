package cn.young.mapper;

import cn.young.manager.pojo.CourseSelected;
import cn.young.manager.pojo.CourseSelectedExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseSelectedMapper {
    long countByExample(CourseSelectedExample example);

    int deleteByExample(CourseSelectedExample example);

    int insert(CourseSelected record);

    int insertSelective(CourseSelected record);

    List<CourseSelected> selectByExampleWithBLOBs(CourseSelectedExample example);

    List<CourseSelected> selectByExample(CourseSelectedExample example);

    int updateByExampleSelective(@Param("record") CourseSelected record, @Param("example") CourseSelectedExample example);

    int updateByExampleWithBLOBs(@Param("record") CourseSelected record, @Param("example") CourseSelectedExample example);

    int updateByExample(@Param("record") CourseSelected record, @Param("example") CourseSelectedExample example);
}