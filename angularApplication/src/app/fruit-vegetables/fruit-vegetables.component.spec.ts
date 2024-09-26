import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FruitVegetablesComponent } from './fruit-vegetables.component';

describe('FruitVegetablesComponent', () => {
  let component: FruitVegetablesComponent;
  let fixture: ComponentFixture<FruitVegetablesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FruitVegetablesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FruitVegetablesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
