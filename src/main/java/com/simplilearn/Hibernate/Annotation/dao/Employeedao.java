package com.simplilearn.Hibernate.Annotation.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.simplilearn.Hibernate.Annotation.Persistanat.Employee;

public class Employeedao {
      
	public static void main(String[] args) {

		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory sf = meta.getSessionFactoryBuilder().build();

		Session session = sf.openSession();

		Transaction t = session.beginTransaction();

		Employee employee = new Employee();

		employee.setId(1);
		employee.setName("Shawn");
		employee.setAge(28);
		employee.setDepartment("IT");

		session.save(employee);

		t.commit();

		System.out.println("Successfully saved...");
		
		sf.close();
		session.close();

	}


}
