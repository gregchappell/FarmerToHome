package com.example.farmerHome;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.farmerHome.apis.ProductService;
import com.example.farmerHome.entities.Product;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductApplicationTest {
	
	@Autowired
	ProductService productService;
	
	
	@Test
	public void exampleProductTest() {
		System.out.println("Product test case scenarios");
	}

//	// CRUD - Add
//	@Test
//	public void addProductUsingService() {
//		Product prod = new Product();
//		prod.setProduct_name("Rice");
//		prod.setPrice(4.5);
//		prod.setExpiry_date(5);
//		prod = productService.registerOrUpdateProduct(prod);
//		assertNotNull(prod);
//	}
//
//	// CRUD - find product by Id
//	@Test
//	public void findByProductIdUsingService() {
//		int productId = 8;
//		assertNotNull(productService.findByProductId(productId));
//	}
//
//	// CRUD - get all products
//	@Test
//	public void getAllProductsUsingService() {
//		assertNotNull(productService.getAllProducts());
//	}
//
//	// CRUD - Delete
//	@Test
//	public void deleteByProductIdUsingService() {
//		int productId = 8;
//		productService.deleteByProductId(productId);
//		assertNull(productService.findByProductId(productId));
//	}
//	
//	// MYSQL Queries - Fetch by price range
//	@Test
//	public void fetchByPriceUsingService() {
//		List<Product> prods = productService.fetchProductsByPriceRange(1, 2);
//		for (Product product : prods) {
//			System.out.println(product);
//		}
//		assertEquals(prods.size(),2);
//	}
//	
//	// MYSQL Queries - Fetch by expiry date
//	@Test
//	public void fetchByExpiryDateUsingService() {
//		List<Product> prods = productService.fetchProductsByExpiryDate(2, 7);
//		for (Product product : prods) {
//			System.out.println(product);
//		}
//		assertEquals(prods.size(), 2);
//	}
//	
//	// MYSQL Queries - Fetch by category
//	@Test
//	public void fetchByCategoryUsingService() {
//		List<Product> prods = productService.fetchProductsByCategory(1);
//		for (Product product : prods) {
//			System.out.println(product);
//		}	
//		assertEquals(prods.size(), 2);
//	}	
}
