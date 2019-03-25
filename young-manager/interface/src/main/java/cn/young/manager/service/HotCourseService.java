package cn.young.manager.service;

import cn.young.manager.pojo.Course;
import cn.young.manager.pojo.HotCourse;

import java.util.List;

public interface HotCourseService {

	/**
	 * 查询所有热门课程信息
	 *
	 * @return
	 */
	public List<HotCourse> findAllHotCourse();

	/**
	 * 首页推荐课程
	 * @return
	 */
	List<Course> getRecommendCourse();
}
