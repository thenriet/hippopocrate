import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PageConnexionComponent } from './page-connexion/page-connexion.component';
import { PageAddPatientComponent } from './page-add-patient/page-add-patient.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { UserListComponent } from './user-list/user-list.component';
import { UserServiceService } from './service/user-service.service';
import { FormLoginComponent } from './form-login/form-login.component';
import { HomeComponent } from './home/home.component';
import { PatientListComponent } from './patient-list/patient-list.component';
import { PatientService } from './service/patient-service.service';
import { PatientDetailsComponent } from './patient-details/patient-details.component';
import { AddPatientComponent } from './addpatient/addpatient.component';
import { NavbarComponent } from './navbar/navbar.component';
import { AuthentificationService } from './service/authentification-service.service';
// import { HttpInterceptorService } from './service/httpinterceptor.service';
import { ListeServiceComponent } from './liste-service/liste-service.component';
import { PatientListComponent } from './patient-list/patient-list.component';

@NgModule({
  declarations: [
    AppComponent,
    PageConnexionComponent,
    PageAddPatientComponent,
    UserListComponent,
    FormLoginComponent,
    HomeComponent,
    PatientListComponent,
    PatientDetailsComponent,
    AddPatientComponent,
    NavbarComponent,,
    ListeServiceComponent,
    PatientListComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [
    UserServiceService,
    PatientService,
    AuthentificationService,
    // {
    //   provide: HTTP_INTERCEPTORS,
    //   useClass: HttpInterceptorService,
    //   multi: true,
    // },,
    ReactiveFormsModule,
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
