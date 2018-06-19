import { TestBed, inject } from '@angular/core/testing';

import { SubInvoiceService } from './sub-invoice.service';

describe('SubInvoiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SubInvoiceService]
    });
  });

  it('should be created', inject([SubInvoiceService], (service: SubInvoiceService) => {
    expect(service).toBeTruthy();
  }));
});
