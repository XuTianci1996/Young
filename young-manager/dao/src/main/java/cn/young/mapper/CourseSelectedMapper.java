package cn.young.mapper;

import cn.young.manager.pojo.CourseSelected;
import cn.young.manager.pojo.CourseSelectedExample;

import java.util.Date;
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

    int clearEvaluation(@Param("uid")long uid,@Param("cid")long cid);

    /**
     * 根据课程编号，从用户选课表中，获取用户的评价信息
     * @param course_code
     * @return
     */
    List<CourseSelected> getAllRemarkByCourse_code(String course_code);

    /**
     * 先试试看根据课程和用户，是否能成功更新ischoose
     * @param cid
     * @param uid
     * @return
     */
    int updateCourseSelectedToChoose(@Param("cid") int cid, @Param("uid") int uid);

    /**
     * 不能成功更新，就插入新的行！！但是插之前，注意另一表course的人数限制！！！
     * @param cid
     * @param uid
     * @param course_code
     * @return
     */
    int insertCourseSelected(@Param("cid") int cid, @Param("uid") int uid, @Param("course_code") String course_code);

    /**
     * 根据课程和用户，更新ischoose为0
     * @param cid
     * @param uid
     * @return int
     */
    int updateCourseSelectedToQuit(@Param("cid") int cid, @Param("uid") int uid);

    /**
     * 用户是否已经选课，1已选，0没选
     * @param cid
     * @param uid
     * @return
     */
    Integer hasChoosed(@Param("cid") int cid, @Param("uid") int uid);

    /**
     * 根据course_code，获取指定范围内的用户评价数据
     * @param index
     * @param limit
     * @param course_code
     */
    List<CourseSelected> getLimitedRemarkByCourse_code(@Param("index") int index, @Param("limit") int limit, @Param("course_code") String course_code);

    /**
     * 获取当前course_code的评价总数
     * @param course_code
     * @return
     */
    int getRemarkNumByCourse_code(@Param("course_code") String course_code);

    /**
     * 获取cid
     *
     * @param uid
     * @return
     */
    List<Integer> getCidByUid(@Param("uid") int uid);

    /**
     * 根据uid选取当前用户选课总数
     * @param uid
     * @return
     */
    int getSelectedCountByUid(@Param("uid") int uid);

    /**
     * 获取分页后的cid
     * @param uid
     * @param index
     * @param limit
     * @return
     */
    List<Integer> getLimitedCidByUid(@Param("uid") int uid, @Param("index") int index, @Param("limit") int limit);

    /**
     * 根据用户uid，获取他的评价信息（分页）
     * @param uid
     * @param index
     * @param limit
     * @return
     */
    List<CourseSelected> getLimitedRemarkByUid(@Param("uid") int uid,  @Param("index") int index, @Param("limit") int limit);

    /**
     * 选出用户对某门课程的评价
     * @param cid
     * @param uid
     * @return
     */
    CourseSelected getMyRemarkByCidAndUid(@Param("cid") int cid, @Param("uid") int uid);

    /**
     * 根据cid，uid修改用户对这门课程的评价
     *
     * @param cid
     * @param uid
     * @param content
     * @param mark
     * @return
     */
    int updateRemarkByCidAndUid(@Param("cid") int cid, @Param("uid") int uid, @Param("content") String content,
                                @Param("mark") int mark, @Param("content_date") Date content_date);

    /**
     * 从course_selected表中，根据course_code选出当前课程的所有评分
     *
     * @param courseCode
     * @return
     */
    List<Integer> getAllMarkByCourse_code(@Param("courseCode") String courseCode);
}