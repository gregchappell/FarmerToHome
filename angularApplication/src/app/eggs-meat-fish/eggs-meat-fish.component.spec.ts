import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EggsMeatFishComponent } from './eggs-meat-fish.component';

describe('EggsMeatFishComponent', () => {
  let component: EggsMeatFishComponent;
  let fixture: ComponentFixture<EggsMeatFishComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EggsMeatFishComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EggsMeatFishComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
