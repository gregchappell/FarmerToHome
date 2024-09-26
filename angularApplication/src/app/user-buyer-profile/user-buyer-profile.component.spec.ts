import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserBuyerProfileComponent } from './user-buyer-profile.component';

describe('UserBuyerProfileComponent', () => {
  let component: UserBuyerProfileComponent;
  let fixture: ComponentFixture<UserBuyerProfileComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserBuyerProfileComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserBuyerProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
