package cn.young.manager.web.controller;


import cn.young.common.pojo.EasyUIDataGrid;
import cn.young.common.pojo.YoungResult;
import cn.young.manager.pojo.Course;
import cn.young.manager.service.CourseSelectedService;
import cn.young.manager.service.CourseService;
import cn.young.manager.service.EvaluationService;
import cn.young.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * 管理员页面Controller
 */
@Controller
public class AdminController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private UserService userService;

    @Autowired
    private EvaluationService evaluationService;

    @Autowired
    private CourseSelectedService courseSelectedService;
    /**
     * 管理员页面入口
     * @return
     */
    @RequestMapping("/")
    public String getIndex(){
        return "index";
    }


    /**
     * 管理员右面页面显示
     * @param page
     * @return
     */
    @RequestMapping("{page}")
    public String getPage(@PathVariable String page){
        return page;
    }

    /**
     * 根据id选择课程
     * @param id
     * @return
     */
    @RequestMapping("course/{id}")
    @ResponseBody
    public Course getCourseByid(@PathVariable long id){
        Course courseinfo = courseService.getCourseinfoById(id);
        return courseinfo;
    }

    /**
     * 根据课程的选择人数，在后台显示所有的课程信息，由高到低
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/course/list")
    @ResponseBody
    public EasyUIDataGrid getAllCourse(int page,int rows){
        EasyUIDataGrid result = courseService.getUserList(page, rows);
        return result;
    }

    /**
     *使得在查询用户里面呈现分页过后的数据表格
     */
    @RequestMapping("/user/list")
    @ResponseBody
    public EasyUIDataGrid getItemList(Integer page, Integer rows){
        EasyUIDataGrid result = userService.getUserList(page,rows);
        return result;
    }

    //删除用户
    @RequestMapping("/rest/user/delete")
    @ResponseBody
    public YoungResult deleteUser(@RequestParam(value="ids")long uid){
        YoungResult youngResult = userService.deleteUser( uid);
        System.out.println(youngResult.getStatus());
        return  youngResult;
    }

    @RequestMapping("/evaluation/list")
    @ResponseBody
    public EasyUIDataGrid getEvaluationList(Integer page, Integer rows){
        EasyUIDataGrid result = evaluationService.getEvaluation(page,rows);
        return result;
    }

    @RequestMapping("/courseselected/list")
    @ResponseBody
    public EasyUIDataGrid getcourseselectedList(Integer page, Integer rows){
        EasyUIDataGrid result = courseSelectedService.getCourseSelectedList(page,rows);
        return result;
    }
}
