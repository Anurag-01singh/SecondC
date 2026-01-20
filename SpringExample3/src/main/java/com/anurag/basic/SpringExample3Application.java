package com.anurag.basic;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.anurag.basic.model.Employee;
import com.anurag.basic.service.EmployeeService;



@SpringBootApplication
public class SpringExample3Application 
{
	@Bean
	public DataSource dataSource()
	{
		DriverManagerDataSource dmds = new DriverManagerDataSource();
		dmds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dmds.setUrl("jdbc:mysql://@localhost:3306/atm");
		dmds.setUsername("root");
		dmds.setPassword("rootsingh");
		return dmds;
	}
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource ds)
	{
		JdbcTemplate js = new JdbcTemplate(ds);
		return js;
		
		//return new JdbcTemplate(ds);
		
	}

	public static void main(String[] args) 
	{
		ApplicationContext ac =SpringApplication.run(SpringExample3Application.class, args);
		
		Employee employee = new Employee();
		employee.setEmpNo(333);
		employee.setEmpName("ashu");
		employee.setEmpSal(67763.6);
		
		EmployeeService employeeService = ac.getBean(EmployeeService.class);
		System.out.println(employeeService.addRecord(employee));
		
		
	}

}
