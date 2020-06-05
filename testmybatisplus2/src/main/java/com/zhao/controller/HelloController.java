package com.zhao.controller;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        //        创建一个代码自动生成器对象
        AutoGenerator ag = new AutoGenerator();

        GlobalConfig gc = new GlobalConfig();
//        他的值是 -> D:\test\testmybatisplus2
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("me 赵");
        gc.setOpen(false);
//        是否覆盖之前生成的代码
        gc.setFileOverride(false);
//        去掉service之前的I
        gc.setServiceName("%sService");
//        设置id的生成策略
        gc.setIdType(IdType.ID_WORKER);
//        设置日期好像只是一个普通的类型-------------
        gc.setDateType(DateType.ONLY_DATE);
//        这个好像是关于前后端分离的
        gc.setSwagger2(true);

        ag.setGlobalConfig(gc);


//        设置数据源
        DataSourceConfig dataSource = new DataSourceConfig();
        dataSource.setUrl("jdbc:mysql://localhost:3306/test? useSSL=false&useUnicode=true&characterEncoding=utf-8");
        dataSource.setDriverName("com.mysql.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        dataSource.setDbType(DbType.MYSQL);

        ag.setDataSource(dataSource);

//设置包的位置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("blog");
        pc.setParent("com.kuang");
        pc.setEntity("pojo");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setController("controller");

        ag.setPackageInfo(pc);

//        设置策略

        StrategyConfig sc = new StrategyConfig();
//        设置要映射的表名,这里是一个集合，可以输入多个
        sc.setInclude("user","t_user","t_role","t_permission","t_user_role","t_role_permission");

        sc.setNaming(NamingStrategy.underline_to_camel);
        sc.setColumnNaming(NamingStrategy.underline_to_camel);
//        这个就是Pojo继承的类
//        sc.setSuperEntityClass("你自己的父类实体，没有就不用设置！");
        sc.setEntityLombokModel(true);
//        设置逻辑删除
        sc.setLogicDeleteFieldName("deleted");
//        设置自动填充
        TableFill gmtCreate = new TableFill("create_time", FieldFill.INSERT);
        TableFill gmtUpdate = new TableFill("update_time", FieldFill.INSERT_UPDATE);
        List<TableFill> list = new ArrayList<>();
        list.add(gmtCreate);
        list.add(gmtUpdate);
        sc.setTableFillList(list);

//        设置乐观锁
        sc.setVersionFieldName("version");
//        设置驼峰命名
        sc.setRestControllerStyle(true);
//        以这种形式的访问 localhost:8080/hello_id_2
        sc.setControllerMappingHyphenStyle(true);
        ag.setStrategy(sc);

//        执行
        ag.execute();

        return "ok";
    }

    @RequestMapping("/hello2")
    public String hello2(){
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        return projectPath;
    }
}
