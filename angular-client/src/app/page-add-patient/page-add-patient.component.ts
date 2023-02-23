import { Component, Injectable, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { addPatientModel } from 'src/Models/addPatient-models';
import { Patient } from '../model/patient';
import { PatientService } from '../service/patient-service';

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
  remplissageForm= new addPatientModel;
  error= false; 
  
  constructor(
    private fb: FormBuilder,
    private route: ActivatedRoute, 
    private router: Router, 
    private patientService: PatientService
    ) { 
      this.patient = new Patient();  
  }
  ngOnInit(): void {
    this.addPatientForm = this.fb.group({
      firstname:['',Validators.required],
      lastname :['',Validators.required],
      address:['', Validators.required],
      birthdate:['', Validators.required],
      service:['', Validators.required]
     });
  }

  onSubmit() {
    let data = this.addPatientForm.value;
    this.remplissageForm.firstname = data.firstname;
    this.remplissageForm.lastname = data.lastname;
    this.remplissageForm.address= data.address;
    this.remplissageForm.birthdate= data.birthday;
    this.remplissageForm.service= data.service;
    console.log(this.remplissageForm);
    this.patient.firstname = data.firstname;
    this.patient.lastname = data.lastname;
    this.patient.address = data.address;
    this.patient.bed_id = 3;
    this.patient.id = 3;
    this.patient.birthdate = data.birthdate;
    console.log(this.patient)
    this.patientService.save(this.patient).subscribe(result => this.gotoPatientList());

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
}
