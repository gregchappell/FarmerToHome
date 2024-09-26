import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BakeryDairyComponent } from './bakery-dairy.component';

describe('BakeryDairyComponent', () => {
  let component: BakeryDairyComponent;
  let fixture: ComponentFixture<BakeryDairyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BakeryDairyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BakeryDairyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
