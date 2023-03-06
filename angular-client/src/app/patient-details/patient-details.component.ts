import { Component, OnInit, Output } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Commentary } from '../model/commentary';
import { Patient } from '../model/patient';
import { PatientService } from '../service/patient-service.service';
import { CommentaryService } from '../service/commentary-service';
import { PopUpService } from '../service/pop-up.service';
import { DatePipe } from '@angular/common';
import { AuthentificationService } from '../service/authentification-service.service';

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
  birthdate!: string | null;
  isVisible = false;
  bodyText = 'This text can be updated in modal 1';
  role!: String;

  constructor(
    private patientService: PatientService,
    private route: ActivatedRoute,
    private router: Router,
    private commentaryService: CommentaryService,
    private datePipe: DatePipe,
    protected popUpService: PopUpService,
    private authenticationService: AuthentificationService
  ) {
    this.loadPatientById();
  }

  ngOnInit() {
    this.loadPatientById();
    this.loadCommentaryById();
    this.authenticationService.getUserRole().subscribe((data) => {
      this.role = data;
      console.log(this.role)
    });
  }

  transformDate(date: Date) {
    this.birthdate = this.datePipe.transform(date, 'dd-MM-YYYY');
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
    this.router.navigate(['suiviPatient', id]);
  }

  transferTheId(id: number) {
    this.router.navigate(['updatepatient', id]);
  }

  gotoPatientDetails(id: number) {
    this.router.navigate(['patients', id]).then(() => {
      window.location.reload();
    });
  }
}
