import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddClassroom } from './add-classroom';

describe('AddClassroom', () => {
  let component: AddClassroom;
  let fixture: ComponentFixture<AddClassroom>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddClassroom]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddClassroom);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
