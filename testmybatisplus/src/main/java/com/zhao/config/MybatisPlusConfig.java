package com.zhao.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("com.zhao.mapper")
@Configuration
//这个是关于事物控制的，默认开启
@EnableTransactionManagement
public class MybatisPlusConfig {

    //    注册乐观锁插件
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

    //    这个是一个分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    //逻辑删除组件
    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }

    @Bean
//    只有在测试环境或者开发环境才开启
    @Profile({"dev", "test"})    //设置dev  test环境开启,保证开发效率
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor p = new PerformanceInterceptor();
//      单位是ms  如果执行时间超过了1000ms，就不执行
        p.setFormat(true); //执行格式化操作
        p.setMaxTime(1000);  //对控制台打印的sql语句
        // 进行格式化，只会使代码看着更方便

        return p;
    }
}
