import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../model/user';
import { Observable } from 'rxjs/internal/Observable';


@Injectable()
  // providedIn: 'root'
export class UserServiceService {

  private usersUrl = 'http://localhost:8080/api/users';
  private rolesUrl = 'http://localhost:8080/api/users/roles';

  constructor(private http: HttpClient) {}

  public findAll(): Observable<User[]> {
    return this.http.get<User[]>(this.rolesUrl);
  }
}
