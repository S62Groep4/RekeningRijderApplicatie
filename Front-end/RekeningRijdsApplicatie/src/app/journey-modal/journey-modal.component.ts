import {Component, Input, OnInit} from '@angular/core';
import {NgbActiveModal} from '@ng-bootstrap/ng-bootstrap';
import {SubInvoice} from '../sub-invoice';
import {Journey} from '../journey';
import {TransLocation} from '../trans-location';

@Component({
  selector: 'app-journey-modal',
  templateUrl: './journey-modal.component.html',
  styleUrls: ['./journey-modal.component.css']
})
export class JourneyModalComponent implements OnInit {
  @Input() journeysUrl: String;
  journeys: Journey[] = [];

  constructor(public activeModal: NgbActiveModal) {
    // Ophalen van journeys aan de hand van url.
  }

  ngOnInit() {
    const journey1 = new Journey();
    journey1.id = 1;
    const translocation1 = new TransLocation();
    translocation1.countryCode = 'DE';
    translocation1.dateTime = '04/06/2018';
    translocation1.lat = 51.252;
    translocation1.long = 2.523;
    translocation1.serialNumber = '12244124';
    const translocation2 = new TransLocation();
    translocation2.countryCode = 'DE';
    translocation2.dateTime = '04/06/2018';
    translocation2.lat = 52.252;
    translocation2.long = 3.523;
    translocation2.serialNumber = '12244124';
    const translocation3 = new TransLocation();
    translocation3.countryCode = 'DE';
    translocation3.dateTime = '04/06/2018';
    translocation3.lat = 54.252;
    translocation3.long = 1.523;
    translocation3.serialNumber = '12244124';
    journey1.translocations = [];
    journey1.translocations.push(translocation1, translocation2, translocation3);
    this.journeys.push(journey1);
  }

}
