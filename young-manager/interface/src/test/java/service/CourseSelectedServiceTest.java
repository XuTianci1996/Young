package service;

import cn.young.manager.pojo.CourseSelected;
import cn.young.manager.service.CourseSelectedService;
import org.junit.Test;

public class CourseSelectedServiceTest {


    CourseSelectedService courseSelected;

    @Test
    public void Testre(){
        CourseSelected[] info = courseSelected.getInfo();
        System.out.println(info.length);
    }

}