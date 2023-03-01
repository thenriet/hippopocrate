import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Patient } from '../model/patient';
import { ServiceHippo } from '../model/serviceHippo';
import { PatientService } from '../service/patient-service.service';
import { ServiceHippoService } from '../service/service-hippo.service';

@Component({
  selector: 'app-patient-details',
  templateUrl: './patient-details.component.html',
  styleUrls: ['./patient-details.component.scss']
})
export class PatientDetailsComponent implements OnInit {
  id!: number;
  patient!: Patient;

  constructor (private patientService: PatientService, private route: ActivatedRoute, private router: Router, private serviceHippo: ServiceHippoService) {}

  ngOnInit() {
    this.loadPatientById();
  }

  loadPatientById() {
    this.id = this.route.snapshot.params['id'];
    this.patientService.getPatientById(this.id).subscribe({
      next: (data) => {
        this.patient = data;
      },
      error: (e) => {
        console.log(e);
      }
    });
  }

}
