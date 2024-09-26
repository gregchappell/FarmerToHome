import { Injectable } from '@angular/core';
import { HttpClient,  HttpHeaders } from '../../node_modules/@angular/common/http'
import { Observable } from 'rxjs';
import { Products } from './products'
import { Basket } from './basket/basket';
import { Order } from './basket/order';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {
  url: string

  constructor(private httpsvc:HttpClient) { 
    this.url="http://localhost:8080/product"
  }

  //simple get for all products
  getAllProducts():Observable<Products[]>{
    return this.httpsvc.get<Products[]>(this.url+"/allProducts")
  }

  //fetch by category
  fetchProductsByCategory(categoryId):Observable<Products[]>{
    return this.httpsvc.get<Products[]>(this.url+"/fetchByCategory?categoryId=" + categoryId)
  }

  //fetch by expiry date - discount page
  fetchProductByExpiryDate(min, max):Observable<Products[]>{
    return this.httpsvc.get<Products[]>(this.url+"/fetchByExpiryDate?" + "&min=" + min + "&max=" + max)
  }


  addProductsToBasket(productId, basketId):Observable<Order>{const httpOptions = {
    headers: new HttpHeaders(
      {"Content-Type" : "application/x-www-form-urlencoded"}
    )
  }
    var reqBody = "productId=" + productId + "&basketId=" + basketId
      return this.httpsvc.post<Order>("http://localhost:8080/basket/assign/product", reqBody, httpOptions)
  }


  }


