import {Component, OnInit} from '@angular/core';
import {AuthService} from '../auth.service';
import {User} from '../user';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [AuthService]
})
export class LoginComponent implements OnInit {

  user: User = new User('', '');
  error: String;

  constructor(private authService: AuthService, private router: Router) {
  }

  ngOnInit() {
  }

  login(): void {
    this.authService.login(this.user.email, this.user.password).subscribe(res => {
      localStorage.setItem('token', res.headers.get('Authorization'));
      this.router.navigate(['/home']);
    }, err => {
      if (err.status === 401) {
        this.error = 'Email or password incorrect';
      } else {
        this.error = 'Unknown error';
      }
    });
  }

}
