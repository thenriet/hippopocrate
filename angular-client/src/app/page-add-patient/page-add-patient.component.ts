import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-page-add-patient',
  templateUrl: './page-add-patient.component.html',
  styleUrls: ['./page-add-patient.component.scss']
})

export class PageAddPatientComponent {
  constructor ( private route: Router){
  }
  ngOnInit():void{
  this.route.navigateByUrl("/ajouterpatient");
  }  
}
