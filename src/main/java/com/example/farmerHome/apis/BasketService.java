package com.example.farmerHome.apis;

import java.util.Set;
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
import com.example.farmerHome.entities.Basket;
import com.example.farmerHome.entities.Product;
import com.example.farmerHome.repositories.BasketRepository;

@Component
@Scope("singleton")
@Path("/basket/")
public class BasketService {
	
	@Autowired
	private BasketRepository basketRepository;
	
	@Autowired
	private ProductService productService;
	

	public BasketService() {
		System.out.println("Basket Service Created");
	}
	

	@POST //HTTP method
	@Path("/register") 
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Transactional //helps to fetch dependent data
	public Basket registerOrUpdateBasket(@BeanParam Basket ba) {
		ba = basketRepository.save(ba);
		System.out.println("Basket Registered" + ba);
		return ba;
	}
	
	
	@GET
	@Path("/find/{basketId}")
	@Produces(MediaType.APPLICATION_JSON) 
	@Transactional 
	public Basket findByBasketId(@PathParam("basketId") int basketId) {
		try {
			Basket ba = basketRepository.findById(basketId).get();
			System.out.println(ba.getItems().size() + " Basket items fetched");
			return ba;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	@POST 
	@Path("/assign/product")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	@Produces(MediaType.APPLICATION_JSON) 
	@Transactional
	public Set<Product> assignProduct(@FormParam("basketId") int basketId, 
									  @FormParam("productId") int productId) {
		try {
			Basket bas = findByBasketId(basketId);
			Product prod = productService.findByProductId(productId);
			
			bas.getItems().add(prod);
			bas = registerOrUpdateBasket(bas);
			return bas.getItems();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@POST
	@Path("/deleteFromBasket")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Set<Product> deleteProduct(@FormParam("basketId") int basketId, 
									  @FormParam("productId") int productId) {
		try {
			Basket bas = findByBasketId(basketId);
			Product prod = productService.findByProductId(productId);
			
			bas.getItems().remove(prod);
			basketRepository.save(bas);
			return bas.getItems();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	

	@DELETE
	@Path("/delete/{basketId}")
	public void deleteByProductId(@PathParam("basketId") int basketId) {
		basketRepository.deleteById(basketId);
	}
}