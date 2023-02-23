import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NeurologieComponent } from './neurologie.component';

describe('NeurologieComponent', () => {
  let component: NeurologieComponent;
  let fixture: ComponentFixture<NeurologieComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NeurologieComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NeurologieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
