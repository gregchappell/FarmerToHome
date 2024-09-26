import { Component, OnInit } from '@angular/core';
import { Farmer } from '../farmer';
import { FarmerService } from '../farmer.service';

@Component({
  selector: 'app-seller-registration',
  templateUrl: './seller-registration.component.html',
  styleUrls: ['./seller-registration.component.css']
})
export class SellerRegistrationComponent implements OnInit {
  farmerId: number
  firstName: String
  lastName: String
  email: String
  address: String
  phone: number
  farmerUsername: String
  farmerPassword: String
  farmers: Farmer[]
  allFarmers: Farmer[]

  constructor(private farmerSvc:FarmerService) { 
    this.farmerId
    this.firstName
    this.lastName
    this.address
    this.email
    this.phone
    this.farmerUsername
    this.farmerPassword
  }

  ngOnInit() {
    this.fetchCurrentSellerFromService()
  }

  showFarmer(){
    this.loadAllFarmers()
  }

  fetchCurrentSellerFromService(){
    this.farmerSvc.findFarmerByFarmerId(this.farmerId).subscribe(
        // use the response to initialize the component properties
      response => { // assign the data received from server
          // as response to the current component
        this.farmerId = response.farmerId
        this.firstName = response.firstName
        this.lastName = response.lastName
        this.address = response.address
        this.phone = response.phone
        this.email = response.email
        this.farmerUsername = response.farmerUsername
        this.farmerPassword = response.farmerPassword
      } 
    )
  }

  registerFarmerDetails(){
    this.farmerSvc.registerFarmerOnServer({
      //farmerId:this.farmerId, 
      firstName:this.firstName,
      lastName:this.lastName,
      email:this.email, 
      address:this.address,
      phone:this.phone,
      farmerUsername:this.farmerUsername,
      farmerPassword:this.farmerPassword
    }).subscribe(
      response =>{ // perform the following operation on successful post
        this.fetchCurrentSellerFromService()
      } 
    ) 
  }

  loadAllFarmers(){
    this.farmerSvc.loadAllFarmersFromServer().subscribe(
      response => {
        this.allFarmers = response
      }
    )
  }

}
