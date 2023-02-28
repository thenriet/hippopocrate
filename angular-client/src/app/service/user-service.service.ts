import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../model/user';
import { Role } from '../model/role';
import { Observable } from 'rxjs/internal/Observable';


@Injectable()
  // providedIn: 'root'
export class UserServiceService {

  private usersUrl = 'http://localhost:8080/api/users';
  private usersDtoUrl = 'http://localhost:8080/api/usersDto';
  private rolesUrl = 'http://localhost:8080/api/users/roles';

  constructor(private http: HttpClient) {}

  public findAll(): Observable<User[]> {
    return this.http.get<User[]>(this.usersDtoUrl);
  }

  public findAllRoles(): Observable<Role[]>{
    return this.http.get<Role[]>(this.rolesUrl);
  }

  public findOneRoleById(roleId: number): Observable<Role> {
    return this.http.get<Role>(this.rolesUrl + '/' + roleId);
  }

  public save(user: User) {
    return this.http.post<User>(this.usersUrl, user);
  }

 }
