import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CardiologieComponent } from './cardiologie/cardiologie.component';
import { ChangePatientComponent } from './change-patient/change-patient.component';
import { FichePatientComponent } from './fiche-patient/fiche-patient.component';
import { GynecologieComponent } from './gynecologie/gynecologie.component';
import { ListePatientsComponent } from './liste-patients/liste-patients.component';
import { ListeServicesComponent } from './liste-services/liste-services.component';
import { ListeUtilisateursComponent } from './liste-utilisateurs/liste-utilisateurs.component';
import { NeurologieComponent } from './neurologie/neurologie.component';
import { OncologieComponent } from './oncologie/oncologie.component';
import { PageAccueilComponent } from './page-accueil/page-accueil.component';
import { PageAddPatientComponent } from './page-add-patient/page-add-patient.component';
import { PageConnexionComponent } from './page-connexion/page-connexion.component';
import { SuiviPatientComponent } from './suivi-patient/suivi-patient.component';

const routes: Routes = [
  {path:'', component:PageConnexionComponent},
  {path: 'accueil', component:PageAccueilComponent},
  {path: 'oncologie', component: OncologieComponent},
  {path: 'cardiologie', component:CardiologieComponent},
  {path: 'neurologie', component:NeurologieComponent},
  {path: 'gynecologie', component: GynecologieComponent},
  {path: 'users', component:ListeUtilisateursComponent},
  {path: 'patients', component: ListePatientsComponent},
  {path: 'listeservices', component: ListeServicesComponent},
  {path: 'fichepatient', component: FichePatientComponent},
  {path:'suivipatient', component: SuiviPatientComponent},
  {path:'ajouterpatient', component: PageAddPatientComponent},
  {path:'changepatient', component:ChangePatientComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
