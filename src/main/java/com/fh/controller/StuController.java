package com.fh.controller;

import com.fh.bean.PageData;
import com.fh.bean.StudentBean;
import com.fh.dao.StuDao;
import com.fh.service.StuService;
import com.fh.utils.aliyunOss.FileUtilesalbb;
import com.fh.utils.excel.ExcelRefAnno;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@CrossOrigin
@RestController
public class StuController {
    private final static Logger log = LoggerFactory.getLogger(StuController.class);
    @Autowired
    private StuService stuService;
    @Resource
    private StuDao stuDao;
    //这是一个注释



    @RequestMapping("exportExcel")
    public void exportExcel(HttpServletResponse response) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {

        List<StudentBean> userList=stuDao.ExcelList();

        XSSFWorkbook wb =ExcelRefAnno.exportExcel(userList,StudentBean.class);

        response.setCharacterEncoding("utf-8");
        //设置响应数据类型
        response.setContentType("application/octet-stream");//设置响应类型 告诉浏览器输出内容为流
         //设置响应文件名
        response.setHeader("Content-disposition", "attachment;filename=" + UUID.randomUUID().toString() + ".xlsx");
        //获取响应流
        ServletOutputStream os = response.getOutputStream();
       //将workbook的内容 写入输出流中
        wb.write(os);

        os.close();
    }


    @RequestMapping("stuList")
    private PageData<StudentBean> StuList(PageData pageData){

       PageData<StudentBean> pageData1= stuService.queryStuList(pageData);

       log.info("这是一个查询方法");

        return pageData1;
    }


    @RequestMapping("addStu")
    private String addStu(StudentBean studentBean,HttpServletRequest request){

        String remoteAddr = request.getRemoteAddr();

        studentBean.setIp(remoteAddr);

        stuService.addStu(studentBean);

        return "ok";
    }

    @RequestMapping("delStu")
    private String delStu( Integer id){
        stuService.delStu(id);
        return "ok";
    }

    @RequestMapping("toUpdateStu")
    private StudentBean toUpdateStu(Integer id){
       StudentBean studentBean= stuService.queryStuById(id);

       return  studentBean;
    }

    @RequestMapping("updateStu")
    private String updateStu(StudentBean studentBean){
        stuService.updateStu(studentBean);

        return "ok";
    }

    @RequestMapping("uploadFile")
    public Map<String, Object> uploadFile(MultipartFile file){
        Map map=new HashMap<>();
        try {
            String path = FileUtilesalbb.saveFile(file.getInputStream(),file.getOriginalFilename());
            map.put("code", "200");
            map.put("url",path);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", "201");
            map.put("remark", e.getMessage());

        }
        return map;
    }
}
