package com.anurag.basic.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.anurag.basic.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao 
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public String addRecord(Employee employee) 
	{
		String sql = "insert into employee values(?,?,?)";
		Object arr[] = {employee.getEmpNo(),employee.getEmpName(),employee.getEmpSal()};
		
		return jdbcTemplate.update(sql, arr) + "Added Record.....";
	}

}
