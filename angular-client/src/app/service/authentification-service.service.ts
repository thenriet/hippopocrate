import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { map, Observable } from 'rxjs';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root',
})
export class AuthentificationService {

    USER_NAME_SESSION_ATTRIBUTE_NAME = 'token'

    public username!: string;
    public password!: String;
    public currentUser!: User;

  private url = 'http://localhost:8080/api/login';
  private urlLogout = 'http://localhost:8080/logout';

  constructor(private http: HttpClient, private router: Router) {
  }

  // login(username: string, password: String) {
  //   let url = this.url;
  //   return this.http.post(url, this.createBasicAuthToken(username, password)).pipe(map((res) =>
  //     {
  //     this.username = username;
  //     this.password = password;
  //     this.registerSuccessfulLogin(username, password);
  //   }));
  // }

  // createBasicAuthToken(username: String, password: String) {
  //   return 'Basic ' + window.btoa(username + ":" + password)
  // }

  // registerSuccessfulLogin(username: string, password: String) {
  //   sessionStorage.setItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME, username);
  // }

  logout() {
    this.http.get(this.urlLogout);
    this.router.navigate(['']);
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME);
    if (user === null) return false;
    return true;
  }

  getUserRole(username: string) {
    this.http.get
  }

  
}
