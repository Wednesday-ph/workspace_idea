package com.jiuyuan.config;

import com.jiuyuan.shiro.realms.CustomerRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.handler.DefaultWebFilterChain;

import java.util.HashMap;

/**
 * @author shkstart
 * @create 2021-07-22 14:50
 */
@Configuration
public class ShrioConfig {
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("/user/login","anon");
        map.put("/**","authc");

        shiroFilterFactoryBean.setLoginUrl("/login.jsp");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("getRealm") Realm realm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(realm);
        return defaultWebSecurityManager;
    }

    @Bean
    public Realm getRealm(){
        CustomerRealm customerRealm = new CustomerRealm();
        return customerRealm;
    }
}
