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
import com.example.farmerHome.entities.ProductCategories;
import com.example.farmerHome.entities.ProductSizes;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductsApplicationTest {
	
	@Autowired
	ProductService productService;
	
	@Test
	public void exampleProjectTest() {
		System.out.println("Products test case scenarios");
	}

	// CRUD OPERATIONS - Add
//	@Test
//	public void addProductUsingService() {
//		Product prod = new Product();
//		prod.setName("Rice");
//		prod.setCategory(ProductCategories.BAKERY_DAIRY);
//		prod.setPrice(1.20);
//		prod.setQuantity(1);
//		prod.setExpiry_date(5);
//		prod.setSize(ProductSizes.MEDIUM);
//		
//		prod = productService.registerOrUpdateProduct(prod);
//		
//		assertNotNull(prod);
//	}

	// CRUD OPERATIONS - find product by Id
	@Test
	public void findByProductIdUsingService() {
		int productId = 1;
		assertNotNull(productService.findByProductId(productId));
	}

	// CRUD OPERATIONS - get all products
	@Test
	public void getAllProductsUsingService() {
		assertNotNull(productService.getAllProducts());
	}

	// CRUD OPERATIONS - Delete
//	@Test
//	public void deleteByProductIdUsingService() {
//		int productId = 8;
//		productService.deleteByProductId(productId);
//		assertNull(productService.findByProductId(productId));
//		
//	}
	
	// SELECT/FILTER QUERIES FOR MYSQL - fetch by price range
	@Test
	public void fetchByPriceUsingService() {
		List<Product> prods = productService.fetchProductsByPriceRange(1, 2);
		for (Product product : prods) {
			System.out.println(product);
		}
		assertEquals(prods.size(),2);
	}
	
	
	// SELECT/FILTER QUERIES FOR MYSQL - fetch by expiry date interval
	@Test
	public void fetchByExpiryDateUsingService() {
		List<Product> prods = productService.fetchProductsByExpiryDate(2, 7);
		for (Product product : prods) {
			System.out.println(product);
		}
		assertEquals(prods.size(), 2);
	}
	
	// SELECT/FILTER QUERIES FOR MYSQL - fetch by category
	@Test
	public void fetchByCategoryUsingService() {
		List<Product> prods = productService.fetchProductsByCategory(ProductCategories.BAKERY_DAIRY);
		for (Product product : prods) {
			System.out.println(product);
		}	
		assertEquals(prods.size(), 2);
	}
	

	
}
