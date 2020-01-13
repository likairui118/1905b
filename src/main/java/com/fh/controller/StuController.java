package com.fh.controller;

import com.fh.bean.PageData;
import com.fh.bean.StudentBean;
import com.fh.service.StuService;
import com.fh.utils.aliyunOss.FileUtilesalbb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
public class StuController {

    @Autowired
    private StuService stuService;

    @RequestMapping("stuList")
    private PageData<StudentBean> StuList(PageData pageData){

       PageData<StudentBean> pageData1= stuService.queryStuList(pageData);

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
