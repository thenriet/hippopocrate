import { Component, OnInit, Output } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Patient } from '../model/patient';
import { PatientService } from '../service/patient-service.service';
import { PopUpService } from '../service/pop-up.service';
import { DatePipe } from '@angular/common';



@Component({
  selector: 'app-patient-details',
  templateUrl: './patient-details.component.html',
  styleUrls: ['./patient-details.component.scss']
})
export class PatientDetailsComponent implements OnInit {
  id!: number;
  patient = new Patient();
  birthdate!: string|null;
  isVisible = false;
  bodyText = 'This text can be updated in modal 1';


  constructor (
    private patientService: PatientService, 
    private route: ActivatedRoute, 
    private router: Router,
    private datePipe: DatePipe,
    protected popUpService: PopUpService
    ) {
      
      this.loadPatientById();
  }

  
  ngOnInit() {
  }

  transformDate(date : Date) {
    this.birthdate = (this.datePipe.transform(date, 'dd-MM-YYYY'));
  }

  loadPatientById() {
    this.id = this.route.snapshot.params['id'];
    this.patientService.getPatientById(this.id).subscribe({
      next: (data) => {
        this.patient = data;
        this.transformDate(this.patient.birthdate);
      },
      error: (e) => {
        console.log(e);
      }
    });
  }

  transferTheId (id: number) {
    this.router.navigate(['updatepatient', id]);
  }

  gotoPatientDetails(id:number) {
    this.router.navigate(['patients',id]).then(() => {
      window.location.reload();
    });
  }

}
