import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-change-patient',
  templateUrl: './change-patient.component.html',
  styleUrls: ['./change-patient.component.scss']
})
export class ChangePatientComponent {
  constructor ( private route: Router){
  }
  ngOnInit():void{
  this.route.navigateByUrl("/changepatient");
  }
}
