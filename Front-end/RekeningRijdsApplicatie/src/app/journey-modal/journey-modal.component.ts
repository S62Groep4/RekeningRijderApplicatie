import {Component, Input, OnInit} from '@angular/core';
import {NgbActiveModal} from '@ng-bootstrap/ng-bootstrap';
import {SubInvoice} from '../sub-invoice';

@Component({
  selector: 'app-journey-modal',
  templateUrl: './journey-modal.component.html',
  styleUrls: ['./journey-modal.component.css']
})
export class JourneyModalComponent implements OnInit {
  @Input() invoice: SubInvoice;

  constructor(public activeModal: NgbActiveModal) { }

  ngOnInit() {
  }

}
