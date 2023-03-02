import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule }    from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddPatientComponent } from './add-patient/add-patient.component';
import { HttpClientModule } from '@angular/common/http';
import { UserListComponent } from './user-list/user-list.component';
import { UserServiceService } from './service/user-service.service';
import { FormLoginComponent } from './form-login/form-login.component';
import { HomeComponent } from './home/home.component';
import { PatientListComponent } from './patient-list/patient-list.component';
import { PatientService } from './service/patient-service.service';
import { PatientDetailsComponent } from './patient-details/patient-details.component';
import { NavbarComponent } from './navbar/navbar.component';
import { AuthentificationService } from './service/authentification-service.service';
// import { HttpInterceptorService } from './service/httpinterceptor.service';
import { ListeServiceComponent } from './liste-service/liste-service.component';
import { AddUserComponent } from './add-user/add-user.component';
import { UpdateUserComponent } from './update-user/update-user.component';
import { ServiceDetailsComponent } from './service-details/service-details.component';
import { PatientRecordsComponent } from './patient-records/patient-records.component';

@NgModule({
  declarations: [
    AppComponent,
    UserListComponent,
    FormLoginComponent,
    HomeComponent,
    PatientListComponent,
    PatientDetailsComponent,
    AddPatientComponent,
    NavbarComponent,
    ListeServiceComponent,
    AddUserComponent,
    UpdateUserComponent,
    ServiceDetailsComponent,
    PatientRecordsComponent,
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
    // },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
