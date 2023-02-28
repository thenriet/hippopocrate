
import { Router } from '@angular/router';
import { AuthentificationService } from '../service/authentification-service.service';
import { Component, OnInit } from '@angular/core';
import { Patient } from '../model/patient';
import { PatientService } from '../service/patient-service.service';

@Component({
  selector: 'app-patient-list',
  templateUrl: './patient-list.component.html',
  styleUrls: ['./patient-list.component.scss']
})
export class PatientListComponent {

  patients!: Patient[];
  role!: String;
  username!: any;

  constructor (private patientService: PatientService, private router: Router, private authService: AuthentificationService) {

  }

  ngOnInit() {
    this.loadPatients()
    this.authService.getUserRole().subscribe(data => {
      this.role = data;
    })
  }

  loadPatients() {
    this.patientService.findAll().subscribe(data => {
      this.patients = data;
    })
  }

  seePatient(id: number) {
    this.router.navigate(['patient', id]);
  }
}
