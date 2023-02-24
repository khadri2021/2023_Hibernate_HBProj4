package com.khadri.hibernate.main;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.khadri.hibernate.entity.Employee;

public class MainSaveOrUpdate {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure();

		SessionFactory sessionFactory = cfg.buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction txn = session.beginTransaction();

		System.out.println("Enter Employee Id:");
		Integer empId = sc.nextInt();
 
		Employee e1 = new Employee();
		e1.setEmpName("THORSTEN");
		e1.setEmpId(empId);
		e1.setSalary(200000.87);
		
		//session.lock(e1, LockMode.READ);
		
		session.saveOrUpdate(e1);
		
		
		
		session.flush();
		txn.commit();

	}
}
