package com.example.farmerHome;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.farmerHome.apis.CategoryService;
import com.example.farmerHome.entities.Category;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryApplicationTest {
	
	@Autowired
	CategoryService categoryService;
	
	
	@Test
	public void exampleCategoryTest() {
		System.out.println("Category test case scenarios");
	}
	
//	//CRUD - Add category
//	@Test
//	public void addCategoryUsingService() {
//		Category cat = new Category();
//		cat.setCategory("Fruit_Vegetables");
//		cat = categoryService.registerOrUpdateCategory(cat);	
//		assertNotNull(cat);
//	}
//	
//	//CRUD - Find by category id
//	@Test
//	public void findCategoryUsingService() {
//		int categoryId = 54 ;
//		assertNotNull(categoryService.findByCategoryId(categoryId));
//	}
//	
//	//CRUD - Get all categories
//	@Test
//	public void getAllCategoriesUsingService() {
//		assertNotNull(categoryService.getAllCategories());
//	}
//	
//	//CRUD - Delete by category id
//	@Test
//	public void deleteByCategoryIdUsingService() {
//		int categoryId = 55;
//		categoryService.deleteByCategoryId(categoryId);
//		assertNull(categoryService.findByCategoryId(categoryId));
//	}
}
