package com.core.config;

import java.util.Properties;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.dialect.MySQL8Dialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.orm.hibernate5.SpringSessionContext;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@ComponentScan("com.web.*.model.*.impl")
@EnableTransactionManagement
public class AppConfig {

	@Bean
	public DataSource dataSource() throws IllegalArgumentException, NamingException {
		JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
		bean.setResourceRef(true);
		bean.setJndiName("jdbc/IPETDB");
		bean.afterPropertiesSet();
		return (DataSource) bean.getObject();
	}
	@Bean
	public SessionFactory sessionFactory() throws IllegalArgumentException, NamingException {
		return new LocalSessionFactoryBuilder(dataSource()).scanPackages("com.web.*.model.entity")
				.addProperties(getHibernateProperties()).buildSessionFactory();
	}

	@Bean
	public TransactionManager transactionManager() throws IllegalArgumentException, NamingException {
		return new HibernateTransactionManager(sessionFactory());
	}
	

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", MySQL8Dialect.class.getName());
		properties.setProperty("hibernate.show_sql", "false");
		properties.setProperty("hibernate.format_sql", "false");
		properties.setProperty("hibernate.current_session_context_class", SpringSessionContext.class.getName());
		return properties;
	}
}
