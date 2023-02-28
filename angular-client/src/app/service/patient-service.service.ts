import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Patient } from '../model/patient';
import { Observable } from 'rxjs/internal/Observable';
import { AddPatient } from '../model/addpatient';


@Injectable()
  // providedIn: 'root'
export class PatientService {
  update(patientForm: AddPatient, id: number) {
    throw new Error('Method not implemented.');
  }

  private patientsUrl: string = 'http://localhost:8080/api/patients';

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
}