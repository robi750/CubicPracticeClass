package com.cupic.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.cubic.jpa.entity.CustomerEntity;

public class JPATypedQueryTest {

	public static void main(String[] args) {

		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("OracleUnit");
			em = emf.createEntityManager();
			System.out.println("Connection Exablishe....!!!");

			String sqlQuery = " select c from CustomerEntity c";
			final TypedQuery<CustomerEntity> query = em.createQuery(sqlQuery, CustomerEntity.class);
			final List<CustomerEntity> resultList = query.getResultList();

			for (CustomerEntity entity : resultList) {
				System.out.println(entity);
			}

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

	/*
	 * private static CustomerEntity CustomerEntity() { CustomerEntity entity = new
	 * CustomerEntity(); entity.setFirstName("James"); entity.setLastName("Barr");
	 * entity.setSsn("111-22-3333"); return entity; }
	 */
	private static CustomerEntity CreateCustomerEntity() {
		CustomerEntity entity = new CustomerEntity();
		entity.setFirstName("Robin");
		entity.setLastName("shre");
		entity.setSsn("111-222-3333");
		return entity;
	}
}
