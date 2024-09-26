import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsumerLoginRegistrationComponent } from './consumer-login-registration.component';

describe('ConsumerLoginRegistrationComponent', () => {
  let component: ConsumerLoginRegistrationComponent;
  let fixture: ComponentFixture<ConsumerLoginRegistrationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConsumerLoginRegistrationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConsumerLoginRegistrationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
