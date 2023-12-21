package com.shopping.shoppingApi.common.config;

import com.shopping.shoppingApi.common.interceptor.AuthorizationInterceptor;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableCaching
public class WebMvcConfig implements WebMvcConfigurer {
    /**
     * 创建一个AuthorizationInterceptor的bean
     * @return 返回AuthorizationInterceptor的实例
     */
    @Bean
    public AuthorizationInterceptor getAuthorizationInterceptor() {
        return new AuthorizationInterceptor();
    }



    //    将需要登录拦截器配置到容器中，并配置不被拦截的路径
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getAuthorizationInterceptor()).addPathPatterns("/user/profile/**").addPathPatterns("/product/info/**").addPathPatterns("/cart/**").addPathPatterns("/collect/**").addPathPatterns("/address/**").addPathPatterns("/order/**").addPathPatterns("/business/**").addPathPatterns("/comment/**").addPathPatterns("/orderItem/**");
    }
}