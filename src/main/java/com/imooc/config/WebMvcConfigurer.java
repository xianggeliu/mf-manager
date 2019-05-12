package com.imooc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.imooc.controller.interceptor.MFInterceptor;

@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		/**
		 * 拦截器按照顺序执行
		 */
//		registry.addInterceptor(new TwoInterceptor()).addPathPatterns("/two/**")
//													 .addPathPatterns("/one/**");
		InterceptorRegistration interceptorRegistration = registry.addInterceptor(new MFInterceptor());
		interceptorRegistration.addPathPatterns("/**");
		interceptorRegistration.excludePathPatterns("/login/**","/static/**","/js/**","/html/**","/image/**","/css/**");
		super.addInterceptors(registry);
	}

}
