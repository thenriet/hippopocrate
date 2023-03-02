import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Patient } from '../model/patient';
import { PatientService } from '../service/patient-service.service';
import { CommentaryService } from '../service/commentary-service';
import { Commentary } from '../model/commentary';

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

  constructor(
    private route: ActivatedRoute,
    private patientService: PatientService,
    private router: Router,
    private fb: FormBuilder,
    private commentaryService: CommentaryService
  ) {
    this.patient = new Patient();
  }

  ngOnInit() {
    this.loadPatientById();

    this.addCommentaryForm = this.fb.group({
      commentary: ['', Validators.required],
      //user_id:['', Validators.required],
      // patient_id: ['',Validators.required],
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
    // this.patient_id = this.route.snapshot.params['patient_id'];

    let data = this.addCommentaryForm.value;
    this.commentaryForm.commentary = data.commentary;

    this.commentaryService.save(this.commentaryForm, this.patient_id);

    try {
      this.addCommentaryForm.value;
    } catch (error) {
      console.log(error);
      this.error = true;
    }

    console.log(this.commentaryForm);

    //subscribe((result) =>
    this.gotoPatientDetails(this.id);
  }
  gotoPatientDetails(id: number) {
    this.router.navigate(['patient', id]);
  }
}
