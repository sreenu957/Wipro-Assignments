import { TestBed } from '@angular/core/testing';
import { Courseservice } from './userservice';

describe('Courseservice', () => {
  let service:Courseservice;

  beforeEach(()=>{
    TestBed.configureTestingModule({});
    service = TestBed.inject(Courseservice);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
