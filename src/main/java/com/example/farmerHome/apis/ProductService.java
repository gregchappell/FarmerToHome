package com.example.farmerHome.apis;

import java.util.List;
import javax.transaction.Transactional;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.example.farmerHome.entities.Product;
import com.example.farmerHome.repositories.ProductRepository;

@Component
@Scope("singleton") //creates one object per application - Default option
@Path("/product/") 
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	
	public ProductService() {
		System.out.println("Product service created");
	}
	
	
	@POST //HTTP method to send the form data
	@Path("/register") 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional //helps to fetch dependent data
	public Product registerOrUpdateProduct(@BeanParam Product prod) {
		Product currentProd = findByProductId(prod.getProductId());
		
		if (currentProd != null) { //update 
			currentProd.setProduct_name(prod.getProduct_name());
			currentProd.setExpiry_date(prod.getExpiry_date());
			currentProd.setPrice(prod.getPrice());
			prod = productRepository.save(currentProd);
		
		} else { //create
			prod = productRepository.save(prod);
		}
		System.out.println("Product registered " + prod);
		return prod;
	}
	
	@GET
	@Path("/find/{productId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional 
	public Product findByProductId(@PathParam("productId") int productId) {
		try {
			return productRepository.findById(productId).get();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	@GET
	@Path("/allProducts")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Iterable<Product> getAllProducts() {
		return productRepository.findAll();
	}
	

	@GET
	@Path("/fetchByPrice")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public List<Product> fetchProductsByPriceRange(
			@QueryParam("min") double min, 
			@QueryParam("max") double max) {
		return productRepository.findByPrice(min, max);
	}	
	
	
	@GET
	@Path("/fetchByCategory")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public List<Product> fetchProductsByCategory(
			@QueryParam("categoryId") int categoryId){
		return productRepository.findByCategory(categoryId);
	}
	
	
	@GET
	@Path("/fetchByExpiryDate")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public List<Product> fetchProductsByExpiryDate(
			@QueryParam("min") int min, 
			@QueryParam("max") int max) {
	
		List<Product> prods = productRepository.findByExpiryDate(min, max);

		//apply 50% discount to each product in the list
		for (Product product : prods) {
			double discountPrice = (double)Math.round((product.getPrice() * 0.5)*100d)/100d;
			product.setPrice(discountPrice);
		}
		return prods;
	}
	

	@DELETE
	@Path("/delete/{productId}")
	public void deleteByProductId(@PathParam("productId") int productId) {
		productRepository.deleteById(productId);
	}
}
