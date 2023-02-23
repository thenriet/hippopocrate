import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GynecologieComponent } from './gynecologie.component';

describe('GynecologieComponent', () => {
  let component: GynecologieComponent;
  let fixture: ComponentFixture<GynecologieComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GynecologieComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GynecologieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
