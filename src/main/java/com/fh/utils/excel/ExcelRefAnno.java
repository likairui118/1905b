package com.fh.utils.excel;




import com.fh.poi.PoiExcelAnnotation;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shangfeng
 * @Title: ExcelRefAnno
 * @Package com.fh.excelutil
 * @Description: ${todo}
 * @date 2019/7/17  15:26
 */
public class ExcelRefAnno {


    /**
     * 根据注解获取要导出的字段和名称
     * @param bean
     * @param clazz
     */
    public static void getExportField(ExcelUtilBean bean,Class clazz) {
        List<String> fieldArr=new ArrayList<String>();
        List<String> columnArr=new ArrayList<String>();
        Field[] fields=clazz.getDeclaredFields();
        for (Field field : fields) {
            PoiExcelAnnotation annotation = field.getAnnotation(PoiExcelAnnotation.class);
            if(annotation != null){
                fieldArr.add(field.getName());
                columnArr.add(annotation.value());

            }
        }
        bean.setColumns( columnArr.toArray(new String[columnArr.size()]));
        bean.setFields( fieldArr.toArray(new String[fieldArr.size()]));

    }

    /**1
     *导出Excel的公共调用方法
     * @param clazz
     * @return
     */
    public static XSSFWorkbook exportExcel(List<?> dataList, Class clazz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        ExcelUtilBean bean=new ExcelUtilBean();
        getExportField(bean,clazz);
        PoiExcelAnnotation annotation = (PoiExcelAnnotation) clazz.getAnnotation(PoiExcelAnnotation.class);
        bean.setTitle(annotation.title());
        bean.setSheetName(annotation.sheetName());
        bean.setMkdir(annotation.mkdir());
        bean.setData(dataList);
        return ExportExcelUtil.exportExcel(bean,clazz);
    }

}
