import { Product } from './product';

export interface Quantity {

    id : number
    basketId : number
    quantity : number
    product : Product[]
}
