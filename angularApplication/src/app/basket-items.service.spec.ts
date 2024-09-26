import { TestBed } from '@angular/core/testing';

import { BasketItemsService } from './basket-items.service';

describe('BasketItemsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: BasketItemsService = TestBed.get(BasketItemsService);
    expect(service).toBeTruthy();
  });
});
