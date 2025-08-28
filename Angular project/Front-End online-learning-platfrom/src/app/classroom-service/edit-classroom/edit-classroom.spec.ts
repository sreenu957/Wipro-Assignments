import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditClassroom } from './edit-classroom';

describe('EditClassroom', () => {
  let component: EditClassroom;
  let fixture: ComponentFixture<EditClassroom>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditClassroom]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditClassroom);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
