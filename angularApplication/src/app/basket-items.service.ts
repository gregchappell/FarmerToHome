import { Injectable } from '@angular/core';
import { Basket } from './basket/basket';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Order } from './basket/order';

@Injectable({
  providedIn: 'root'
})
export class BasketItemsService {
  rootURL : string

  constructor(private httpsvc:HttpClient) {
    this.rootURL = "http://localhost:8080/basket/"
   }

getBasketItems(basketId):Observable<Order[]>{
  return this.httpsvc.get<Order[]>("http://localhost:8080/order/getOrderByBasket/" + basketId)
}

deleteFromBasket(productId, basketId):Observable<Order[]>{ const httpOptions = {
  headers: new HttpHeaders(
    {"Content-Type" : "application/x-www-form-urlencoded"}
  )
}
  var reqBody = "productId=" + productId + "&basketId=" + basketId
    return this.httpsvc.post<Order[]>("http://localhost:8080/order/deleteFromOrder", reqBody, httpOptions)


}


}
