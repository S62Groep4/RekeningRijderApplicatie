import {Component, OnInit} from '@angular/core';
import {AuthService} from '../auth.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css'],
  providers: [AuthService]
})
export class NavBarComponent implements OnInit {

  constructor(private authService: AuthService, private router: Router) {
  }

  ngOnInit() {
  }

  isLoggedIn(): boolean {
    return !(localStorage.getItem('token') === null);
  }

  logout(): void {
    this.authService.logout();
    this.router.navigate(['/login']);
  }
}
