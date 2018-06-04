import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {SubInvoice} from './sub-invoice';

@Injectable({
  providedIn: 'root'
})
export class SubInvoiceService {

  constructor(private http: HttpClient) { }

  getSubInvoice(invoiceNumber: String): Observable<SubInvoice> {
    return this.http.get<SubInvoice>(`api/subinvoices/${invoiceNumber}`);
  }
}
