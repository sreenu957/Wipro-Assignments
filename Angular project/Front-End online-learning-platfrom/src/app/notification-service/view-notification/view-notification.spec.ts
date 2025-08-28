import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewNotification } from './view-notification';

describe('ViewNotification', () => {
  let component: ViewNotification;
  let fixture: ComponentFixture<ViewNotification>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ViewNotification]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewNotification);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
