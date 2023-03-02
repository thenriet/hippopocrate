import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormLoginComponent } from './form-login/form-login.component';
import { HomeComponent } from './home/home.component';
import { ListeServiceComponent } from './liste-service/liste-service.component';
import { PatientListComponent } from './patient-list/patient-list.component';
import { UserListComponent } from './user-list/user-list.component';
import { PatientDetailsComponent } from './patient-details/patient-details.component';
import { AddPatientComponent } from './add-patient/add-patient.component';
import { AddUserComponent } from './add-user/add-user.component';
import { UpdateUserComponent } from './update-user/update-user.component';
import { ServiceDetailsComponent } from './service-details/service-details.component';
import { PatientRecordsComponent } from './patient-records/patient-records.component';

const routes: Routes = [
  { path: 'services', component: ListeServiceComponent },
  { path: 'service/:id', component: ServiceDetailsComponent },
  { path: '', component: FormLoginComponent},
  { path: 'login', component: FormLoginComponent },
  { path: 'addUser', component: AddUserComponent },
  { path: 'updateUser/:id', component: UpdateUserComponent },
  { path: 'accueil', component: HomeComponent },
  { path: 'users', component: UserListComponent },
  { path: 'patients', component: PatientListComponent },
  { path: 'patient/:id', component: PatientDetailsComponent},
  { path: 'addPatient', component: AddPatientComponent},
  { path: 'suiviPatient/:id', component: PatientRecordsComponent},
  { path: '**', redirectTo: '' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
