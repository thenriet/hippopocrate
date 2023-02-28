import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Patient } from '../model/patient';
import { PatientService } from '../service/patient-service.service';

@Component({
  selector: 'app-reviews',
  templateUrl: './reviews.component.html',
  styleUrls: ['./reviews.component.scss']
})
export class ReviewsComponent implements OnInit{
  id!: number;
  patient!: Patient;
  addCommentaryForm!: FormGroup;
  commentaryForm= new Patient;
  error= false; 

  constructor ( private route: ActivatedRoute, 
    private patientService: PatientService,
    private router: Router, 
    private fb: FormBuilder)
    {
    this.patient= new Patient();
    }
  
  ngOnInit(){
  this.loadPatientById();

  this.addCommentaryForm = this.fb.group({
    commentary:['',Validators.required],
    user_id:['', Validators.required],
    patient_id: ['',Validators.required],
   });
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
  OnSubmit(){
    let data =this.addCommentaryForm.value;
    this.commentaryForm.commentary= data.commentary;

   this.patientService.save(this.commentaryForm)
   
   try {
    this.addCommentaryForm.value;
  } catch (error) {
    console.log(error);
    this.error = true;
  }
   
  console.log(this.commentaryForm)
    
    //subscribe((result) => 
    this.gotoPatientDetails(this.id);
  }
  gotoPatientDetails(id:number) {
      this.router.navigate(['patient',id]);
    }
}

