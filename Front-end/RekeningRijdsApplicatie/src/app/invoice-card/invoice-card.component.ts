import {Component, Input, OnInit} from '@angular/core';
import {SubInvoice} from '../sub-invoice';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {JourneyModalComponent} from '../journey-modal/journey-modal.component';

@Component({
  selector: 'app-invoice-card',
  templateUrl: './invoice-card.component.html',
  styleUrls: ['./invoice-card.component.css']
})
export class InvoiceCardComponent implements OnInit {

  @Input() invoice: SubInvoice;

  constructor(private modalService: NgbModal) {
  }

  ngOnInit() {
  }

  open() {
    const modalRef = this.modalService.open(JourneyModalComponent);
    modalRef.componentInstance.journeysUrl = this.invoice.journeysUri;
  }
}
