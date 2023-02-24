import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-page-accueil',
  templateUrl: './page-accueil.component.html',
  styleUrls: ['./page-accueil.component.scss']
})
export class PageAccueilComponent {
  constructor ( private route: Router){
  }
  ngOnInit():void{
  this.route.navigateByUrl("/accueil");
  }
}
