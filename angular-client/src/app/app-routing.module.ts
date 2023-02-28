import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormLoginComponent } from './form-login/form-login.component';
import { HomeComponent } from './home/home.component';
import { ListeServiceComponent } from './liste-service/liste-service.component';
import { AddPatientComponent } from './add-patient/add-patient.component';
import { PatientListComponent } from './patient-list/patient-list.component';
import { UserListComponent } from './user-list/user-list.component';
import { PatientDetailsComponent } from './patient-details/patient-details.component';
import { UpdatePatientComponent } from './update-patient/update-patient.component';

const routes: Routes = [
  { path: 'list', component: ListeServiceComponent },
  { path: '', component: FormLoginComponent},
  { path: 'login', component: FormLoginComponent },
  { path: 'accueil', component: HomeComponent },
  { path: 'users', component: UserListComponent },
  { path: 'patients', component: PatientListComponent },
  { path: 'patients/:id', component: PatientDetailsComponent},
  { path: 'addpatient', component: AddPatientComponent },
  {path: 'updatepatient/:id', component: UpdatePatientComponent},
  // { path: '**', redirectTo: '' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
