import {Component, Input, OnInit} from '@angular/core';
import {SubInvoice} from '../sub-invoice';

@Component({
  selector: 'app-invoice-card',
  templateUrl: './invoice-card.component.html',
  styleUrls: ['./invoice-card.component.css']
})
export class InvoiceCardComponent implements OnInit {

  @Input() invoice: SubInvoice;

  constructor() { }

  ngOnInit() {
  }

}
