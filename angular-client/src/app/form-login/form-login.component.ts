import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { User } from '../model/user';
import { AuthentificationService } from '../service/authentification-service.service';

@Component({
  selector: 'app-form-login',
  templateUrl: './form-login.component.html',
  styleUrls: ['./form-login.component.scss'],
})
export class FormLoginComponent implements OnInit {
  model: any = {};

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private http: HttpClient,
    private authService: AuthentificationService
  ) {}

  ngOnInit() {
    sessionStorage.setItem(
      this.authService.USER_NAME_SESSION_ATTRIBUTE_NAME,
      ''
    );
  }

  login() {
    let url = 'http://localhost:8080/api/login';
    this.http
      .post<Observable<boolean>>(url, {
        name: this.model.username,
        password: this.model.password,
      })
      .subscribe((isValid) => {
        if (isValid) {
          // sessionStorage.setItem(
          //   'user',
          //   window.btoa(this.model.username)
          // );
          this.authService.registerSuccessfulLogin(
            this.model.username,
            this.model.password
          );
          console.log(this.authService.isUserLoggedIn());
          //   this.model.password
          // );
          this.router.navigate(['accueil']);
        } else {
          alert('Impossible de vous identifier');
        }
      });

    //   this.authService.login(this.model.username, this.model.password).subscribe((result) => {
    //       this.router.navigate(['accueil']);
    //   })
    // }
  }
}
