package com.fh.service.impl;

import com.fh.bean.PageData;
import com.fh.bean.StudentBean;
import com.fh.dao.StuDao;
import com.fh.service.StuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StuServiceImpl implements StuService {
    @Resource
    private StuDao stuDao;

    @Override
    public PageData<StudentBean> queryStuList(PageData pageData) {

       long l= stuDao.queryCount();

       pageData.setRecordsFiltered(l);
       pageData.setRecordsTotal(l);

        List<StudentBean> studentBeans = stuDao.queryStuList(pageData);

        pageData.setData(studentBeans);

        return pageData;
    }

    @Override
    public void addStu(StudentBean studentBean) {
        stuDao.addStu(studentBean);

    }

    @Override
    public void delStu(Integer id) {
        stuDao.delStu(id);
    }

    @Override
    public StudentBean queryStuById(Integer id) {
        return stuDao.queryStuById(id);
    }

    @Override
    public void updateStu(StudentBean studentBean) {
        stuDao.updateStu(studentBean);
    }
}
