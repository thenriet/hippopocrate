import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ServiceHippo } from '../model/serviceHippo';
import { Observable } from 'rxjs';
import { Room } from '../model/room';
import { Bed } from '../model/bed';


@Injectable({
  providedIn: 'root'
})
export class ServiceHippoService {

  private servicesUrl: string;
  private serviceUrl: string;
  private roomsUrl: string;
  private bedsUrl: string;

  constructor(private http: HttpClient) {
    this.servicesUrl = 'http://localhost:8080/api/services';
    this.serviceUrl = 'http://localhost:8080/api/services/'
    this.roomsUrl = 'http://localhost:8080/api/services/'
    this.bedsUrl = 'http://localhost:8080/api/rooms/'
  }

  public findAll(): Observable<ServiceHippo[]> {
    return this.http.get<ServiceHippo[]>(this.servicesUrl);
  }

  public findOneById(serviceId: number): Observable<ServiceHippo> {
    return this.http.get<ServiceHippo>(this.serviceUrl + serviceId);
  }

  public findRooms(serviceId: number): Observable<Room[]> {
    return this.http.get<Room[]>(this.serviceUrl+serviceId+'/rooms')
  }

  public findOneRoomById(roomId: number): Observable<Room> {
    return this.http.get<Room>(this.bedsUrl+roomId)
  }

  public findBeds(roomId: number): Observable<Bed[]> {
    return this.http.get<Bed[]>(this.bedsUrl+roomId+'/beds')
  }
}
