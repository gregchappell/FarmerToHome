import { TestBed } from '@angular/core/testing';

import { FarmerService } from './farmer.service';

describe('FarmerService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: FarmerService = TestBed.get(FarmerService);
    expect(service).toBeTruthy();
  });
});
