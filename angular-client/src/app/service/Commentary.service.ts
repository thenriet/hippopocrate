import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import {Commentary} from "../model/Commentary"

@Injectable()
export class CommentaryService {
    private CommentaryUrl: string = 'http://localhost:8080/api/suivipatient';
    constructor(private http: HttpClient) {}
    
    public save(commentary: Commentary) {
        return this.http.post<Commentary>(this.CommentaryUrl, commentary);
      }

    getCommentaryById (id:number): Observable <Commentary>{
        return this.http.get<Commentary>(`${this.CommentaryUrl}/${id}`);
    }

    public findAllComments(id:number): Observable<Commentary[]> {
        return this.http.get<Commentary[]>(this.CommentaryUrl);
      }
}