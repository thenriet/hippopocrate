import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddPatientComponent } from './add-patient/add-patient.component';
import { HttpClientModule } from '@angular/common/http';
import { UserListComponent } from './user-list/user-list.component';
import { UserServiceService } from './service/user-service.service';
import { FormLoginComponent } from './form-login/form-login.component';
import { HomeComponent } from './home/home.component';
import { PatientService } from './service/patient-service.service';
import { PatientDetailsComponent } from './patient-details/patient-details.component';
import { NavbarComponent } from './navbar/navbar.component';
import { AuthentificationService } from './service/authentification-service.service';
import { ListeServiceComponent } from './liste-service/liste-service.component';
import { PatientListComponent } from './patient-list/patient-list.component';
import { UpdatePatientComponent } from './update-patient/update-patient.component';
import { DatePipe } from '@angular/common';
import { PopupComponent } from './popup/popup.component';

@NgModule({
  declarations: [
    AppComponent,
    AddPatientComponent,
    UserListComponent,
    FormLoginComponent,
    HomeComponent,
    NavbarComponent,
    ListeServiceComponent,
    UpdatePatientComponent,
    PatientListComponent,
    PatientDetailsComponent,
    PopupComponent,
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
    ReactiveFormsModule,
    DatePipe,
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
