package com.annotation.hibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude=DataSourceAutoConfiguration.class)
//datasource vs sesssionfactory vs connection pooling --tomo
public class HibernateAnnotationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateAnnotationsApplication.class, args);
	}

}
