import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Vehicle } from './vehicle';

@Injectable({
  providedIn: 'root'
})
export class VehicleService {

  constructor(private http: HttpClient) { }

  getUserVehicles(userid : String) : Observable<Vehicle[]>{
    return this.http.get<Vehicle[]>('api/vehicles/' + userid);
  }
}
