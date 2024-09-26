package com.example.farmerHome.apis;

import javax.transaction.Transactional;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.example.farmerHome.entities.Category;
import com.example.farmerHome.entities.Product;
import com.example.farmerHome.repositories.CategoryRepository;

@Component
@Scope("singleton")
@Path("/category/")
public class CategoryService {
	
	@Autowired 
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductService productService;
	
	
	public CategoryService() {
		System.out.println("Category service created");
	}
	
	
	@POST //HTTP method
	@Path("/register") 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional //helps to fetch dependent data
	public Category registerOrUpdateCategory(@BeanParam Category cat) {
		Category currentCat = findByCategoryId(cat.getCategoryId());
	
		if (currentCat != null) { //update
			currentCat.setCategory(cat.getCategory());
			cat = categoryRepository.save(currentCat);
			
		} else { //create
			cat = categoryRepository.save(cat);
		}
		System.out.println("Category assigned " + cat);
		return cat;
	}
	
	
	@GET
	@Path("/find/{categoryId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional 
	public Category findByCategoryId(@PathParam("categoryId") int categoryId) {
		try {
			return categoryRepository.findById(categoryId).get();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	@GET
	@Path("/allCategories")
	@Produces(MediaType.APPLICATION_JSON)
	public Iterable<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	
	@POST
	@Path("/assign/product") 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Product assignProduct(@FormParam("productId") int productId, 
								 @FormParam("categoryId") int categoryId) {
		try {
			Product prod = productService.findByProductId(productId);
			Category cat = findByCategoryId(categoryId);
			
			cat.getCategoryProds().add(prod);
			prod.setCurrentCategory(cat);
			prod = productService.registerOrUpdateProduct(prod);
			return prod;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	@DELETE
	@Path("/delete/{categoryId}")
	public void deleteByCategoryId(@PathParam("categoryId") int categoryId) {
		categoryRepository.deleteById(categoryId);
	}
}
