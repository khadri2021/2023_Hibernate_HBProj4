package com.khadri.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.khadri.hibernate.entity.Employee;

public class MainMerge {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure();

		SessionFactory sessionFactory = cfg.buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction txn = session.beginTransaction();

		Employee e1 = new Employee();
		e1.setEmpName("RAJ");
		e1.setSalary(100000.87);

		session.save(e1);
		session.flush();

		session.evict(e1);

		e1.setSalary(300000.87);
		session.merge(e1);

		txn.commit();

	}
}
