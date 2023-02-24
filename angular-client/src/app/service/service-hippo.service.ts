import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ServiceHippo } from '../model/serviceHippo';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ServiceHippoService {

  private servicesUrl: string;


  constructor(private http: HttpClient) { 
    this.servicesUrl = 'http://localhost:8080/api/services';
  }

  public findAll(): Observable<ServiceHippo[]> {
    return this.http.get<ServiceHippo[]>(this.servicesUrl);
  }
}
