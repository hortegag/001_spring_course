package com.home.springsecurity.demo;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.home.springsecurity.demo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {
	
	// variable to hold the properties
	
	@Autowired
	private Environment env;
	
	
	// confgurelogger
	private Logger logger = Logger.getLogger(getClass().getName());
	
	
	
	// define a bean for ViewResolver
	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		
		
		
		
		return viewResolver;
		
		
		
	}
	
	// bean for security datasource
	
	@Bean
	public DataSource dataSource(){
		
		// create connection pool
		ComboPooledDataSource securityDatasource
		= new ComboPooledDataSource();
		
		// set jdbc driver
		try {
			securityDatasource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}
		
		
		// log connection properties
		logger.info(">>>>> jdbc.url="+env.getProperty("jdbc.url"));
		logger.info(">>>>> jdbc.user="+env.getProperty("jdbc.user"));

		
		// set database connection 
		securityDatasource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDatasource.setUser(env.getProperty("jdbc.user"));
		securityDatasource.setPassword(env.getProperty("jdbc.password"));
		
		// set pool properties
		securityDatasource.setInitialPoolSize(
				getIntProperty("connection.pool.initialPoolSize")
				);
		
		securityDatasource.setMinPoolSize(
				getIntProperty("connection.pool.minPoolSize")
				);
		securityDatasource.setMaxPoolSize(
				getIntProperty("connection.pool.maxPoolSize")
				);
		securityDatasource.setMaxIdleTime(
				getIntProperty("connection.pool.maxIdleTime")
				);
		
		
		
		return securityDatasource;
	}
	
	private int getIntProperty(String propertyName){
		String propertyValue = env.getProperty(propertyName);
		
		int propVal = Integer.parseInt(propertyValue);
		return propVal;
	}
	
	
	
	

}
