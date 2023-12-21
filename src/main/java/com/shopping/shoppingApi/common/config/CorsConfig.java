package com.shopping.shoppingApi.common.config;


import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableCaching
public class CorsConfig {
    /**
     * 创建一个CORS过滤器
     * @return CORS过滤器对象
     */
    @Bean
    public CorsFilter corsFilter() {
        // 创建一个基于URL的CORS配置源对象
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // 创建一个CORS配置对象
        final CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 允许使用凭证
        corsConfiguration.setAllowCredentials(true);
        // 允许的所有头
        corsConfiguration.addAllowedHeader("*");
        // 允许的所有源
        corsConfiguration.addAllowedOriginPattern("*");
        // 允许的所有方法
        corsConfiguration.addAllowedMethod("*");
        // 注册CORS配置
        source.registerCorsConfiguration("/**", corsConfiguration);
        // 返回CORS过滤器对象
        return new CorsFilter(source);
    }
}
