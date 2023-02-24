import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-fiche-patient',
  templateUrl: './fiche-patient.component.html',
  styleUrls: ['./fiche-patient.component.scss']
})
export class FichePatientComponent {
  constructor ( private route: Router){
  }
  ngOnInit():void{
  this.route.navigateByUrl("/fichepatient");
  }
}
