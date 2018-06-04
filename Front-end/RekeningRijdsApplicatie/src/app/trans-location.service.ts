import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {TransLocation} from './trans-location';

@Injectable({
  providedIn: 'root'
})
export class TransLocationService {

  constructor(private http: HttpClient) { }

  getAllTransLocations(): Observable<TransLocation[]> {
    return this.http.get<TransLocation[]>('api/translocations');
  }

  getTransLocation(serial: String): Observable<TransLocation> {
    return this.http.get<TransLocation>(`api/journeys/${serial}`);
  }
}
