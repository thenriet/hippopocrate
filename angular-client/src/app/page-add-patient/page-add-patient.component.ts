import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { addPatientModel } from 'src/Models/addPatient-models';

@Component({
  selector: 'app-page-add-patient',
  templateUrl: './page-add-patient.component.html',
  styleUrls: ['./page-add-patient.component.scss']
})

export class PageAddPatientComponent {
  contactForm: FormGroup;
  remplissageForm= new addPatientModel;
  error= false; 
  
  constructor(private fb: FormBuilder) { 

    this.contactForm = this.fb.group({
      firstname:['',Validators.required],
      name :['',Validators.required],
      address:['', Validators.required],
      birthday:['', Validators.required],
      service:['', Validators.required]
     });
  }

  onSubmit() {
    let data = this.contactForm.value;
    this.remplissageForm.firstname = data.firstname;
    this.remplissageForm.name = data.name;
    this.remplissageForm.address= data.address;
    this.remplissageForm.birthday= data.birthday;
    this.remplissageForm.service= data.service;
    console.log(this.remplissageForm);

    try {
      this.contactForm.value
    }
    catch (error){
     console.log(error);
     this.error= true;
    }
  }
}
