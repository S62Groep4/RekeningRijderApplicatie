import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {AppModule} from './app.module';
import {User} from './user';
import {JwtHelperService} from '@auth0/angular-jwt';

@Injectable({
  providedIn: AppModule
})
export class AuthService {

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  jwtHelper = new JwtHelperService();

  constructor(private http: HttpClient) {
  }

  getToken(): string {
    return localStorage.getItem('token');
  }

  isAuthenticated(): boolean {
    const token = this.getToken();
    return this.jwtHelper.decodeToken(token);
  }

  public getLoggedInUsername(): string {
    const token = this.getToken();
    return this.jwtHelper.decodeToken(token).sub;
  }

  public login(email: String, password: String): Observable<any> {
    const user = new User(email, password);
    return this
      .http
      .post('url', user, {headers: this.httpOptions.headers, observe: 'response'});
  }

  public logout(): void {
    localStorage.removeItem('token');
  }
}
