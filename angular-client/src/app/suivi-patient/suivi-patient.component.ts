import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-suivi-patient',
  templateUrl: './suivi-patient.component.html',
  styleUrls: ['./suivi-patient.component.scss']
})
export class SuiviPatientComponent {
  constructor ( private route: Router){
  }
  ngOnInit():void{
  this.route.navigateByUrl("/suivipatient");
  }
}
