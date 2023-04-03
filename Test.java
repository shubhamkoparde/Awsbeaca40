package com.jsp.onetomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Test {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Mobile mobile = new Mobile();
		mobile.setBrand("iphone");
		mobile.setColor("black");
		mobile.setCost(95000.0);
		mobile.setRam("8gb");
		
		Mobile mobile1 = new Mobile();
		mobile1.setBrand("samsung");
		mobile1.setColor("blue");
		mobile1.setCost(45000.0);
		mobile1.setRam("4gb");
		
		Sim sim = new Sim();
		sim.setProvider("jio");
		sim.setType("4g");
		sim.setPhno(454848784l);
		sim.setCost(499);
		
		Sim sim1 = new Sim();
		sim1.setProvider("BSNL");
		sim1.setType("3g");
		sim1.setPhno(8887848784l);
		sim1.setCost(199);
		
		Sim sim2 = new Sim();
		sim2.setProvider("VI");
		sim2.setType("4g");
		sim2.setPhno(9858948784l);
		sim2.setCost(299);
		
		Sim sim3 = new Sim();
		sim3.setProvider("AIRTEL");
		sim3.setType("4g");
		sim3.setPhno(454848784l);
		sim3.setCost(399);
		
		List<Sim> list = new ArrayList<Sim>();
		list.add(sim);
		list.add(sim1);
		
		List<Sim> list1 = new ArrayList<Sim>();
		list1.add(sim2);
		list1.add(sim3);
		
		mobile.setSims(list);
		mobile1.setSims(list1);
		
		entityTransaction.begin();
		entityManager.persist(mobile);
		entityManager.persist(mobile1);
		entityManager.persist(sim);
		entityManager.persist(sim1);
		entityManager.persist(sim2);
		entityManager.persist(sim3);
		entityTransaction.commit();
		
	}

}
