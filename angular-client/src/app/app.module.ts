import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule }    from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { UserListComponent } from './user-list/user-list.component';
import { UserServiceService } from './service/user-service.service';
import { FormLoginComponent } from './form-login/form-login.component';
import { HomeComponent } from './home/home.component';
import { PatientListComponent } from './patient-list/patient-list.component';
import { PatientService } from './service/patient-service.service';
import { PatientDetailsComponent } from './patient-details/patient-details.component';
import { AddPatientComponent } from './addpatient/addpatient.component';
import { LoginService } from './service/login-service.service';

@NgModule({
  declarations: [
    AppComponent,
    UserListComponent,
    FormLoginComponent,
    HomeComponent,
    PatientListComponent,
    PatientDetailsComponent,
    AddPatientComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [UserServiceService, PatientService, LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }
