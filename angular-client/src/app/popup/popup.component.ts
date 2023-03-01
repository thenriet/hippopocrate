import { Component, ElementRef, Input, OnDestroy, OnInit, Output } from '@angular/core';
import { Patient } from '../model/patient';
import { PatientService } from '../service/patient-service.service';
import { PopUpService } from '../service/pop-up.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-popup',
  templateUrl: './popup.component.html',
  styleUrls: ['./popup.component.scss'],
})
export class PopupComponent implements OnInit, OnDestroy {
  @Input() id?: string;
  @Input() patient!: Patient;
  isOpen = false;
  patientId!: number;
  private element: any;
  
  constructor(
    private popUpService: PopUpService,
    protected patientService: PatientService, 
    private el: ElementRef,
    private router: Router,
    private route: ActivatedRoute, 
    ) {
      this.element = el.nativeElement;
      this.patientId = this.route.snapshot.params['id'];
  }

  ngOnInit() {
      // add self (this modal instance) to the modal service so it can be opened from any component
      this.popUpService.add(this);

      // move element to bottom of page (just before </body>) so it can be displayed above everything else
      document.body.appendChild(this.element);

      // close modal on background click
      this.element.addEventListener('click', (el: any) => {
          if (el.target.className === 'jw-modal') {
              this.close();
          }
      });
  }

  ngOnDestroy() {
      // remove self from modal service
      this.popUpService.remove(this);

      // remove modal element from html
      this.element.remove();
  }

  open() {
      this.element.style.display = 'block';
      document.body.classList.add('jw-modal-open');
      this.isOpen = true;
  }

  close() {
      this.element.style.display = 'none';
      document.body.classList.remove('jw-modal-open');
      this.isOpen = false;
  }

  exitThePatient(id : number) {
    this.patient.bedId=null;
    const current = new Date();
    const timestamp = current.getTime();
    this.patient.dateOut= current;
    console.log(this.patient)   
    this.patientService.exit(this.patient, this.patientId)
    .subscribe(patient => {
      console.log('Patient updated:', patient);
    }, error => {
      console.error('Error updating patient:', error);
    });
        this.isOpen = false;
    this.gotoPatients();
  }

  gotoPatientDetails(id:number) {
    this.router.navigate(['patients',id]).then(() => {
      window.location.reload();
    });
  }

  gotoPatients() {
    this.router.navigate(['patients']).then(() => {
      window.location.reload();
    });
  }
}
