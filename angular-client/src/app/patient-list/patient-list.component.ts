import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Patient } from '../model/patient';
import { PatientService } from '../service/patient-service.service';
@Component({
  selector: 'app-patient-list',
  templateUrl: './patient-list.component.html',
  styleUrls: ['./patient-list.component.scss']
})
export class PatientListComponent {

  patients!: Patient[];
  patient!:Patient;

  constructor (private patientService: PatientService, private router: Router) {
  }

  ngOnInit() {
    this.loadPatients()
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
