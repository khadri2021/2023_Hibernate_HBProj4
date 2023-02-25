package com.khadri.hibernate.main;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.khadri.hibernate.entity.Employee;

public class MainLoadGet {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure();

		SessionFactory sessionFactory = cfg.buildSessionFactory();

		Session session = sessionFactory.openSession();

		System.out.println("Please enter emp id to select the record: ");
		int empId = sc.nextInt();

		Employee emp = session.get(Employee.class, empId);
		//System.out.println(emp);

		System.out.println("EMPLOYEE ID: "+emp.getEmpId());
		System.out.println("EMPLOYEE NAME: "+emp.getEmpName());
		System.out.println("EMPLOYEE SALARY: "+emp.getSalary());
		 

	}
}
