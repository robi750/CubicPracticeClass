package com.cupic.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.cubic.jpa.entity.CustomerEntity;
import com.cubic.jpa.entity.QueryConstant;

public class JPANamedQueryTest {

	public static void main(String[] args) {

		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("OracleUnit");
			em = emf.createEntityManager();
			System.out.println("Connection Exablishe....!!!");

			final TypedQuery<CustomerEntity> query = em.createNamedQuery(QueryConstant.CUSTOMER_SEARCH,
					CustomerEntity.class);
			query.setParameter("fName", "%");
			query.setParameter("lName", "%");

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

}
