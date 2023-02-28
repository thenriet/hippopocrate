import { Component } from '@angular/core';
import { AuthentificationService } from '../service/authentification-service.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss'],
})
export class NavbarComponent {
  role!: String;
  isLoggedIn!: boolean;

  constructor(private authenticationService: AuthentificationService) {}

  ngOnInit() {
    this.isLoggedIn = this.authenticationService.isUserLoggedIn();
    this.authenticationService.getUserRole().subscribe((data) => {
      this.role = data;
      console.log(this.role)
    });
  }

  handlelogout() {
    this.authenticationService.logout();
  }
}
