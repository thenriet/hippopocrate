import { TestBed } from '@angular/core/testing';

import { ServiceHippoService } from './service-hippo.service';

describe('ServiceHippoService', () => {
  let service: ServiceHippoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ServiceHippoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
