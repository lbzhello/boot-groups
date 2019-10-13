package xyz.lius.web.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import xyz.lius.web.filter.TestFilter;

import javax.servlet.Filter;

@Configuration
public class WebServletConfig {
    @Bean
    public FilterRegistrationBean corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        // 允许所有源的访问，非同源需要指定
        config.addAllowedOrigin("*");
        // 真实请求允许的方法
        config.addAllowedMethod("*");
        // 服务器允许使用的字段
        config.addAllowedHeader("*");
        // 否允许用户发送、处理 cookie
        config.setAllowCredentials(true);
        // 预检请求的有效期，单位为秒。有效期内，不会重复发送预检请求
        config.setMaxAge(60*60*60L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // CORS 配置对所有接口都有效
        source.registerCorsConfiguration("/**", config);

        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        // 优先级，越小优先级越大
        bean.setOrder(0);
        return bean;
    }

    @Bean
    public FilterRegistrationBean myFilter() {
        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new TestFilter());
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }

}
