import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Bed } from '../model/bed';
import { Patient } from '../model/patient';
import { Room } from '../model/room';
import { ServiceHippo } from '../model/serviceHippo';
import { PatientService } from '../service/patient-service.service';
import { ServiceHippoService } from '../service/service-hippo.service';

@Component({
  selector: 'app-update-patient',
  templateUrl: './update-patient.component.html',
  styleUrls: ['./update-patient.component.scss']
})

export class UpdatePatientComponent {
  updatePatientForm!: FormGroup;
  error=false;
  patient =  new Patient();
  updatePatient = new Patient();
  id!:number;
  services !: ServiceHippo[];
  serviceId!: number;
  rooms !: Room[];
  roomId!: number;
  beds !: Bed[];
  bedId!: number;


  constructor (
    private patientService: PatientService,
    private serviceHippo: ServiceHippoService,
    private router: Router,
    private fb:FormBuilder,
    private route: ActivatedRoute) {
      this.serviceHippo.findAll().subscribe(data => {
        this.services = data;
      });
  }

  ngOnInit(){
    this.loadPatientById();

    this.updatePatientForm= this.fb.group({
    firstname:['',Validators.required],
    lastname:['',Validators.required],
    address: ['', Validators.required],
    birthdate: ['',Validators.required],
    service:['',Validators.required],
    room:['', Validators.required],
    bed:['', Validators.required]
    });
   }

   onSubmit(){
    let data= this.updatePatientForm.value;
    console.log(data);
    this.updatePatient.firstname= data.firstname;
    this.updatePatient.lastname=data.lastname;
    this.updatePatient.address= data.address;
    this.updatePatient.birthdate= data.birthdate;
    this.updatePatient.serviceId= data.service;
    this.updatePatient.roomId= data.room;
    this.updatePatient.bedId=data.bed;

    this.patientService.update(this.updatePatient, this.id)
    .subscribe(updatedPatient => {
      console.log('Patient updated:', updatedPatient);
      this.gotoPatientDetails(this.id);
    }, error => {
      console.error('Error updating patient:', error);
    });

    console.log(this.updatePatient);
    try {
      this.updatePatientForm.value;
    } catch (error) {
      console.log(error);
      this.error = true;
    }


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

  gotoPatientDetails(id:number) {
    this.router.navigate(['patient',id]).then(() => {
      window.location.reload();
    });
  }

  onSelectService(){
    if(this.serviceId){
      this.serviceHippo.findRooms(this.serviceId).subscribe(data => {
        this.rooms = data;
      });
    }
  }

  onSelectRoom(){
    if(this.serviceId){
      this.serviceHippo.findBeds(this.roomId).subscribe(data => {
        this.beds = data;
      });
    }
  }
}
