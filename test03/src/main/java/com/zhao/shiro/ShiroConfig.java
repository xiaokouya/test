package com.zhao.shiro;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;


@Configuration
public class ShiroConfig {

    @Bean
    public MyRealm getMyRealm() {
        MyRealm myRealm = new MyRealm();
        System.out.println("===myRealm完成注册===");
        return myRealm;
    }

    @Bean
    public DefaultWebSecurityManager getSecurityManager(MyRealm getMyRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager(getMyRealm);
        System.out.println("===securityManager完成注册");
        return securityManager;
    }


//    要注意这个baen的名字必须是shiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager getSecurityManager) {
        ShiroFilterFactoryBean sf = new ShiroFilterFactoryBean();
        //设置 SecurityManager
        sf.setSecurityManager(getSecurityManager);
//      身份认证失败访问该路径
        sf.setLoginUrl("/login");
//       认证成功要跳转的路径
        sf.setSuccessUrl("/successs");
//       未授权 会访问的界面
        sf.setUnauthorizedUrl("/user/unauthorized");

//       这个map是有序的 进行顺序拦截器配置
        Map<String, String> filterChainMap = new LinkedHashMap<>();
//        配置可以匿名访问的地址，根据自己的情况添加，释放一些静态资源
        filterChainMap.put("static","anon");
        filterChainMap.put("/css/**", "anon");
        filterChainMap.put("/imgs/**", "anon");
        filterChainMap.put("/js/**", "anon");


//            登录URL 放行
        filterChainMap.put("/user/login", "anon");
        filterChainMap.put("/user/admin","authc");

//以/user/admin开头的需要进行权限认证， authc表示要进行权限认证
//        filterChainMap.put("/user/admin*", "authc");
//        以/user/student开头的需要进行角色认证，是admin的才放行
//        filterChainMap.put("/user/student*", "roles[admin]");
//以/user/teacher开头的需要进行权限认证，是user:create才放行
        filterChainMap.put("/user/teacher", "perms[\"teacher:*\"]");

//        配置logout过滤器
        filterChainMap.put("logout","logout");

        sf.setFilterChainDefinitionMap(filterChainMap);

        System.out.println("===shiroFilter注册完成===");
        return sf;
    }
}
