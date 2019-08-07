import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { IndividualProductsComponent } from './individual-products/individual-products.component';
import { BasketComponent } from './basket/basket.component';
import { LoginRedirectionPageComponent } from './login-redirection-page/login-redirection-page.component';
import { ConsumerLoginRegistrationComponent } from './consumer-login-registration/consumer-login-registration.component';
import { SellerLoginRegistrationComponent } from './seller-login-registration/seller-login-registration.component';
import { FruitVegetablesComponent } from './fruit-vegetables/fruit-vegetables.component';
import { BakeryDairyComponent } from './bakery-dairy/bakery-dairy.component';
import { BeveragesComponent } from './beverages/beverages.component';
import { EggsMeatFishComponent } from './eggs-meat-fish/eggs-meat-fish.component';
import { SellerAdminDashboardComponent } from './seller-admin-dashboard/seller-admin-dashboard.component';
import { SellerProfileComponent } from './seller-profile/seller-profile.component';
import { BuyerDashboardComponent } from './buyer-dashboard/buyer-dashboard.component';
import { UserBuyerProfileComponent } from './user-buyer-profile/user-buyer-profile.component';
import { DiscountsComponent } from './discounts/discounts.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { NgxPaginationModule } from 'ngx-pagination';
import { TestSearchComponent } from './test-search/test-search.component';




@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    IndividualProductsComponent,
    BasketComponent,
    LoginRedirectionPageComponent,
    ConsumerLoginRegistrationComponent,
    SellerLoginRegistrationComponent,
    FruitVegetablesComponent,
    BakeryDairyComponent,
    BeveragesComponent,
    EggsMeatFishComponent,
    SellerAdminDashboardComponent,
    SellerProfileComponent,
    BuyerDashboardComponent,
    UserBuyerProfileComponent,
    DiscountsComponent,
    TestSearchComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgxPaginationModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
