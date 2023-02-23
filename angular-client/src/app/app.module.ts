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

@NgModule({
  declarations: [
    AppComponent,
    PageConnexionComponent,
    PageAddPatientComponent,
    ListeServicesComponent,
    OncologieComponent,
    CardiologieComponent,
    NeurologieComponent,
    GynecologieComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
