package com.feiyu.data.ocean.controller.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.cors.CorsUtils;

/**
 * Created by xzhou.James on 2019/11/25
 * 配置 spring security
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)//控制权限注解
@Order(-1)
public class SecurityConfigucation extends WebSecurityConfigurerAdapter {

    protected SecurityConfigucation() {
        super();
    }
    protected  void configure(HttpSecurity httpSecurity)throws Exception{

        //开启跨域
        httpSecurity.cors().and().csrf().disable().authorizeRequests()//定义那些url需要被保护，那些不需要被保护
                //处理跨域请求
                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()//放行所有的请求方式
                .antMatchers(HttpMethod.POST,"/**").permitAll()
                .antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
                .antMatchers(HttpMethod.GET,"/**").permitAll()
                .anyRequest().authenticated();

        httpSecurity.csrf().disable();
    }
    public void configure(WebSecurity web) throws Exception{
        super.configure(web);
    }
}
