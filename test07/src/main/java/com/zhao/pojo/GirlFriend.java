package com.zhao.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ExcelTarget(value="她")
public class GirlFriend {
    @Excel(name = "她id",needMerge = true)
    private String id;
    @Excel(name="她名字",needMerge = true)
    private String name;
}
