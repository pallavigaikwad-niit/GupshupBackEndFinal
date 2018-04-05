package com.niit.controller;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.dao.BlogDao;
import com.niit.dao.ForumDao;
import com.niit.daoimpl.BlogDaoImpl;
import com.niit.daoimpl.ForumDaoImpl;
import com.niit.model.Blog;

@Configuration
@ComponentScan("com.niit")
@EnableTransactionManagement
public class DBConfig {

	@Bean(name="dataSource")
	public DataSource getDataSource() {
		System.out.println("in get Data Source");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		dataSource.setUsername("pallavi");
		dataSource.setPassword("data");
		System.out.println("done with get Data Source");
		return dataSource;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory() {
		System.out.println("in session factory");
		Properties hibernateProp = new Properties();
		hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
		hibernateProp.put("hibernate.hbm2ddl.auto", "update");
		LocalSessionFactoryBuilder sessionFactoryBuilder = new LocalSessionFactoryBuilder(getDataSource());
		sessionFactoryBuilder.addProperties(hibernateProp);
		
		sessionFactoryBuilder.addAnnotatedClass(Blog.class);
		SessionFactory sessionFactory = sessionFactoryBuilder.buildSessionFactory();
		System.out.println("done with session factory");

		return sessionFactory;

	}

	@Bean(name = "blogDao")
	public BlogDao getBlogDaoImpl() {
		return new BlogDaoImpl();
	}

	@Bean(name = "forumDao")
	public ForumDao getForumDao() {
		return new ForumDaoImpl();
	}
	
	@Autowired
	@Bean("transactionManager")
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory) {
		System.out.println("In TransactionManager");
		return new HibernateTransactionManager(sessionFactory);
	}
}
