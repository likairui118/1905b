package com.fh.bean;

import com.fh.poi.PoiExcelAnnotation;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@PoiExcelAnnotation(title = "学生信息展示",sheetName = "学生信息",mkdir = "commons/excel")
public class StudentBean {
    @PoiExcelAnnotation("学生编号")
    private Integer id;
    @PoiExcelAnnotation("学生姓名")
    private String name;
    @PoiExcelAnnotation("生日")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    @PoiExcelAnnotation("年龄")
    private Integer age;
    @PoiExcelAnnotation("地址")
    private String address;
    @PoiExcelAnnotation("照片")
    private String imgPath;

    private Integer isDel;

    private String ip;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
