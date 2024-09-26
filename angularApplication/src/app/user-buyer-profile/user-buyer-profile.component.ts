import { Component, OnInit } from '@angular/core';
import { ConsumerService } from '../user.service';

@Component({
  selector: 'app-user-buyer-profile',
  templateUrl: './user-buyer-profile.component.html',
  styleUrls: ['./user-buyer-profile.component.css']
})
export class UserBuyerProfileComponent implements OnInit {
  consno: number
  firstName: String
  lastName: String
  email: String
  address: String
  phone: number
  consumerUsername: String;
  consumerPassword: String;

  isEditable: boolean
  isUserFormVisable: boolean
  isUserFormValid: boolean
  invalidFromMessage: boolean

  constructor(private userSvc:ConsumerService) {
    this.isEditable = false
    this.isUserFormVisable = false
    this.isUserFormValid = true

    this.consno=1
    this.firstName
    this.lastName
    this.email
    this.address
    this.phone
    this.consumerUsername
    this.consumerPassword
   }

  ngOnInit() {
    this.fetchCurrentConsumerFromService()
  }

  fetchCurrentConsumerFromService(){
    this.userSvc.findUserByUserId(this.consno).subscribe(
      response => {
        this.consno = response.consno
        this.firstName = response.firstName
        this.lastName = response.lastName
        this.email = response.email
        this.address = response.address
        this.phone = response.phone
        this.consumerUsername = response.consumerUsername
        this.consumerPassword = response.consumerPassword
      }
    )
  }

  toggleEdits() {
    this.isEditable = !this.isEditable
    this.RegisterConsumerDetails()
  }

  RegisterConsumerDetails() {
    this.userSvc.registerUserOnServer({
      consno:this.consno, 
      firstName:this.firstName,
      lastName:this.lastName,
      email:this.email,
      address:this.address, 
      phone:this.phone,
      consumerUsername:this.consumerUsername,
      consumerPassword:this.consumerPassword
    }).subscribe(
      response => {
        this.fetchCurrentConsumerFromService()
      }
    )
  }

}
