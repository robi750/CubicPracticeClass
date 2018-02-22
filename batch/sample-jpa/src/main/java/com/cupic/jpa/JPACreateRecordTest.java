package com.cupic.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cubic.jpa.entity.CustomerEntity;

public class JPACreateRecordTest {

	public static void main(String[] args) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			emf = Persistence.createEntityManagerFactory("OracleUnit");
			em = emf.createEntityManager();
			System.out.println("Connection Exablishe....!!!");
			et = em.getTransaction();
			et.begin();

			CustomerEntity entity = createCustomerEntity();
			System.out.println("Before insert =" + entity);
			em.persist(entity);
			et.commit();
			System.out.println("After Insert =" + entity);

		} catch (Exception e) {
			e.printStackTrace();

			if (et != null)
				et.setRollbackOnly();

		} finally {
			if (em != null) {
				em.close();
			}

			if (emf != null) {
				emf.close();
			}
		}

	}

	private static CustomerEntity createCustomerEntity() {
		CustomerEntity entity = new CustomerEntity();
		entity.setFirstName("Daniel");
		entity.setLastName("Pyle");
		entity.setSsn("111-22-3333");
		return entity;
	}
}
