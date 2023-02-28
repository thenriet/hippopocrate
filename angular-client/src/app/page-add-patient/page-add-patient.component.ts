import { Component, Injectable, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { addPatientModel } from '../model/addPatient-models';
import { Patient } from '../model/patient';
import { PatientService } from '../service/patient-service';
import { ServiceHippoService } from '../service/service-hippo.service';
import { ServiceHippo } from '../model/serviceHippo';
import { Observable } from 'rxjs';
import { Room } from '../model/room';
import { Bed } from '../model/bed';

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
  serviceId!: string;
  rooms !: Room[];
  roomId!: string;
  beds !: Bed[];
  bedId!: string;

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
      service:['', Validators.required],
      room:['', Validators.required],
      bed:['', Validators.required]
     });
     this.patientService.findAll().subscribe(result => 
      this.patientListLength = result.length +1
    );
  }

  onSubmit() {

    let data = this.addPatientForm.value;
    this.patient.id = this.patientListLength;
    this.patient.firstname = data.firstname;
    this.patient.lastname = data.lastname;
    this.patient.address= data.address;
    this.patient.birthdate= data.birthdate;
    this.patient.service_id= data.service;
    this.patient.room_id= data.room;
    this.patient.bed_id=data.bed;
    const current = new Date();
    const timestamp = current.getTime();
    this.patient.date_in= current;
    this.patientService.save(this.patient).subscribe(result => this.gotoPatientList());
    console.log(this.patient)
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

  onSelectService(){
    console.log('Selected option:', this.serviceId);
    if(this.serviceId){
      console.log(this.serviceHippo.findOneById(this.serviceId));
      this.serviceHippo.findRooms(this.serviceId).subscribe(data => {
        this.rooms = data;
        console.log(this.rooms)
      });
    }
  }

  onSelectRoom(){
    console.log('Selected option:', this.roomId);
    console.log(this.serviceHippo.findRooms(this.serviceId));
    if(this.serviceId){
      this.serviceHippo.findBeds(this.roomId).subscribe(data => {
        this.beds = data;
        console.log(this.beds)
      });

    }
  }

  onSelectBed(){
    console.log('Le bed is selected');
  }


  save() {
    // Call a function to save the selected option
  }
}
