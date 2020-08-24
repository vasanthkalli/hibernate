package com.annotation.hibernate.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.annotation.hibernate.mapping.beans.Address;
import com.annotation.hibernate.mapping.beans.Marks;
import com.annotation.hibernate.mapping.beans.Student;


@Configuration
public class HibernateConfig {

	/**
	 * 1.define configuration
	 * 2.get seesionfactory from configuration(sessionfactory is thread safe and immutable)
	 * 3.get session from sessionFactory (session is not threadsafe)
	 * 4.get transaction from session
	 * 5.get query from session
	 */
	
@Bean
public SessionFactory getHibernateConfig() {
	/**
	 * SeesionFactory is immutable.The internal state of the sesssionfactory will not change
	 * Generally there will be only one sessionfactory per application and 
	 * 
        The main contract here is the creation of Session instances. Usuallyan application has a single SessionFactory instance and threadsservicing client requests obtain Session instances from this factory. 
        The internal state of a SessionFactory is immutable. Once it is createdthis internal state is set. This internal state includes all of the metadataabout Object/Relational Mapping. 
        Implementors must be threadsafe.
        net.sf.hibernate.Configuration class --> requests for --> net.sf.hibernate.SessionFactory interface --> which inturn builds a SessionFactory using --> net.sf.hibernate.impl.SessionFactoryImpl clas
	    Need to know about factory pattern**
	 */
	org.hibernate.cfg.Configuration configurstion=new org.hibernate.cfg.Configuration();
	Properties properties=new Properties();
	properties.put("hibernate.connection.url", "jdbc:mysql://db4free.net:3306/vasanthtesting");
	properties.put("hibernate.connection.username", "vasanthkalli");
	properties.put("hibernate.connection.password","Vasanth@12345");
	properties.put("hibernate.connection.driver_class","com.mysql.cj.jdbc.Driver");
	properties.put("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");//Dialect version also important based on sqlconnector version
	properties.put("hibernate.hbm2ddl.auto", "update");
	properties.put("show-sql", true);
	configurstion.addAnnotatedClass(Student.class);//Required
	configurstion.addAnnotatedClass(Address.class);
	configurstion.addAnnotatedClass(Marks.class);
	return configurstion.setProperties(properties).buildSessionFactory();	
}

}

