import { TestBed } from '@angular/core/testing';

import { Assessmentservice } from './assessment-service';

describe('Assessmentservice', () => {
  let service: Assessmentservice;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Assessmentservice);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});