package com.fh.service;

import com.fh.bean.PageData;
import com.fh.bean.StudentBean;

public interface StuService {
    PageData<StudentBean> queryStuList(PageData pageData);

    void addStu(StudentBean studentBean);

    void delStu(Integer id);

    StudentBean queryStuById(Integer id);

    void updateStu(StudentBean studentBean);
}
