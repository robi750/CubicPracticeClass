package com.cupic.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.cubic.jpa.entity.CustomerEntity;
import com.cubic.jpa.entity.QueryConstant;

public class JPANamedNativeQueryTest {

	public static void main(String[] args) {

		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("OracleUnit");
			em = emf.createEntityManager();
			System.out.println("Connection Exablishe....!!!");

			final TypedQuery<CustomerEntity> query = em.createNamedQuery(QueryConstant.N_CUSTOMER_SELECT_ALL,
					CustomerEntity.class);
			final List<CustomerEntity> resultList = query.getResultList();

			for (CustomerEntity entity : resultList) {
				System.out.println(entity);
			}
			/*
			 * final TypedQuery<Object[]> query = (TypedQuery<Object[]>) em
			 * .createNamedQuery(QueryConstanst.N_CUSTOMER_SEARCH);
			 * 
			 * query.setParameter(1, "j%"); query.setParameter(2, "p%"); final
			 * List<Object[]> resultList = query.getResultList();
			 * 
			 * for (Object[] row : resultList) { final BigDecimal id = (BigDecimal) row[0];
			 * final String firstName = (String) row[1]; System.out.println(id.intValue() +
			 * "==" + firstName);
			 * 
			 * }
			 * 
			 * /* final TypedQuery<CustomerEntity> query =
			 * em.createNamedQuery(QueryConstanst.CUSTOMER_SEARCH, CustomerEntity.class);
			 * query.setParameter("fName", "d%"); query.setParameter("lName", "p%");
			 * 
			 * final List<CustomerEntity> resultList = query.getResultList();
			 * 
			 * for (CustomerEntity entity : resultList) { System.out.println(entity); }
			 */
		} catch (

		Exception e) {
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
