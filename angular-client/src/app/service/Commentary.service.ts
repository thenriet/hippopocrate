import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import {Commentary} from "../model/Commentary"

@Injectable({
  providedIn: 'root'
})
export class CommentaryService {
    private CommentaryUrl: string = 'http://localhost:8080/api/suivipatient';
    constructor(private http: HttpClient) {}
    
    public save(commentary: Commentary, patient_id:number) {
        return this.http.post<Commentary>(`${this.CommentaryUrl}/${patient_id}`, commentary);
      }

    getCommentaryByPatientId (patient_id:number): Observable <Commentary>{
        return this.http.get<Commentary>(`${this.CommentaryUrl}/${patient_id}`);
    }

    public findAllComments(id:number): Observable<Commentary[]> {
        return this.http.get<Commentary[]>(this.CommentaryUrl);
      }
}