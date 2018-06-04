import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {AppModule} from './app.module';

@Injectable({
  providedIn: AppModule
})
export class AuthService {

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  constructor(private http: HttpClient) {
  }

  public login(username: string, password: string): Observable<any> {
    // const user = new User(username, password);
    return this
      .http
      .post('url', null, {headers: this.httpOptions.headers, observe: 'response'});
  }
}
