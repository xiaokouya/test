package com.zhao.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ExcelTarget(value = "student")
public class Student {
    @Excel(name="ID")
    private String id;
    @Excel(name="姓名")
    private String name;
    @Excel(name="年龄")
    private Integer age;
    @Excel(name="生日",format = "yyyy-MM-dd HH:mm:ss",width = 20)
    private Date bir;
}
