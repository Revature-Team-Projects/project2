import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component';
import {RegisterCompanyComponent} from './register-company/register-company.component';
import {ErrorComponent} from './error/error.component';
import {CompanyHomepageComponent} from './company-homepage/company-homepage.component';
import {UserHomepageComponent} from './user-homepage/user-homepage.component';


const routes: Routes = [
  {
      path: '',
      redirectTo: '/login', 
      pathMatch: 'full'
  } ,
  {
      path: 'login',
      component: LoginComponent
  } ,
  {   path: 'register',
      component: RegisterComponent
  },

  {   path: 'register-company',
    component: RegisterCompanyComponent
  },

  {   path: 'company-homepage',
    component: CompanyHomepageComponent
  },
  {
    path: 'user-home', component: UserHomepageComponent
  },
  {
    path: '**', component: ErrorComponent
  }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
