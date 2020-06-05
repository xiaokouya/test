package com.zhao.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName(value = "user")
public class User {
    @TableId(type = IdType.ID_WORKER)
    private Long id;
    private String username;
    private String password;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill=FieldFill.INSERT_UPDATE )
    private Date updateTime;
    @Version  //表示这个是一个乐观锁
    private Integer version;
    @TableLogic  //逻辑删除注解
    private Integer deleted;
    private Integer age;
}
