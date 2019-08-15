import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserBuyerProfileComponent } from './user-buyer-profile/user-buyer-profile.component';
import { Consumer } from './consumer';

@Injectable({
  providedIn: 'root'
})
export class ConsumerService {
  rootURL: String

  constructor(private httpsvc:HttpClient) { 
    this.rootURL="http://localhost:8080/consumer"
  }

  findUserByUserId(consno):Observable<UserBuyerProfileComponent>{
    return this.httpsvc.get<UserBuyerProfileComponent>(this.rootURL+"/find/"+consno)
  }

  loadAllUsersOnServer():Observable<Consumer[]> {
    return this.httpsvc.get<Consumer[]>("http://localhost:8080/consumer/list")
  }

  registerUserOnServer(consumer):Observable<UserBuyerProfileComponent> {
    const httpOptions = {
      headers: new HttpHeaders(
        {"Content-Type":"application/x-www-form-urlencoded"}
      )
    }
    var reqBody = "consno="+consumer.consno
                +"&firstName="+consumer.firstName
                +"&lastName="+consumer.lastName
                +"&email="+consumer.email
                +"&address="+consumer.address
                +"&phone="+consumer.phone
                +"&consumerUsername="+consumer.consumerUsername
                +"&consumerPassword="+consumer.consumerPassword
    return this.httpsvc.post<UserBuyerProfileComponent>(
      this.rootURL+"/register",reqBody,httpOptions
    )
  }

}
