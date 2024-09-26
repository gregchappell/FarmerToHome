package com.example.farmerHome.apis;

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
import org.springframework.transaction.annotation.Transactional;
import com.example.farmerHome.entities.Basket;
import com.example.farmerHome.entities.Consumer;
import com.example.farmerHome.repositories.ConsumerRepository;

@Component
@Scope("singleton")
@Path("/consumer/")
public class ConsumerService {
	
	@Autowired
	private ConsumerRepository consumerRepository;
	
	@Autowired
	private BasketService basketService;
	
	
	public ConsumerService() {
		System.out.println("Consumer Service Created");
	}
	
	
	@POST //HTTP method
	@Path("/register/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional //helps to fetch dependent data
	public Consumer registerOrUpdateConsumer(@BeanParam Consumer con) {
		Consumer currentCon = findByConsno(con.getConsno());
		
		if(currentCon!=null) { //update
			currentCon.setEmail(con.getEmail());
			currentCon.setFirstName(con.getFirstName());
			currentCon.setLastName(con.getLastName());
			currentCon.setAddress(con.getAddress());
			currentCon.setPhone(con.getPhone());
			con = consumerRepository.save(currentCon);
		
		} else { //create
			con = consumerRepository.save(con);
		}
		System.out.println("Consumer Registered " + con);
		return con;
	}

	
	@GET
	@Path("/find/{consno}")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Consumer findByConsno(@PathParam("consno") int consno) {
		try {
			return consumerRepository.findById(consno).get();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	@GET
	@Path("/list")
	@Produces({MediaType.APPLICATION_JSON})
	public Iterable<Consumer> listAllConsumers() {
		return consumerRepository.findAll();
	}

	
	@POST
	@Path("/assign/basket")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Basket assignBasket(@FormParam("basketId") int basketId,
							   @FormParam("consno") int consno) {
		try {
			Basket bas = basketService.findByBasketId(basketId);
			Consumer con = findByConsno(consno);
			
			con.getOrderHistory().add(bas);
			bas.setCurrentConsumer(con);
			bas = basketService.registerOrUpdateBasket(bas);
			return bas;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	
	@DELETE
	@Path("/delete/{consno}")
	public void deleteByConsno(@PathParam("consno")int consno) {
		consumerRepository.deleteById(consno);
	}
}
