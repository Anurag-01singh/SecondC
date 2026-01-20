package com.anurag.basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anurag.basic.dao.EmployeeDao;
import com.anurag.basic.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService 
{
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public String addRecord(Employee employee) 
	{
		
		return employeeDao.addRecord(employee);
	}

}
