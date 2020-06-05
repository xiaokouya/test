package com.zhao.pojo;

import cn.afterturn.easypoi.excel.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ExcelTarget(value="teacher")
public class Teacher {
    @ExcelIgnore
    private String id;
    @Excel(name="姓名", needMerge = true)
    private String name;
    @Excel(name="性别",replace = {"男_1","女_0"} , suffix = "生",needMerge = true)
    private String sex;
    @ExcelCollection(name = "学生信息")
    private List<Student> stus;
    @ExcelEntity(name = "她")
    private GirlFriend girlFriend;
    @Excel(name="相片",type = 2,width = 40,imageType = 1,needMerge = true)
    private String url;
}
