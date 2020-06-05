package com.zhao.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.word.WordExportUtil;
import com.zhao.pojo.GirlFriend;
import com.zhao.pojo.Student;
import com.zhao.pojo.Teacher;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;


@Controller
@RequestMapping("/excel")
public class ExcelController {

    @ResponseBody
    @RequestMapping("/test")
    public String testEasyPoiOutput(){
        List<Student> ss = new ArrayList<>();
        ss.add(new Student("1","小张",18,new Date()));
        ss.add(new Student("2","小凯",17,new Date()));
        ss.add(new Student("3","小孙",21,new Date()));
        ss.add(new Student("4","小明",25,new Date()));
        ss.add(new Student("5","小飞",27,new Date()));

        GirlFriend girl = new GirlFriend("1","小张");
        GirlFriend girl2 = new GirlFriend("2","小飞");

        List<Teacher> ts = new ArrayList<>();
        ts.add(new Teacher("1","赵老师","1",ss,girl,"C:/Users/EDZ/Desktop/a1.jpg"));
        ts.add(new Teacher("2","寇老师","0",ss,girl2,"C:/Users/EDZ/Desktop/a2.jpg"));

//      title 标题  secondTitle 子标题  sheetName 工作表名称
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("班级学生信息","请留心",  "班级学生表"), Teacher.class, ts);
        try {
            workbook.write(new FileOutputStream(new File("C:/Users/EDZ/Desktop/EasyPoi2.xls")));
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/test2")
    public String testEasyPoiInput(){
//       表由标题，表头，表体三部分组成
        ImportParams params = new ImportParams();
//        设置标题的行数，默认是0
        params.setTitleRows(2);
//        表头的行数，默认是1
        params.setHeadRows(2);

        try {
            List<Teacher> ts = ExcelImportUtil.importExcel(new FileInputStream(new File("C:/Users/EDZ/Desktop/EasyPoi.xls")), Teacher.class, params);
            for (Teacher t : ts) {
                System.out.println(t.getId());
                System.out.println(t.getName());
                List<Student> stus = t.getStus();
                for (Student student : stus) {
                    System.out.println(student);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/test3")
    public String testWord(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Map<String,Object> map = new HashMap<>();
        map.put("department","easypoi");
        map.put("person","JueYue");
        map.put("time",format.format(new Date()));
        map.put("me","zhao");
        map.put("time","2017-05-22");
        try {
            XWPFDocument doc = WordExportUtil.exportWord07("C:/Users/EDZ/Desktop/EasyPoi.docx", map);
            FileOutputStream fos = new FileOutputStream("D:/a.docx");
            doc.write(fos);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok";
    }
}
