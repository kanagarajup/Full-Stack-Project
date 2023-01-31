import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { CreateCustomerComponent } from './create-customer/create-customer.component';
import { UpdateCustomerComponent } from './update-customer/update-customer.component';
import { CustomerDetailsComponent } from './customer-details/customer-details.component';

const routes: Routes = [
  {path:'customers',component:CustomerListComponent},
  {path:'create-customer',component:CreateCustomerComponent},
  {path: '', redirectTo: 'customers', pathMatch: 'full'},
  {path: 'update-customer/:id', component: UpdateCustomerComponent},
  {path: 'customer-details/:id', component: CustomerDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
