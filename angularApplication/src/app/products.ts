import { Category } from './basket/category';

export interface Products {
    productId: number
    product_name: string
    price: number
    expiryDate: number;
    currentCategory: Category[]
}
