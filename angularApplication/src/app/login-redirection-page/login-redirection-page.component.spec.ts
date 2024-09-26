import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginRedirectionPageComponent } from './login-redirection-page.component';

describe('LoginRedirectionPageComponent', () => {
  let component: LoginRedirectionPageComponent;
  let fixture: ComponentFixture<LoginRedirectionPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoginRedirectionPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginRedirectionPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
