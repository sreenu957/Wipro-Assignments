import { TestBed } from '@angular/core/testing';

import { Classroomservice } from './classroom-service';

describe('Classroomservice', () => {
  let service: Classroomservice;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Classroomservice);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});