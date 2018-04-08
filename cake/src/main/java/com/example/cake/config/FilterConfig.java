package com.example.cake.config;

import javax.servlet.Filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.cake.filter.SessionFilter;

@Configuration
public class FilterConfig {

	@Bean("sessionFilter")
	public Filter sessionFilter() {
		return new SessionFilter();
	}

	@Bean
	public FilterRegistrationBean<Filter> filterRegist() {
		FilterRegistrationBean<Filter> frBean = new FilterRegistrationBean<Filter>();
		frBean.setFilter(sessionFilter());
		frBean.addUrlPatterns("/admin/*");
		return frBean;
	}
}
