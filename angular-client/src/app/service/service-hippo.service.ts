import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ServiceHippo } from '../model/serviceHippo';
import { Observable } from 'rxjs';
import { Room } from '../model/room';


@Injectable({
  providedIn: 'root'
})
export class ServiceHippoService {

  private servicesUrl: string;
  private serviceUrl: string;
  private roomsUrl: string;



  constructor(private http: HttpClient) { 
    this.servicesUrl = 'http://localhost:8080/api/services';
    this.serviceUrl = 'http://localhost:8080/api/services/'
    this.roomsUrl = 'http://localhost:8080/api/services/'
  }

  public findAll(): Observable<ServiceHippo[]> {
    return this.http.get<ServiceHippo[]>(this.servicesUrl);
  }

  public findOneById(serviceId: string): Observable<ServiceHippo> {
    return this.http.get<ServiceHippo>(this.serviceUrl + serviceId);
  }

  public findRooms(serviceId: string): Observable<Room[]> {
    return this.http.get<Room[]>(this.roomsUrl+serviceId+'/rooms')
  }
}
