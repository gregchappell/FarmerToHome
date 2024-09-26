import { TestBed } from '@angular/core/testing';

import { ConsumerService } from './user.service';

describe('UserService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ConsumerService = TestBed.get(ConsumerService);
    expect(service).toBeTruthy();
  });
});
