package cn.young.manager.service.Impl;

import cn.young.manager.pojo.School;
import cn.young.manager.service.SchoolService;
import cn.young.mapper.SchoolMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolMapper schoolMapper;


    @Override
    public School getSchoolById(Long sid) {
        return schoolMapper.selectByPrimaryKey(sid);
    }


}
