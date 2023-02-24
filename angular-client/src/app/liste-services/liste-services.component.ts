import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-liste-services',
  templateUrl: './liste-services.component.html',
  styleUrls: ['./liste-services.component.scss']
})
export class ListeServicesComponent {
  constructor ( private route: Router){
  }
  ngOnInit():void{
  this.route.navigateByUrl("/listeservices");
  }
}

