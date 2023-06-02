package com.retoBackendend.equipo2.config;

import com.retoBackendend.equipo2.filters.JwtFilter;
import com.retoBackendend.equipo2.utils.JwtUtil;
import jakarta.servlet.DispatcherType;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Base64;
import java.util.EnumSet;
import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new GsonHttpMessageConverter());
        // Agrega otros convertidores de medios si es necesario
    }

    @Bean
    public FilterRegistrationBean<JwtFilter> jwtFilter() {
        FilterRegistrationBean<JwtFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new JwtFilter(Base64.getEncoder().encodeToString(JwtUtil.SECRET_KEY.getEncoded())));
        filterRegistrationBean.addUrlPatterns("/*"); // Rutas protegidas por el filtro
        filterRegistrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE); // Asegura que el filtro se aplique antes que otros filtros
        filterRegistrationBean.setDispatcherTypes(EnumSet.allOf(DispatcherType.class));
        filterRegistrationBean.addInitParameter("exclusions", "/authorizations/login");
        return filterRegistrationBean;
    }
}
