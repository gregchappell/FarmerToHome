import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SellerAdminDashboardComponent } from './seller-admin-dashboard.component';

describe('SellerAdminDashboardComponent', () => {
  let component: SellerAdminDashboardComponent;
  let fixture: ComponentFixture<SellerAdminDashboardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SellerAdminDashboardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SellerAdminDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
