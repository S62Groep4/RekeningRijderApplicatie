import { Component, OnInit } from '@angular/core';
import {Vehicle} from '../vehicle';
import { VehicleService } from '../vehicle.service';

@Component({
  selector: 'app-vehicles',
  templateUrl: './vehicles.component.html',
  styleUrls: ['./vehicles.component.css']
})
export class VehiclesComponent implements OnInit {

  vehicles: Vehicle[] = [];

  constructor(private vehicleService : VehicleService) { }

  ngOnInit() {
    const testVehicle = new Vehicle();
    testVehicle.hashedLicensePlate = '1234';
    this.vehicles.push(testVehicle);
  }

}
