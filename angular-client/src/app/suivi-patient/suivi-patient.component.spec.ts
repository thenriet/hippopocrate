import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SuiviPatientComponent } from './suivi-patient.component';

describe('SuiviPatientComponent', () => {
  let component: SuiviPatientComponent;
  let fixture: ComponentFixture<SuiviPatientComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SuiviPatientComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SuiviPatientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
