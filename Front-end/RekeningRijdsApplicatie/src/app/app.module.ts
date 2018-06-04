import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {RouterModule, Routes} from '@angular/router';
import { HomeComponent } from './home/home.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { InvoicesComponent } from './invoices/invoices.component';
import { InvoiceCardComponent } from './invoice-card/invoice-card.component';
import { VehiclesComponent } from './vehicles/vehicles.component';
import { VehicleCardComponent } from './vehicle-card/vehicle-card.component';
import { JourneyModalComponent } from './journey-modal/journey-modal.component';

const appRoutes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'invoices/:id',
    component: InvoicesComponent
  },
  {
    path: 'vehicles',
    component: VehiclesComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'register',
    component: RegisterComponent
  },
  {
    path: '**',
    component: NotFoundComponent
  }
];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NotFoundComponent,
    NavBarComponent,
    LoginComponent,
    RegisterComponent,
    InvoicesComponent,
    InvoiceCardComponent,
    VehiclesComponent,
    VehicleCardComponent,
    JourneyModalComponent
  ],
  imports: [
    BrowserModule,
    NgbModule.forRoot(),
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent],
  entryComponents: [
    JourneyModalComponent
  ]
})
export class AppModule {
}
