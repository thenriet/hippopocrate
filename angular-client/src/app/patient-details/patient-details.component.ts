import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Commentary } from '../model/Commentary';
import { Patient } from '../model/patient';
import { PatientService } from '../service/patient-service.service';
import { CommentaryService } from '../service/Commentary.service';

@Component({
  selector: 'app-patient-details',
  templateUrl: './patient-details.component.html',
  styleUrls: ['./patient-details.component.scss']
})

export class PatientDetailsComponent implements OnInit {
  id!: number;
  patient_id!:number;
  patient= new Patient();
  commentary= new Commentary();
  commentaries!: Commentary[];
  //commentary!:Commentary;

  constructor (private patientService: PatientService, 
    private route: ActivatedRoute, 
    private router: Router, 
    private commentaryService: CommentaryService) {}

  ngOnInit(){
    this.loadPatientById();
    this.loadCommentaryById();
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

  loadCommentaryById(){
  //  this.commentaryService.findAllComments(this.id).subscribe(data => {
  //  this.commentaries = data;
  // })
  this.patient_id = this.route.snapshot.params['patient_id'];
  this.commentaryService.getCommentaryByPatientId(this.patient_id).subscribe({next: (data) => {
      this.commentary = data;
  },
  error: (e) => {
    console.log(e);
  }
  });
}

    transferTheId(id: number) {
      this.router.navigate(['updatepatient', id]);
    }

    suiviId(id: number) {
      this.router.navigate(['suivipatient', id]);
    }
  }


