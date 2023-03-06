
import { Router } from '@angular/router';
import { ServiceHippo } from '../model/serviceHippo';
import { AuthentificationService } from '../service/authentification-service.service';
import { Component, OnInit } from '@angular/core';
import { Patient } from '../model/patient';
import { PatientService } from '../service/patient-service.service';
import { ServiceHippoService } from '../service/service-hippo.service';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-patient-list',
  templateUrl: './patient-list.component.html',
  styleUrls: ['./patient-list.component.scss']
})
export class PatientListComponent {

  patients!: Patient[];
  service!: ServiceHippo;
  serviceId!: number;
  role!: string;
  username!: any;
  dateOut!:string|null

  constructor (
    private patientService: PatientService,
    private hippoService: ServiceHippoService,
    private router: Router,
    private authService: AuthentificationService,
    private datePipe: DatePipe,
    ) {

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
      this.patients.forEach( (patient) => {
        patient.dateOut = this.transformDate(patient.dateOut)
      })
    })
  }

  seePatient(id: number) {
    this.router.navigate(['patient', id]);
  }

  getService(serviceId: number) {
    this.hippoService.findOneServiceById(serviceId).subscribe(data => {
      this.service = data;
    })
  }

  transformDate(date : Date | null | string) {
    return this.datePipe.transform(date, 'dd-MM-YYYY');
  }
}
