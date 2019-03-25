package cn.young.service;

import cn.young.manager.pojo.Course;
import cn.young.manager.pojo.CourseSelected;
import cn.young.mapper.CourseMapper;
import cn.young.mapper.CourseSelectedMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;


//@RunWith(SpringJUnit4ClassRunner.class)

//@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml", "classpath:spring/springmvc.xml"})
public class CourseSelectedServiceTest {

    public static void main(String[] args) {
        CourseSelected[] info = courseSelected.getInfo();
        System.out.println(info.length);
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
//        SqlSessionFactory factory = (SqlSessionFactory) context.getBean("sqlSessionFactory");
//        //获得会话对象
//        SqlSession session = factory.openSession(true);
//        try {
//            CourseSelectedMapper courseSelectedMapper = session.getMapper(CourseSelectedMapper.class);
////            System.out.println(courseSelectedMapper.updateRemarkByCidAndUid(550, 15, "H啊哈哈哈", 4, new Date()));
//            List<Integer> markList = courseSelectedMapper.getAllMarkByCourse_code("AC15201");
//            for(int ele:markList){
//                System.out.println(ele);
//            }
//
//        } finally {
//            session.close();
//        }

    }


}