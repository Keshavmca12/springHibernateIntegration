package com.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.dao.EmpDao;
import com.dto.Employee;

@Controller

public class EmployeeController {
	@Autowired
	EmpDao empDao;
	@RequestMapping(value = "/employeeForm", method = RequestMethod.GET)
	public String smartTable() {
		System.out.println("serving employeeForm page");
		return "employeeForm";
	}
	@RequestMapping(value = "/submitEmp", method = RequestMethod.POST)
	public   @ResponseBody String  submitEmployeeDetails(@RequestParam("employee") String employee) {
		System.out.println("submitEmployeeDetails   employee :"+employee);
		ObjectMapper obj=new ObjectMapper();
		Employee emp=null;
		try {
			emp = obj.readValue(employee, Employee.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("employee name"+emp.getName());
		empDao.saveEmployee(emp);
		return "success";
	}
	
}
