import { Component } from '@angular/core';
import { FormLoginComponent } from '../form-login/form-login.component';
import { AuthentificationService } from '../service/authentification-service.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss'],
})
export class NavbarComponent {
  
  isLoggedIn = false;

  constructor(private authenticationService: AuthentificationService) {}

  ngOnInit() {
    this.isLoggedIn = this.authenticationService.isUserLoggedIn();
  }

  handlelogout() {
    this.authenticationService.logout();
  }

}
