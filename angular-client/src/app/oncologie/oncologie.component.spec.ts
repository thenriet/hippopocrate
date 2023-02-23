import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OncologieComponent } from './oncologie.component';

describe('OncologieComponent', () => {
  let component: OncologieComponent;
  let fixture: ComponentFixture<OncologieComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OncologieComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OncologieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
