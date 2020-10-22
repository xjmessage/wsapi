package com.mkx.wsapi.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
public class AuthenticatorAdapter extends WebMvcConfigurerAdapter {
    @Autowired
    private Environment environment;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(new AuthenticatorInterceptor()).addPathPatterns("/**");
        //注册TestInterceptor拦截器
        InterceptorRegistration registration = registry.addInterceptor(new AuthenticatorInterceptor());
        //所有路径都被拦截
        registration.addPathPatterns("/**");
        //排除拦截地址
        String[] exclude_path = environment.getProperty("server.ignore_uri").split(",");
        //添加不拦截路径
        registration.excludePathPatterns(exclude_path);
        super.addInterceptors(registry);
    }
}
