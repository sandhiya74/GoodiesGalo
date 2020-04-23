package com.niit.GoodiesGalo.Config;

import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "com.niit")
@EnableTransactionManagement
public class DbConfig {
	@Bean
	public BasicDataSource myDataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName("org.h2.Driver");
		basicDataSource.setUrl("jdbc:h2:tcp://localhost/~/goodiesgalo");
		basicDataSource.setUsername("sa");
		basicDataSource.setPassword("password");
		return basicDataSource;
	}

	Properties myDBProperties() {
		Properties properties = new Properties();
		properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.H2Dialect");
		properties.setProperty(Environment.HBM2DDL_AUTO, "update");
		properties.setProperty(Environment.SHOW_SQL, "true");
		return properties;
	}

	@Bean(name = "sessionfactory")
	SessionFactory mySessionFactory() {
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(myDataSource());
		localSessionFactoryBean.setHibernateProperties(myDBProperties());
		localSessionFactoryBean.setPackagesToScan("com.niit.GoodiesGalo.Model");

		return (SessionFactory) localSessionFactoryBean;
	}

	@Autowired
	@Bean
	HibernateTransactionManager enableTransanction(SessionFactory sessionfactory) {
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(sessionfactory);
		return hibernateTransactionManager;
	}

}
