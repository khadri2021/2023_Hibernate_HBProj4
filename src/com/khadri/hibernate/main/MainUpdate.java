package com.khadri.hibernate.main;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.khadri.hibernate.entity.Employee;

public class MainUpdate {

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
		e1.setEmpName("JONE");
		e1.setEmpId(empId);
		e1.setSalary(100000.87);

		session.update(e1);
		 
		txn.commit();

	}
}
