package com.khadri.hibernate.main;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.khadri.hibernate.entity.Employee;

public class MainDelete {

	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure();

		SessionFactory sessionFactory = cfg.buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction txn = session.beginTransaction();

		System.out.println("Please  enter emp id for update: ");
		Integer empId = scanner.nextInt();

		Employee e1 = new Employee();
		e1.setEmpId(empId);
		e1.setEmpName("RAJ");
		e1.setSalary(100000.87);

		session.update(e1);

		session.flush();

		session.delete(e1);

		txn.commit();

	}
}
