import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PageConnexionComponent } from './page-connexion/page-connexion.component';
import { PageAddPatientComponent } from './page-add-patient/page-add-patient.component';
import { ListeServicesComponent } from './liste-services/liste-services.component';
import { OncologieComponent } from './oncologie/oncologie.component';
import { CardiologieComponent } from './cardiologie/cardiologie.component';
import { NeurologieComponent } from './neurologie/neurologie.component';
import { GynecologieComponent } from './gynecologie/gynecologie.component';
import { FichePatientComponent } from './fiche-patient/fiche-patient.component';
import { ListePatientsComponent } from './liste-patients/liste-patients.component';
import { ListeUtilisateursComponent } from './liste-utilisateurs/liste-utilisateurs.component';
import { PageAccueilComponent } from './page-accueil/page-accueil.component';
import { SuiviPatientComponent } from './suivi-patient/suivi-patient.component';
import { NavbarComponent } from './navbar/navbar.component';

@NgModule({
  declarations: [
    AppComponent,
    PageConnexionComponent,
    PageAddPatientComponent,
    ListeServicesComponent,
    OncologieComponent,
    CardiologieComponent,
    NeurologieComponent,
    GynecologieComponent,
    FichePatientComponent,
    ListePatientsComponent,
    ListeUtilisateursComponent,
    PageAccueilComponent,
    SuiviPatientComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
