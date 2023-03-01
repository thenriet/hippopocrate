import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { filter, mergeMap } from 'rxjs';
import { Patient } from '../model/patient';
import { ServiceHippo } from '../model/serviceHippo';
import { PatientService } from '../service/patient-service.service';
import { ServiceHippoService } from '../service/service-hippo.service';

@Component({
  selector: 'app-service-details',
  templateUrl: './service-details.component.html',
  styleUrls: ['./service-details.component.scss'],
})
export class ServiceDetailsComponent implements OnInit {
  id!: number;
  service = new ServiceHippo();
  patients!: Patient[];
  loadPatient!: any;

  constructor(
    private serviceHippo: ServiceHippoService,
    private servicePatient: PatientService,
    private route: ActivatedRoute,
    private router: Router,
    private http: HttpClient
  ) {}

  ngOnInit() {
    this.loadServiceById();
    this.loadPatientsByService();
  }

  loadServiceById() {
    this.id = this.route.snapshot.params['id'];
    this.serviceHippo.findOneById(this.id).subscribe({
      next: (data) => {
        this.service = data;
      },
      error: (e) => {
        console.log(e);
      },
    });
  }

  loadPatientsByService() {
    this.id = this.route.snapshot.params['id'];
    this.servicePatient.findAllByService(this.id).subscribe((data) => {
      this.patients = data;
    });
  }
}
