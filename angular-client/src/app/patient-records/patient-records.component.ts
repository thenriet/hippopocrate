import { Component, OnInit } from '@angular/core';
import {
  FormGroup,
  FormBuilder,
  Validators,
  NonNullableFormBuilder,
} from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Patient } from '../model/patient';
import { PatientService } from '../service/patient-service.service';
import { CommentaryService } from '../service/commentary-service';
import { Commentary } from '../model/commentary';
import { AuthentificationService } from '../service/authentification-service.service';

@Component({
  selector: 'app-patient-records',
  templateUrl: './patient-records.component.html',
  styleUrls: ['./patient-records.component.scss'],
})
export class PatientRecordsComponent implements OnInit {
  id!: number;
  patient!: Patient;
  addCommentaryForm!: FormGroup;
  commentaryForm = new Commentary();
  error = false;
  patient_id!: number;
  patientRecordsLength!: number;
  username!: string;
  userId!: number;

  constructor(
    private route: ActivatedRoute,
    private patientService: PatientService,
    private router: Router,
    private fb: FormBuilder,
    private commentaryService: CommentaryService,
    private authService: AuthentificationService
  ) {
    this.patient = new Patient();
  }

  ngOnInit() {
    this.loadPatientById();

    this.addCommentaryForm = this.fb.group({
      commentary: ['', Validators.required],
    });

    this.commentaryService.getCommentaryByPatientId(this.patient_id).subscribe({
      next: (result) => {
        this.patientRecordsLength = result.length + 1;
      },
      error: (e) => {
        console.log(e);
      },
    });
    this.username = this.authService.getLoggedInUserName();

    this.authService.getUserIdByUsername(this.username).subscribe((data) => {
      this.userId = parseInt(data);
    });
  }

  loadPatientById() {
    this.patient_id = this.route.snapshot.params['id'];
    this.patientService.getPatientById(this.patient_id).subscribe({
      next: (data) => {
        this.patient = data;
      },
      error: (e) => {
        console.log(e);
      },
    });
  }

  onSubmit() {
    this.patient_id = this.route.snapshot.params['patient_id'];
    let data = this.addCommentaryForm.value;
    this.commentaryForm.id = this.patientRecordsLength;
    this.commentaryForm.patientId = this.patient.id;
    this.commentaryForm.commentary = data.commentary;
    this.commentaryForm.userName = this.username;
    this.commentaryForm.userId = this.userId;

    this.commentaryService
      .save(this.commentaryForm)
      .subscribe((result) => this.gotoPatientDetails(this.patient.id));
    try {
      this.addCommentaryForm.value;
    } catch (error) {
      console.log(error);
      this.error = true;
    }
    console.log(this.commentaryForm);
  }

  gotoPatientDetails(id: number) {
    this.router.navigate(['patient', id]);
  }
}
