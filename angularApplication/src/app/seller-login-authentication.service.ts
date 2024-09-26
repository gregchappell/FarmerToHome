import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SellerLoginAuthenticationService {

  constructor() { }


  authenticate(email, farmerPassword){
    if (email === "kfermin2@springer.com" && farmerPassword === "WyMYIE"){
      sessionStorage.setItem("email", email)
      return true;
    } else {
      return false;
    }
  }

  isFarmerLoggedIn(){
    let farmer = sessionStorage.getItem("email")
    console.log(!(farmer === null))
    return !(farmer === null)
  }


}
