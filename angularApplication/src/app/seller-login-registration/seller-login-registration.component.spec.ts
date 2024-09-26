import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SellerLoginRegistrationComponent } from './seller-login-registration.component';

describe('SellerLoginRegistrationComponent', () => {
  let component: SellerLoginRegistrationComponent;
  let fixture: ComponentFixture<SellerLoginRegistrationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SellerLoginRegistrationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SellerLoginRegistrationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
