package com.zhao.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;


@Slf4j
@Component //一定记着把这个对象添加到ioc容器中去
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
   log.info("start insert fill.......");
   this.setFieldValByName("createTime",new Date(),metaObject);
   this.setFieldValByName("updateTime",new Date(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill,,,,,,,");
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }
}
