
import { Component, OnInit } from '@angular/core';
import { Products } from '../products';
import { ProductsService } from '../products.service';
import { Basket } from '../basket/basket';
import { Quantity } from '../basket/quantity';
import { OrderService } from '../order.service';
import { Order } from '../basket/order';
import { BasketItemsService } from '../basket-items.service';

@Component({
  selector: 'app-fruit-vegetables',
  templateUrl: './fruit-vegetables.component.html',
  styleUrls: ['./fruit-vegetables.component.css']
})

export class FruitVegetablesComponent implements OnInit {
    currentBasket : Basket[]
    addQua : Order[]
    currentQuantity : Quantity[]
    updateQuantity : Quantity

    AllQuantities : number[]
    currentOrder : Order[]
    quantity : number
    orderId : number

   
    productId : number
    basketId : number
    products: Products[]
    currentProduct : Order

   constructor(private productService: ProductsService, private basketItemService: BasketItemsService, 
    private orderService: OrderService) { 
    this.basketId = 14
    this.products=[]
  }

  ngOnInit() {
    this.productService.fetchProductsByCategory(2).subscribe(
      response => {
        this.products = response
      }
    )
    this.calcQuantity()
  }


  calcQuantity(){
    this.basketItemService.getBasketItems(this.basketId).subscribe(
      res => {
        this.currentOrder = res
        
      }
    )
    }

  addQuantity(productId, quantity){
    console.log(this.basketId, productId) // 14, 37
    this.orderService.addOrders(productId, quantity, this.basketId).subscribe(
      res => {this.currentOrder = res}
    )
  }

  deleteProducts(productId){
    this.basketItemService.deleteFromBasket(productId, this.basketId).subscribe(
      res => {this.currentOrder = res})

      

   
    
    

  }
}
