import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditAssessment } from './edit-assessment';

describe('EditAssessment', () => {
  let component: EditAssessment;
  let fixture: ComponentFixture<EditAssessment>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditAssessment]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditAssessment);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
