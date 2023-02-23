import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CardiologieComponent } from './cardiologie/cardiologie.component';
import { GynecologieComponent } from './gynecologie/gynecologie.component';
import { ListeServicesComponent } from './liste-services/liste-services.component';
import { NeurologieComponent } from './neurologie/neurologie.component';
import { OncologieComponent } from './oncologie/oncologie.component';

const routes: Routes = [
  {path: '', component:ListeServicesComponent},
  {path: 'oncologie', component: OncologieComponent},
  {path: 'cardiologie', component:CardiologieComponent},
  {path: 'neurologie', component:NeurologieComponent},
  {path: 'gynecologie', component: GynecologieComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
