package com.unitmb.api;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.alibaba.druid.pool.DruidDataSource;
/**
 * 
 * @author Sun yan
 * 
 * web 工程初始化
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.unitmb.api")
@EnableTransactionManagement
@PropertySource(value = "classpath:/datasource.properties")
public class WebApp implements WebApplicationInitializer, WebMvcConfigurer  {
	
	@Value("${datasource.url}")
	private String url;
	
	@Value("${datasource.username}")
	private String username;
	
	@Value("${datasource.password}")
	private String password;

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		// Load Spring web application configuration
		AnnotationConfigWebApplicationContext applicationcontext = new AnnotationConfigWebApplicationContext();
		applicationcontext.register(WebApp.class);
		
		// Create and register the DispatcherServlet
        DispatcherServlet servlet = new DispatcherServlet(applicationcontext);
        ServletRegistration.Dynamic registration = servletContext.addServlet("UnitMBApi", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/*");
	}
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("/WEB-INF/");
    }
	
	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "/index.html");
    }
	
	
	@Bean
	public DataSource getDataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver"); 
		dataSource.setUrl(url); 
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(getDataSource(), true);
	}
	
	@Bean
	public DataSourceTransactionManager getDataSourceTransactionManager() {
		return new DataSourceTransactionManager(getDataSource());
	}

}
