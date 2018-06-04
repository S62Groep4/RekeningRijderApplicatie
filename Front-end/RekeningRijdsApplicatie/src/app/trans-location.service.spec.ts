import { TestBed, inject } from '@angular/core/testing';

import { TransLocationService } from './trans-location.service';

describe('TransLocationService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TransLocationService]
    });
  });

  it('should be created', inject([TransLocationService], (service: TransLocationService) => {
    expect(service).toBeTruthy();
  }));
});
