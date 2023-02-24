package com.khadri.hibernate.main;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.khadri.hibernate.entity.Employee;

public class MainSavePersist {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure();

		SessionFactory sessionFactory = cfg.buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction txn = session.beginTransaction();

		System.out.println("Enter Employee Name:");
		String empName = sc.next();

		System.out.println("Enter Employee Salary:");
		Double empSalary = sc.nextDouble();

		Employee e1 = new Employee();
		e1.setEmpName(empName);
		e1.setSalary(empSalary);

		System.out.println("moving transient state to persistance state");
	    session.save(e1);
	    
	    System.out.println("moving   persistance state to detached state");
	    session.evict(e1);
	    
	    System.out.println("moving detached state to persistance state as new object");
	    session.save(e1);
		 
		txn.commit();

		// Note replace line number 44 with persist method will get PersistenceException
	}
}
