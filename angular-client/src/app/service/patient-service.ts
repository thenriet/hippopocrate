import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Patient } from '../model/patient';
import { Observable } from 'rxjs';
import { addPatientModel } from '../model/addPatient-models';

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  private patientsUrl: string;


  constructor(private http: HttpClient) { 
    this.patientsUrl = 'http://localhost:8080/api/patients';
  }

  public findAll(): Observable<Patient[]> {
    return this.http.get<Patient[]>(this.patientsUrl);
  }

  public save(patient: addPatientModel) {
    return this.http.post<addPatientModel>(this.patientsUrl, patient);
  }

}