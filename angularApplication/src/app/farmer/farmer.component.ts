import { Component, OnInit } from '@angular/core';
import { Farmer } from '../farmer';
import { FarmerService } from '../farmer.service';

@Component({
  selector: 'app-farmer',
  templateUrl: './farmer.component.html',
  styleUrls: ['./farmer.component.css']
})
export class FarmerComponent implements OnInit {
  farmerId: number
  allFarmers: Farmer[]
  firstName: String;
  lastName: String;
  address: String;
  phone: number;
  email: String;
  farmerUsername: String;
  farmerPassword: String;
  farmers: Farmer[]

  constructor(private farmerSvc:FarmerService) { 
    this.farmerId=-1
    this.firstName
    this.lastName
    this.address
    this.email
    this.phone
    this.farmerUsername
    this.farmerPassword
  }

  ngOnInit() {
    this.fetchCurrentFarmerFromService()
  }

  showFarmer(){
    this.loadAllFarmers()
  }

  fetchCurrentFarmerFromService(){
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
      farmerId:this.farmerId, 
      firstName: this.firstName, 
      email:this.email, 
      address:this.address,
      phone:this.phone,
      farmerUsername:this.farmerUsername,
      farmerPassword:this.farmerPassword
    }).subscribe(
      response => { // perform the following operation on successful post
        this.fetchCurrentFarmerFromService()
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
