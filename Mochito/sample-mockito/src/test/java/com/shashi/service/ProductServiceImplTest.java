package com.shashi.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.shashi.dao.ProductDAO;
import com.shashi.dao.ProductDetailDAO;
import com.shashi.entity.ProductEntity;
import com.shashi.test.ProductData;
import com.shashi.vo.ProductVO;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {
	@Mock
	private ProductDAO dao;

	@Mock
	private ProductDetailDAO detailDao;

	private final ProductServiceImpl impl = new ProductServiceImpl();

	private ProductVO input;
	private ProductEntity entity;

	@Before
	public void setUp() {
		input = ProductData.createProduct();
		entity = ProductData.createProductEntity();

		impl.setDao(dao);
		impl.setDetailDao(detailDao);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testSaveProductNullProduct() {
		impl.saveProduct(null);
		// fail("Not yet implemented");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSaveProductNullProductName() {
		final ProductVO input = ProductData.createProduct();
		input.setProductName(null);
		impl.saveProduct(null);
		// fail("Not yet implemented");
	}

	@Test
	public void testCreateProduct() throws SQLException {

		when(dao.createProduct(any(ProductEntity.class))).thenReturn(entity);

		final ProductVO result = impl.saveProduct(input);
		assertNotNull(result);
		assertNotNull(result.getId());
		assertEquals(input.getProductName(), result.getProductName());
		assertEquals(input.getDescription(), result.getDescription());

	}
}
