import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { JourneyModalComponent } from './journey-modal.component';

describe('JourneyModalComponent', () => {
  let component: JourneyModalComponent;
  let fixture: ComponentFixture<JourneyModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ JourneyModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(JourneyModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
