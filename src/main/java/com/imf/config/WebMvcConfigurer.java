package com.imf.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import com.imf.controller.interceptor.MFInterceptor;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
 class WebMvcConfigurerimplements implements WebMvcConfigurer {

	@Autowired
	private MFInterceptor mfInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		InterceptorRegistration addInterceptor = registry.addInterceptor(mfInterceptor);
		// 排除配置
		addInterceptor.excludePathPatterns("/error");
		addInterceptor.excludePathPatterns("/static/**");//排除静态资源
		addInterceptor.excludePathPatterns("/login/**");
		addInterceptor.excludePathPatterns("/login/check");
		// 拦截配置
		addInterceptor.addPathPatterns("/**");
	}
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");//
	}

}
