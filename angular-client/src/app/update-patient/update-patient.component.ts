import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AddPatient } from '../model/addpatient';
import { Patient } from '../model/patient';
import { PatientService } from '../service/patient-service.service';


@Component({
  selector: 'app-update-patient',
  templateUrl: './update-patient.component.html',
  styleUrls: ['./update-patient.component.scss']
})

export class UpdatePatientComponent {
   updatePatientForm!: FormGroup;
   error=false;
   patientForm = new AddPatient;
   patient= new Patient();
   id!:number;


  constructor (
    private patientService: PatientService, 
    private router: Router, 
    private fb:FormBuilder, 
    private route: ActivatedRoute) {
  }
  
  ngOnInit(){
    this.loadPatientById();
  
    this.updatePatientForm= this.fb.group({
    firstname:['',Validators.required],
    lastname:['',Validators.required],
    address: ['', Validators.required],
    birthdate: ['',Validators.required],
    service:['',Validators.required]
    });
   }

  loadPatientById() {
    this.id = this.route.snapshot.params['id'];
    this.patientService.getPatientById(this.id).subscribe({
      next: (data) => {
        this.patient = data;
        console.log(this.patient);
      },
      error: (e) => {
        console.log(e);
      }
    });
  }

  
  OnSubmit(){
    let data= this.updatePatientForm.value;

    this.patientForm.firstname= data.firstname; 
    this.patientForm.lastname=data.lastname;
    this.patientForm.address= data.address;
    this.patientForm.birthdate = data.birthdate;

   this.patientService.update(this.patientForm, this.id);
    
    console.log(this.patientForm);


    try {
      this.updatePatientForm.value;
    } catch (error) {
      console.log(error);
      this.error = true;
    }

    this.gotoPatientDetails(this.id);
  }

  gotoPatientDetails(id:number) {
    this.router.navigate(['patient',id]);
  }
}

