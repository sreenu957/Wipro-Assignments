import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditNotification } from './edit-notification';

describe('EditNotification', () => {
  let component: EditNotification;
  let fixture: ComponentFixture<EditNotification>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditNotification]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditNotification);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
