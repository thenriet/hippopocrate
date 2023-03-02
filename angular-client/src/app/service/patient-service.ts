import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Patient } from '../model/patient';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  private patientsUrl: string;
  private idUrl: string;

  constructor(private http: HttpClient) { 
    this.patientsUrl = 'http://localhost:8080/api/patients';
    this.idUrl = 'http://localhost:8080/api/updatepatient';
  }

  public findAll(): Observable<Patient[]> {
    return this.http.get<Patient[]>(this.patientsUrl);
  }

  public getPatientById(id: number): Observable<Patient>{
    return this.http.get<Patient>(`${this.patientsUrl}/${id}`);
  }

  public save(patient: Patient) {
    return this.http.post<Patient>(this.patientsUrl, patient);
  }

  public update(patient:Patient, id:number){
    return this.http.put<Patient>(`${this.idUrl}/${id}`, patient);
  }

}