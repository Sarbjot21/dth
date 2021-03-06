package com.dth.main.controllers;

import java.util.Properties;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
@PropertySource(value = { "classpath:application.properties" })
@PropertySource(value = { "classpath:application-${spring.profiles.active}.properties" })
public class ComponentConfiguration {
	
	@Autowired
	Environment environment;
	
	private static final String URL = "spring.datasource.url";
	private static final String USER = "spring.datasource.username";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String PASS = "spring.datasource.password";
	
	@Bean 
	public LocalSessionFactoryBean sessionFactory() {
			LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
			System.out.println("SessionFactor +"+sessionFactory);
			System.out.println("DriverManagerDataSource"+dataSource());
			try {
			sessionFactory.setDataSource(dataSource());
		    sessionFactory.setPackagesToScan("com.dth.main.model");
			}catch(Exception e) {
				e.printStackTrace();
			}
	        Properties properties=new Properties();
	        //properties.setProperty("hibernate.hbm2ddl.auto",environment.getProperty("spring.jpa.hibernate.ddl-auto"));
	        properties.setProperty("hibernate.dialect",environment.getProperty("spring.jpa.properties.hibernate.dialect"));
	        properties.setProperty("hibernate.show_sql","true");
	    /*    properties.setProperty("hibernate.connection.url", environment.getProperty(""));
		*/       
	        System.out.println(properties);
	        sessionFactory.setHibernateProperties(properties);

	        return sessionFactory;
	}

	@Bean
	BasicDataSource dataSource() {
		BasicDataSource driverManagerDataSource = new BasicDataSource();
		driverManagerDataSource.setUrl(environment.getProperty(URL));
		System.out.println(environment.getProperty(URL));
		driverManagerDataSource.setUsername(environment.getProperty(USER));
		System.out.println(environment.getProperty(USER));
		driverManagerDataSource.setPassword(environment.getProperty(PASS));
		System.out.println(environment.getProperty(PASS).length());
		driverManagerDataSource.setDriverClassName(DRIVER);
		System.out.println(DRIVER);
		return driverManagerDataSource;
	}
	
	
	
	 	
	    @Bean
	    HibernateTransactionManager transactionManager() {
	        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
	        transactionManager.setSessionFactory(sessionFactory().getObject());

	        return transactionManager;
	    }
}

