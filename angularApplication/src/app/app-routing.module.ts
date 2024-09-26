import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component'
import { BasketComponent } from './basket/basket.component'
import { BakeryDairyComponent } from './bakery-dairy/bakery-dairy.component';
import { BeveragesComponent } from './beverages/beverages.component';
import { BuyerDashboardComponent } from './buyer-dashboard/buyer-dashboard.component';
import { ConsumerLoginRegistrationComponent } from './consumer-login-registration/consumer-login-registration.component';
import { DiscountsComponent } from './discounts/discounts.component';
import { EggsMeatFishComponent } from './eggs-meat-fish/eggs-meat-fish.component';
import { FruitVegetablesComponent } from './fruit-vegetables/fruit-vegetables.component';
import { IndividualProductsComponent } from './individual-products/individual-products.component';
import { LoginRedirectionPageComponent } from './login-redirection-page/login-redirection-page.component';
import { SellerAdminDashboardComponent } from './seller-admin-dashboard/seller-admin-dashboard.component';
import { SellerLoginRegistrationComponent } from './seller-login-registration/seller-login-registration.component';
import { SellerProfileComponent } from './seller-profile/seller-profile.component';
import { UserBuyerProfileComponent } from './user-buyer-profile/user-buyer-profile.component';
import { FarmerComponent } from './farmer/farmer.component';
import { SellerRegistrationComponent } from './seller-registration/seller-registration.component';
import { ConsumerRegistrationComponent } from './consumer-registration/consumer-registration.component';
import { AboutUsComponent } from './about-us/about-us.component';



const routes: Routes = [
  { path: '', component: HomeComponent},
  { path: 'basket', component: BasketComponent},
  { path: 'bakery-dairy', component: BakeryDairyComponent},
  { path: 'beverages', component: BeveragesComponent},
  { path: 'buyer-dashboad', component: BuyerDashboardComponent},
  { path: 'consumer-login-registration', component: ConsumerLoginRegistrationComponent},
  { path: 'discounts', component: DiscountsComponent},
  { path: 'eggs-meat-fish', component: EggsMeatFishComponent},
  { path: 'fruit-vegetables', component: FruitVegetablesComponent},
  { path: 'individual-products', component: IndividualProductsComponent},
  { path: 'login-redirection-page', component: LoginRedirectionPageComponent},
  { path: 'seller-admin-dashboard', component: SellerAdminDashboardComponent},
  { path: 'seller-login-registration', component: SellerLoginRegistrationComponent},
  { path: 'seller-registration', component: SellerRegistrationComponent},
  { path: 'seller-profile', component: SellerProfileComponent},
  { path: 'user-buyer-profile', component: UserBuyerProfileComponent},
  { path: 'consumer-registration', component: ConsumerRegistrationComponent},
  { path: 'about-us', component: AboutUsComponent},

  // { path: 'farmer', component:FarmerComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
