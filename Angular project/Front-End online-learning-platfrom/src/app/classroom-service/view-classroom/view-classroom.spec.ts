import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewClassroom } from './view-classroom';

describe('ViewClassroom', () => {
  let component: ViewClassroom;
  let fixture: ComponentFixture<ViewClassroom>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ViewClassroom]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewClassroom);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
