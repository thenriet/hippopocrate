import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceHippo } from '../model/serviceHippo';
import { ServiceHippoService } from '../service/service-hippo.service';

@Component({
  selector: 'app-liste-service',
  templateUrl: './liste-service.component.html',
  styleUrls: ['./liste-service.component.scss']
})
export class ListeServiceComponent implements OnInit {

  services!:ServiceHippo[]

  constructor (private serviceHippo: ServiceHippoService, private router: Router) {

  }

  ngOnInit() {
    this.loadServices();
  }

  loadServices() {
    this.serviceHippo.findAll().subscribe(data => {
      this.services = data;
    })
  }

  seeService(id: number) {
    this.router.navigate(['service', id])
  }
}
