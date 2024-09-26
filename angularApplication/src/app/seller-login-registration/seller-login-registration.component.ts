import { Component, OnInit } from '@angular/core';
import { Farmer } from '../farmer';
import { FarmerService } from '../farmer.service';
import { SellerLoginAuthenticationService } from '../seller-login-authentication.service';
import { Router } from '@angular/router';
import { FarmerComponent } from '../farmer/farmer.component';

@Component({
  selector: 'app-seller-login-registration',
  templateUrl: './seller-login-registration.component.html',
  styleUrls: ['./seller-login-registration.component.css']
})
export class SellerLoginRegistrationComponent implements OnInit {

  farmerId: number
  firstName: String 
  lastName: String
  email: String
  phone: number
  address:String
  farmerUsername:String
  farmerPassword:String

  currentFarmer: Farmer

  farmers: Farmer[]

  allFarmers: Farmer[]

  constructor(private farmerSvc:FarmerService, private router: Router, private authenSvc:SellerLoginAuthenticationService) { 

    this.farmerId 
    this.firstName 
    this.lastName
    this.email
    this.phone
    this.address
    this.farmerUsername
    this.farmerPassword
    


  }

  ngOnInit() {
    //this.fetchCurrentFarmerFromService()
  }

  // // register farmer in memory
  // registerNewFarmer(fName, fprods, flocation){

  //   this.farmers.push({farmerName:fName, products:fprods, farmLocation:flocation})
 
  // }

  showFarmer(){
    this.loadAllFarmers()
  }

  ////-> Joe
  // checkLogin(){
  //   if (this.authenSvc.authenticate(this.email, this.farmerPassword)){
  //     this.router.navigate([""])
  //     this.invalidLogin = false 
  //   } else 
  //     this.invalidLogin = true
  //}

  // fetchCurrentSellerFromService(){
  //   this.
  // }

  //-> end

  loginSeller(){
    // this.farmerSvc.loadAllFarmersFromServer().subscribe(
    this.farmerSvc.fetchByEmailandPassword(this.email,this.farmerPassword).subscribe(
      response => {
        this.firstName = response.firstName
        this.lastName=response.lastName
        this.email = response.email
        this.address = response.address
        this.phone = response.phone
        this.farmerUsername = response.farmerUsername
        this.farmerPassword = response.farmerPassword
      }
    )
  }


  fetchCurrentFarmerFromService(){
    this.farmerSvc.findFarmerByFarmerId(this.farmerId).subscribe(
        // use the response to initialize the component properties
      response => { // assign the data received from server
          // as response to the current component
          this.farmerId = response.farmerId
          this.firstName = response.firstName
          this.lastName=response.lastName
          this.email = response.email
          this.address = response.address
          this.phone = response.phone
          this.farmerUsername = response.farmerUsername
          this.farmerPassword = response.farmerPassword
      } 
    )
    this.validateCredentials(this.email, this.farmerPassword)
  }

  validateCredentials(email,farmerPassword) {
    if(this.email == email && this.farmerPassword == farmerPassword){
      this.farmerSvc.findFarmerByFarmerId(this.farmerId)
    }
    else {
      this.router.navigate(["/home"])
    }

  }

  registerFarmerDetails(){
    this.farmerSvc.registerFarmerOnServer({
      farmerId:this.farmerId, firstName: this.firstName, lastName:this.lastName, address:this.address, email:this.email, 
      phone:this.phone, farmerUsername:this.farmerUsername, farmerPassword:this.farmerPassword
    }).subscribe(
      response =>{ // perform the following operation on successful post
              this.fetchCurrentFarmerFromService()
          } 
        )
      
  }

  loadAllFarmers(){
    this.farmerSvc.loadAllFarmersFromServer()
        .subscribe(
            response =>{
                this.allFarmers = response
        })
  }

}
