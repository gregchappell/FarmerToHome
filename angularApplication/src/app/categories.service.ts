import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, from } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CategoriesService {
  rootURL : string

  constructor(private httpsvc:HttpClient) {
    this.rootURL ="http://localhost:8080/product/"
   }

  getProductsByCategory(category):Observable<any>{
    return this.httpsvc.get(this.rootURL+ "fetchByCategory/?category=" + category)
  }
}

