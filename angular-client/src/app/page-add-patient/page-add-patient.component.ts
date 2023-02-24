import { Component, Injectable, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { addPatientModel } from '../model/addPatient-models';
import { Patient } from '../model/patient';
import { PatientService } from '../service/patient-service';
import { ServiceHippoService } from '../service/service-hippo.service';
import { ServiceHippo } from '../model/serviceHippo';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-page-add-patient',
  templateUrl: './page-add-patient.component.html',
  styleUrls: ['./page-add-patient.component.scss']
})

@Injectable({
  providedIn: 'root'
})

export class PageAddPatientComponent implements OnInit {
  addPatientForm!: FormGroup;
  patient!: Patient;
  patientForm = new addPatientModel;
  error= false;
  patientListLength !: number;
  services !: ServiceHippo[];
  
  constructor(
    private fb: FormBuilder,
    private route: ActivatedRoute, 
    private router: Router, 
    private patientService: PatientService,
    private serviceHippo: ServiceHippoService
    ) { 
      this.patient = new Patient(); 
      this.serviceHippo.findAll().subscribe(data => {
        this.services = data;
      });
  }

  ngOnInit(): void {
    this.addPatientForm = this.fb.group({
      firstname:['',Validators.required],
      lastname :['',Validators.required],
      address:['', Validators.required],
      birthdate:['', Validators.required],
      service:['', Validators.required]
     });
     this.patientService.findAll().subscribe(result => 
      this.patientListLength = result.length +1
    );
  }

  onSubmit() {

    let data = this.addPatientForm.value;
    console.log(data);
    this.patientForm.id = this.patientListLength;
    this.patientForm.firstname = data.firstname;
    this.patientForm.lastname = data.lastname;
    this.patientForm.address= data.address;
    this.patientForm.birthdate= data.birthdate;
    this.patientService.save(this.patientForm).subscribe(result => this.gotoPatientList());
    console.log(this.patientForm)
    try {
      this.addPatientForm.value
    }
    catch (error){
     console.log(error);
     this.error= true;
    }
  }

  gotoPatientList() {
    this.router.navigate(['/patients']);
  }

  onClick(){
    console.log("test");
    // méthode qui va chercher un service en particulier
  }
}
