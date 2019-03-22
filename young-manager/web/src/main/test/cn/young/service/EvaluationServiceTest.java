package cn.young.service;

import cn.young.manager.pojo.Evaluation;
import cn.young.mapper.CourseSelectedMapper;
import cn.young.mapper.EvaluationMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml", "classpath:spring/springmvc.xml"})
public class EvaluationServiceTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
        SqlSessionFactory factory = (SqlSessionFactory) context.getBean("sqlSessionFactory");
        //获得会话对象
        SqlSession session = factory.openSession(true);
        try {
            EvaluationMapper evaluationMapper = session.getMapper(EvaluationMapper.class);
            System.out.println(evaluationMapper.getEvaluationByCourse_code("AC15202").getAverageMark()); //1
            System.out.println(evaluationMapper.getEvaluationByCourse_code("AC15202").getCourseCode()); //1
            System.out.println(evaluationMapper.getEvaluationByCourse_code("AC15202").getEid()); //2
            System.out.println(evaluationMapper.getEvaluationByCourse_code("AC15202").getTotal()); //23
            System.out.println(evaluationMapper.getEvaluationByCourse_code("AC15202").getRate_five()); //23
            System.out.println(evaluationMapper.getEvaluationByCourse_code("AC15202").getRate_four()); //23
            System.out.println(evaluationMapper.getEvaluationByCourse_code("AC15202").getRate_three()); //23

//            for(CourseSelected ele:courseSelectedList){
//                System.out.println(ele.getContent());
//            }
        } finally {
            session.close();
        }
    }
}