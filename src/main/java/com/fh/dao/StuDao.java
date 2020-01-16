package com.fh.dao;

import com.fh.bean.PageData;
import com.fh.bean.StudentBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StuDao {
    //哈哈哈哈哈哈哈哈哈哈

    List<StudentBean> queryStuList(@Param("page") PageData pageData);

    long queryCount();

    void addStu(StudentBean studentBean);

    void delStu(Integer id);

    StudentBean queryStuById(Integer id);

    void updateStu(StudentBean studentBean);

    List<StudentBean> ExcelList();
}
