import { Category } from './category';

export interface Product {
    productId : number
    product_name : string
    price : number
    expiry_date : number
    currentCategory : Category[]
}