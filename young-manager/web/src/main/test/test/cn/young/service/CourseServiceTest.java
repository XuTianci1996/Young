package cn.young.service;

import cn.young.manager.pojo.Course;
import cn.young.mapper.CourseMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml", "classpath:spring/springmvc.xml"})
public class CourseServiceTest {

    @Autowired
    CourseMapper courseMapper;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
        SqlSessionFactory factory = (SqlSessionFactory) context.getBean("sqlSessionFactory");
        //获得会话对象
        SqlSession session = factory.openSession(true);
        try {
            CourseMapper courseMapper = session.getMapper(CourseMapper.class);
            Course course = courseMapper.getCourseByCid(23);
            System.out.println(course.getCourseCode());

//            List<CourseSelected> courseSelectedList = courseSelectedMapper.getLimitedRemarkByCourse_code(10,5,"AC15201");//0
//
//            for(CourseSelected ele:courseSelectedList){
//                System.out.println(ele.getContent());
//            }
        } finally {
            session.close();
        }
    }
}