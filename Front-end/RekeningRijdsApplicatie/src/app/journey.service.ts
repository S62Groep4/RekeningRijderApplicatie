import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Journey} from './journey';

@Injectable({
  providedIn: 'root'
})
export class JourneyService {

  constructor(private http: HttpClient) { }

  getAllJourneys(): Observable<Journey[]> {
    return this.http.get<Journey[]>('api/journeys');
  }

  getJourney(id: Number): Observable<Journey> {
    return this.http.get<Journey>(`api/journeys/${id}`);
  }
}
