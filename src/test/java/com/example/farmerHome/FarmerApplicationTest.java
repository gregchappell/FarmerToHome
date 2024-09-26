package com.example.farmerHome;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.farmerHome.apis.FarmerService;
import com.example.farmerHome.entities.Farmer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FarmerApplicationTest {

	@Autowired
	FarmerService farmerService;
	
	
	@Test
	public void exampleFarmerTest() {
		System.out.println("Farmer test case scenarios");
	}

//	// CRUD - Add farmer
//	@Test
//	public void addFarmerUsingService() {
//		//farmer.setFarmerID(1001);
//		Farmer farmer = new Farmer();
//		farmer.setFirstName("John");
//		farmer.setLastName("McGreen");
//		farmer.setAddress("123 Avenue");
//		farmer.setEmail("testfarmer@gmail.com");
//		farmer.setFarmerUsername("farmjohn");
//		farmer.setFarmerPassword("myfarmproducts");
//		farmer.setPhone(447777788);
//		farmer = farmerService.registerOrUpdateFarmer(farmer);
//		assertNotNull(farmer);
//	}
//	
//	// CRUD - Find farmer by id
//	@Test
//	public void findFarmerUsingService() {
//		int farmerId = 6;
//		assertNotNull(farmerService.findByFarmerId(farmerId));
//	}
//	
//	// CRUD - Delete farmer by id
//	@Test
//	public void deleteFarmerUsingService() {
//		int farmerId = 10;
//		farmerService.deleteFarmerById(farmerId);
//		assertNull(farmerService.findByFarmerId(farmerId));
//	}
}
