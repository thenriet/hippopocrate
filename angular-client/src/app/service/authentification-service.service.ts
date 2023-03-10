import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { map, Observable } from 'rxjs';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root',
})
export class AuthentificationService {
  USER_NAME_SESSION_ATTRIBUTE_NAME = 'user';

  public username!: string;
  public password!: String;

  private url = 'http://localhost:8080/api/login';
  private urlLogout = 'http://localhost:8080/logout';
  private urlUsersRole = 'http://localhost:8080/api/users/role';
  private urlUserId = 'http://localhost:8080/api/users/id/'

  constructor(private http: HttpClient, private router: Router) {}

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

  registerSuccessfulLogin(username: string, password: string) {
    this.username = username;
    this.password = password;
    sessionStorage.setItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME, username);
  }

  logout() {
    this.http.get(this.urlLogout);
    sessionStorage.removeItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME);
    this.username = '';
    // this.password = '';
    this.router.navigate(['']);
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME);
    if (user === '') {
      return false;
    } else {
      return true;
    }
  }

  getLoggedInUserName() {
    let user = sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME)
    if (user === null) return ''
    return user
  }

  getUserRole(){
    return this.http.get(`${this.urlUsersRole}/${this.getLoggedInUserName()}`, {responseType: 'text'});
  }

  getUserIdByUsername(username: String){
    return this.http.get(this.urlUserId + username, {responseType: 'text'});
  }
}
