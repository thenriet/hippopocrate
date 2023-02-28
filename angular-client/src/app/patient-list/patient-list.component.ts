import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Patient } from '../model/patient';
import { ServiceHippo } from '../model/serviceHippo';
import { AuthentificationService } from '../service/authentification-service.service';
import { PatientService } from '../service/patient-service.service';
import { ServiceHippoService } from '../service/service-hippo.service';
@Component({
  selector: 'app-patient-list',
  templateUrl: './patient-list.component.html',
  styleUrls: ['./patient-list.component.scss']
})
export class PatientListComponent {

  patients!: Patient[];
  service!: ServiceHippo;
  serviceId!: String;
  role!: String;
  username!: any;

  constructor (
    private patientService: PatientService,
    private hippoService: ServiceHippoService, 
    private router: Router, 
    private authService: AuthentificationService) {

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
    this.router.navigate(['patients', id]);
  }

  getService(serviceId: string) {
    this.hippoService.findOneServiceById(serviceId).subscribe(data => {
      this.service = data;
    })
  }
}
