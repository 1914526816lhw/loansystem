package com.stu.config;

import com.stu.config.interceptors.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ClassName：Webconfigurer
 * Description：
 *
 * @author lihw
 * CreateTime: 2020/1/15 11:58
 * @version 1.0.0
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    //将 LoginInterceptor 注册到 WebConfigurer 中
    @Autowired
    private LoginInterceptor loginInterceptor;


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
    }

    //这个方法是用来配置静态资源的，比如js、css 等等
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    }

    //这个方法用来注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //addPathPatterns 用来设置拦截路径，excludePathPatterns 用来设置白名单，也就是不需要触发这个拦截器的路径
        // addPathPatterns("/**") 表示拦截所有的请求
        // excludePathPatterns("/login", "/register") 表示除了登陆与注册之外，因为登陆注册不需要登陆也可以访问
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**");
    }
}
