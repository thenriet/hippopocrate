import { ComponentFixture, TestBed } from '@angular/core/testing';

<<<<<<< HEAD:angular-client/src/app/update-user/update-user.component.spec.ts
import { UpdateUserComponent } from './update-user.component';

describe('UpdateUserComponent', () => {
  let component: UpdateUserComponent;
  let fixture: ComponentFixture<UpdateUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateUserComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdateUserComponent);
=======
import { UpdatePatientComponent } from './update-patient.component';

describe('UpdatePatientComponent', () => {
  let component: UpdatePatientComponent;
  let fixture: ComponentFixture<UpdatePatientComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdatePatientComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdatePatientComponent);
>>>>>>> d17867156cb44598f732fa9c504896dd471c22e7:angular-client/src/app/update-patient/update-patient.component.spec.ts
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
