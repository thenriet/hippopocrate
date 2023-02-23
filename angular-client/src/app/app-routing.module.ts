import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormLoginComponent } from './form-login/form-login.component';
import { HomeComponent } from './home/home.component';
import { PatientListComponent } from './patient-list/patient-list.component';
import { UserListComponent } from './user-list/user-list.component';

const routes: Routes = [
  { path: '', component: FormLoginComponent},
  { path: 'login', component: FormLoginComponent },
  { path: 'accueil', component: HomeComponent },
  { path: 'users', component: UserListComponent },
  { path: 'patients', component: PatientListComponent },
  { path: '**', redirectTo: '' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
