package com.cupic.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cubic.jpa.entity.CustomerEntity;
import com.cubic.jpa.entity.OrderEntity;

public class JPAOneToManyTest {

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

			final CustomerEntity customerEntity = createCustomerEntity();

			for (int i = 0; i < 5; i++) {
				OrderEntity ord = createOrderEntity("ORD-" + i);
				ord.setCustomer(customerEntity);
				customerEntity.getOrders().add(ord);
			}
			em.persist(customerEntity);
			et.commit();
			System.out.println("After Insert=" + customerEntity);

			// entity.setCustomerDetail(detailEntity);
			// detailEntity.setCustomer(entity);
			//
			// System.out.println("Before insert =" + entity);
			// em.persist(entity);
			// et.commit();
			// System.out.println("After Insert =" + entity);

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

	private static CustomerEntity createCustomerEntity() {
		final CustomerEntity entity = new CustomerEntity();
		entity.setFirstName("Sam");
		entity.setLastName("Tyle");
		entity.setSsn("111-22-3333");
		return entity;
	}

	private static OrderEntity createOrderEntity(final String orderNumber) {
		final OrderEntity entity = new OrderEntity();
		entity.setOrderNumber(orderNumber);
		return entity;
	}
}
