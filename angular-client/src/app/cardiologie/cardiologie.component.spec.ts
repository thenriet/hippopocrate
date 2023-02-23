import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardiologieComponent } from './cardiologie.component';

describe('CardiologieComponent', () => {
  let component: CardiologieComponent;
  let fixture: ComponentFixture<CardiologieComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardiologieComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardiologieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
