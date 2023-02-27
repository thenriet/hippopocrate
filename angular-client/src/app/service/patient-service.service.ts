import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Patient } from '../model/patient';
import { Observable } from 'rxjs/internal/Observable';


@Injectable()
  // providedIn: 'root'
export class PatientService {

  private patientsUrl: string = 'http://localhost:8080/api/patients';
  private idUrl: string= 'http://localhost:8080/api/updatepatient';

  constructor(private http: HttpClient) {}

  public findAll(): Observable<Patient[]> {
    return this.http.get<Patient[]>(this.patientsUrl);
  }

  getPatientById(id: number): Observable<Patient>{
    return this.http.get<Patient>(`${this.patientsUrl}/${id}`);
  }

  public save(patient: Patient) {
    return this.http.post<Patient>(this.patientsUrl, patient);
  }
  
  getDetailsById (id:number): Observable<Patient>{
      return this.http.get<Patient>(`${this.idUrl}/${id}`);
  }

  public update(patient:Patient, id:number){
    return this.http.post<Patient> ( "http://localhost:8080/api/updatepatient",patient);
  }
}