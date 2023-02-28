import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs/internal/Observable';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  constructor(private http: HttpClient, private router: Router) {}

  ngOnInit() {
    
  //   let headers: HttpHeaders = new HttpHeaders({
  //     'Authorization': 'Basic ' + sessionStorage.getItem('token')
  // });
  }
}
