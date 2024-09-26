package com.example.farmerHome.apis;

import java.util.Set;

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

import com.example.farmerHome.entities.Farmer;
import com.example.farmerHome.entities.Product;
import com.example.farmerHome.repositories.FarmerRepository;

@Component
@Scope("singleton")
@Path("/farmer/")
public class FarmerService {
	
	@Autowired
	private FarmerRepository farmerRepository;
	
	@Autowired
	private ProductService productService;
	
	public FarmerService() {
		System.out.println("Farmer service created");
	}


	@POST //-> HTTP Method 
	@Path("/register/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON) 
	@Transactional //helps to fetch dependent data
	public Farmer registerOrUpdateFarmer(@BeanParam Farmer farmer) {
		Farmer currentFarmer = findByFarmerId(farmer.getFarmerId());
		
		if(currentFarmer!=null) { //update
			currentFarmer.setFirstName(farmer.getFirstName());
			currentFarmer.setLastName(farmer.getLastName());
			currentFarmer.setAddress(farmer.getAddress());
			currentFarmer.setEmail(farmer.getEmail());
			currentFarmer.setFarmerUsername(farmer.getFarmerUsername());
			currentFarmer.setFarmerPassword(farmer.getFarmerPassword());
			currentFarmer.setPhone(farmer.getPhone());
			farmer = farmerRepository.save(currentFarmer);
		
		} else { //create
			farmer = farmerRepository.save(farmer);
		}
		System.out.println("Farmer Registered"+farmer);
		return farmer;
	}


	@GET
	@Path("/find/{farmerId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Farmer findByFarmerId(@PathParam("farmerId") int farmerId) {
		try {
			Farmer farmer = farmerRepository.findById(farmerId).get();
			System.out.println(farmer.getFarmerProds().size() + " Farmer Products fetched");
			return farmer;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	

	@GET
	@Path("/list")
	@Produces({MediaType.APPLICATION_JSON})
	@Transactional
	public Iterable<Farmer> getAllFarmers(){
		Iterable<Farmer> farmers = farmerRepository.findAll();
		return farmers;
	}
	
	
	@POST 
	@Path("/assign/product") 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Set<Product> assignProduct(@FormParam("productId") int productId, 
									  @FormParam("farmerId") int farmerId) {
		try {
			Farmer far = findByFarmerId(farmerId);
			Product prod = productService.findByProductId(productId);
			
			far.getFarmerProds().add(prod);
			far = registerOrUpdateFarmer(far);
			return far.getFarmerProds();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@DELETE
	@Path("/delete/{farmerId}")
	public void deleteFarmerById(@PathParam("farmerId") int farmerId) {
		farmerRepository.deleteById(farmerId);
	}
}
