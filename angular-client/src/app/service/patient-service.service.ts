import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Patient } from '../model/patient';
import { Observable } from 'rxjs/internal/Observable';


@Injectable()
  // providedIn: 'root'
export class PatientService {

  private patientsUrl: string = 'http://localhost:8080/api/patients';
  private patientsServiceUrl: string ='http://localhost:8080/api/services/';

  constructor(private http: HttpClient) {}

  public findAll(): Observable<Patient[]> {
    return this.http.get<Patient[]>(this.patientsUrl);
  }

  public findAllByService(id: number): Observable<Patient[]> {
    return this.http.get<Patient[]>(this.patientsServiceUrl + id + '/patients');
  }

  getPatientById(id: number): Observable<Patient>{
    return this.http.get<Patient>(`${this.patientsUrl}/${id}`);
  }

  public save(patient: Patient) {
    return this.http.post<Patient>(this.patientsUrl, patient);
  }
}
