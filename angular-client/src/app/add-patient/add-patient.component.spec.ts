import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PageAddPatientComponent } from './page-add-patient.component';

describe('PageAddPatientComponent', () => {
  let component: PageAddPatientComponent;
  let fixture: ComponentFixture<PageAddPatientComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PageAddPatientComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PageAddPatientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
