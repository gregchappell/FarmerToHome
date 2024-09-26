import { Component, OnInit } from '@angular/core';
import { Products } from '../products';
import { ProductsService } from '../products.service';
import { Basket } from '../basket/basket';
import { Order } from '../basket/order';
import { BasketItemsService } from '../basket-items.service';
import { OrderService } from '../order.service';

@Component({
  selector: 'app-eggs-meat-fish',
  templateUrl: './eggs-meat-fish.component.html',
  styleUrls: ['./eggs-meat-fish.component.css']
})
export class EggsMeatFishComponent implements OnInit {
   products: Products[]
   basketId : number
   currentProduct : Order
   currentOrder: Order[]

   constructor(private productService: ProductsService, private basketItemService: BasketItemsService,
    private orderService: OrderService) { 
     this.products=[]
     this.basketId = 14
  }

  ngOnInit() {
    this.productService.fetchProductsByCategory(4).subscribe(
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
