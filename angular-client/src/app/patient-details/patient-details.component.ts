import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Commentary } from '../model/commentary';
import { Patient } from '../model/patient';
import { ServiceHippo } from '../model/serviceHippo';
import { UserServiceService } from '../service/user-service.service';
import { PatientService } from '../service/patient-service.service';
import { CommentaryService } from '../service/commentary-service';

@Component({
  selector: 'app-patient-details',
  templateUrl: './patient-details.component.html',
  styleUrls: ['./patient-details.component.scss'],
})
export class PatientDetailsComponent implements OnInit {
  id!: number;
  username!: String;
  patient_id!: number;
  patient = new Patient();
  commentary = new Commentary();
  commentaries!: Commentary[];

  constructor(
    private patientService: PatientService,
    private route: ActivatedRoute,
    private router: Router,
    private commentaryService: CommentaryService,
    private userService: UserServiceService
  ) {}

  ngOnInit() {
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
      },
    });
  }

  loadCommentaryById() {
    this.commentaryService.getCommentaryByPatientId(this.id).subscribe({
      next: (data) => {
        this.commentaries = data;
      },
      error: (e) => {
        console.log(e);
      },
    });
  }

  suiviId(id: number) {
    this.router.navigate(['suivipatient', id]);
  }
}
