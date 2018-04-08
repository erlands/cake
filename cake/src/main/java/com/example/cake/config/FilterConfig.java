package com.example.cake.config;

import javax.servlet.Filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.cake.filter.LogFilter;
import com.example.cake.filter.SessionFilter;

@Configuration
public class FilterConfig {

	@Bean("sessionFilter")
	public Filter sessionFilter() {
		return new SessionFilter();
	}
	@Bean("logFilter")
	public Filter logFilter() {
		return new LogFilter();
	}

	@Bean("sessionFilterRegist")
	public FilterRegistrationBean<Filter> sessionFilterRegist() {
		FilterRegistrationBean<Filter> frBean = new FilterRegistrationBean<Filter>();
		frBean.setFilter(sessionFilter());
		frBean.addUrlPatterns("/admin/*");
		frBean.setOrder(2);
		return frBean;
	}
	
	@Bean("logFilterRegist")
	public FilterRegistrationBean<Filter> logFilterRegist(){
		FilterRegistrationBean<Filter> frBean = new FilterRegistrationBean<Filter>();
		frBean.setFilter(logFilter());
		frBean.addUrlPatterns("/*");
		frBean.setOrder(1);
		return frBean;
	}
}
