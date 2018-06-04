import { Component, OnInit } from '@angular/core';
import {SubInvoice} from '../sub-invoice';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-invoices',
  templateUrl: './invoices.component.html',
  styleUrls: ['./invoices.component.css']
})
export class InvoicesComponent implements OnInit {

  invoices: SubInvoice[] = [];
  hashedLicensePlate: String;

  constructor(private route: ActivatedRoute) {
    this.route.params.subscribe(params => {
      this.hashedLicensePlate = params.id;
    });

    console.log(this.hashedLicensePlate);
  }

  ngOnInit() {
    const invoice = new SubInvoice();
    invoice.price = '122';
    invoice.invoiceNumber = 123;
    invoice.country = 'DE';
    invoice.paymentStatus = 'Not paid';
    invoice.invoiceData = 'Idk';
    this.invoices.push(invoice);
  }

}
