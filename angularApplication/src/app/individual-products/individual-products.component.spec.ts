import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IndividualProductsComponent } from './individual-products.component';

describe('IndividualProductsComponent', () => {
  let component: IndividualProductsComponent;
  let fixture: ComponentFixture<IndividualProductsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IndividualProductsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IndividualProductsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
