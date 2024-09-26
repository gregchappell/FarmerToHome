import { TestBed } from '@angular/core/testing';

import { SellerLoginAuthenticationService } from './seller-login-authentication.service';

describe('SellerLoginAuthenticationService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SellerLoginAuthenticationService = TestBed.get(SellerLoginAuthenticationService);
    expect(service).toBeTruthy();
  });
});
