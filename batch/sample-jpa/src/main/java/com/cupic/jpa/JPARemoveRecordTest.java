package com.cupic.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cubic.jpa.entity.CustomerEntity;

public class JPARemoveRecordTest {

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

			final CustomerEntity entity = em.find(CustomerEntity.class, new Long(1001));
			System.out.println("Before update =" + entity);

			// entity.setFirstName("Daniel");
			em.remove(entity);
			et.commit();
			// System.out.println("After Update =" + entity);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}

			if (emf != null) {
				emf.close();
			}
		}

	}

	// private static CustomerEntity createCustomerEntity() {
	// CustomerEntity entity = new CustomerEntity();
	// entity.setFirstName("James");
	// entity.setLastName("Barr");
	// entity.setSsn("111-22-3333");
	// return entity;
	// }
}
