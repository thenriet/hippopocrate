import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-form-login',
  templateUrl: './form-login.component.html',
  styleUrls: ['./form-login.component.scss']
})
export class FormLoginComponent implements OnInit {
  model: any = {};

  constructor(
      private route: ActivatedRoute,
      private router: Router,
      private http: HttpClient
  ) { }

  ngOnInit() {
      sessionStorage.setItem('token', '');
  }

  login() {
    let url = 'http://localhost:8080/api/login';
    this.http.post<Observable<boolean>>(url, {
        name: this.model.username,
        password: this.model.password
    }).subscribe(isValid => {
        if (isValid) {
            sessionStorage.setItem('token', window.btoa(this.model.username + ':' + this.model.password));
            this.router.navigate(['accueil']);
        } else {
            alert("Authentication failed.")
        }
    });
}
}
