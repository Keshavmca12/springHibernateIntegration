package com.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dto.Employee;
@Repository
public class EmpDao {
	private SessionFactory sessionFactory;
	@Autowired
	public EmpDao(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public void saveEmployee(Employee emp){
		System.out.println("saving employee data");
		sessionFactory.getCurrentSession().save(emp);
	}
}
