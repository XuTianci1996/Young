package cn.young.manager.service.Impl;


import cn.young.manager.pojo.HotCourse;
import cn.young.manager.service.HotCourseService;
import cn.young.mapper.HotCourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotCourseServiceImpl implements HotCourseService {
	@Autowired
	private HotCourseMapper dao;


	@Override
	public List<HotCourse> findAllHotCourse() {

		System.out.println("=====dao======"+dao);
		System.out.println("=====findall======"+dao.findAllHotCourse());

		return dao.findAllHotCourse();
	}
}

